package com.musicstore.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicstore.ws.Account;
import com.musicstore.ws.Cd;
import com.musicstore.ws.CreditCardDetails;
import com.musicstore.ws.OrderServiceProxy;
import com.musicstore.ws.Po;
import com.musicstore.ws.Poitem;
import com.musicstore.ws.cart.ShoppingCart;

/**
 * @author vikas
 *
 */
/* this class is used for viewing, adding, removing items from cart
 * 
 */
public class OrderController {
	private static Logger logger = Logger.getLogger(OrderController.class.getName());

	public void orderRequests(String path, HttpServletRequest request, HttpServletResponse response) {
		if (path.equals("/cart")) {
			getCart(request, response);
		} else if (path.toLowerCase().equals("/checkout")) {
			getCartWithAccount(request, response);
		} else if (path.toLowerCase().equals("/addtocart")) {
			getShoppingCart(request, response);
		} else if (path.toLowerCase().equals("/placeorder")) {
			placeOrder(request, response);
		}

	}
/*usedd for confirmation for order
 * returns order confirmation object
 */
	private void placeOrder(HttpServletRequest request, HttpServletResponse response) {
		String ccNumber = request.getParameter(ResourceUtility.ccNumAttr);
		String nameOnCC = request.getParameter(ResourceUtility.nameOnCCAttr);
		String month = request.getParameter(ResourceUtility.monthAttr);
		String year = request.getParameter(ResourceUtility.yearAttr);
		@SuppressWarnings("unused")
		String cctype = request.getParameter(ResourceUtility.ccTypeAttr);
		String cccode = request.getParameter(ResourceUtility.ccCodeAttr);
		CreditCardDetails ccinfo = new CreditCardDetails();
		ccinfo.setCcNumber(ccNumber);
		ccinfo.setNameOnCC(nameOnCC);
		ccinfo.setCcvCode(cccode);
		ccinfo.setExpMonth(month);
		ccinfo.setExpYear(year);
		OrderServiceProxy proxy = new OrderServiceProxy();
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr);

		Po order = cart.getOrder();
		Account account = (Account) request.getSession().getAttribute(SessionConstants.accountAttr);
		order.setFname(account.getFirstname());
		order.setLname(account.getLastname());
		Po orderPlaced = null;
		try {

			orderPlaced = proxy.orderConfirmation(order, ccinfo);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		request.setAttribute("orderPlaced", orderPlaced);
		request.getSession().setAttribute(SessionConstants.cartAttr, null);
		try {
			request.getRequestDispatcher("/orderstatus.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
/*
 * used for checkout
 * returns info about product order and shipping address
 */
	private void getCartWithAccount(HttpServletRequest request, HttpServletResponse response) {
		ShoppingCart cart = getShoppingCartAccount(request);
		request.setAttribute(ResourceUtility.cartAttr, cart);
		try {
			request.getRequestDispatcher("/checkout.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**used for adding and removing items from the cart
	 * @param request
	 * @param response
	 */
	private void getShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		try {
			ShoppingCart cart = getShoppingCart(request);
			request.setAttribute(ResourceUtility.cartAttr, cart);

			request.getRequestDispatcher("/cart").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	private ShoppingCart getShoppingCartAccount(HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr);

		if (cart == null) {

			return null;

		}

		Account account = (Account) request.getSession().getAttribute(SessionConstants.accountAttr);

		cart.getOrder().setAddressBean(account.getAddress());

		return cart;
	}

	/**
	 * @param request
	 * @return
	 */
	private ShoppingCart getShoppingCart(HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr);
		String cdId = request.getParameter(ResourceUtility.cdidAttr);
		if (cdId == null && request.getParameter("remove") != null) {
			cdId = request.getParameter("remove");
			List<Poitem> lstPoitems = new ArrayList<Poitem>();
			Poitem[] pois = cart.getOrder().getPoitems();
			for (int i = 0; i < pois.length; i++) {
				Poitem poi = pois[i];
				String cd1 = poi.getCd().getCdid();
				if (new String(cd1).equals(cdId)) {

				} else {
					lstPoitems.add(poi);
				}
			}
			/*
			 * count total price of remaining product
			 */
			int lstcnt = lstPoitems.size();
			int total = 0;
			Poitem[] tmpitems = null;
			cart.setCount(lstcnt);
			if (lstcnt > 0) {
				tmpitems = new Poitem[lstcnt];
				lstPoitems.toArray(tmpitems);

				for (int i = 0; i < tmpitems.length; i++) {
					total += tmpitems[i].getCd().getPrice();
				}
			}
			cart.setTotal(total);
			cart.getOrder().setPoitems(tmpitems);
			if (total == 0) {
				SessionConstants.clearSession(request.getSession(), SessionConstants.cartAttr);
			} else {
				request.getSession().setAttribute(SessionConstants.cartAttr, cart);
			}
		}

		else {

			Cd cd = getProduct(cdId);
			if (cart == null && cd != null) {
				cart = new ShoppingCart();
				Po po = new Po();
				List<Poitem> tmpItems = new ArrayList<Poitem>();
				Poitem tmp = new Poitem();
				tmp.setCd(cd);
				tmpItems.add(tmp);
				Poitem[] items = new Poitem[tmpItems.size()];
				tmpItems.toArray(items);
				po.setPoitems(items);
				cart.setOrder(po);
				cart.setCount(1);
				cart.setTotal(cd.getPrice());
				request.getSession().setAttribute(SessionConstants.cartAttr, cart);
			} else {
				Po po = cart.getOrder();
				Poitem[] items = po.getPoitems();
				boolean itemExists = false;
				for (int i = 0; i < items.length; i++) {
					String cdd = items[i].getCd().getCdid();
					String cdd1 = cd.getCdid();
					if (cdd.equals(cdd1)) {
						itemExists = true;
						break;
					}
				}
/*
 * used to count total price of all the items in the cart
 */
				if (!itemExists) {
					List<Poitem> lst = new ArrayList<Poitem>();
					lst.addAll(Arrays.asList(items));
					Poitem item = new Poitem();
					item.setCd(cd);
					lst.add(item);
					Poitem[] tmpitems = new Poitem[lst.size()];
					lst.toArray(tmpitems);
					po.setPoitems(tmpitems);
					cart.setCount(tmpitems.length);
					int total = 0;
					for (int i = 0; i < tmpitems.length; i++) {
						total += tmpitems[i].getCd().getPrice();
					}
					cart.setTotal(total);
					cart.setOrder(po);
					request.getSession().setAttribute(SessionConstants.cartAttr, cart);
				}

			}
		}
		return cart;
	}

	/**used to view the cart
	 * @param request
	 * @param response
	 */
	public void getCart(HttpServletRequest request, HttpServletResponse response) {
		try {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr);
			request.getSession().setAttribute(SessionConstants.cartAttr, cart);
			
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @param CdId
	 * @return
	 */
	private Cd getProduct(String CdId) {
		OrderServiceProxy proxy = new OrderServiceProxy();
		try {
			return proxy.getCartItem(CdId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
