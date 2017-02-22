package com.musicstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicstore.controller.AccountController;
import com.musicstore.controller.CDCatalogController;
import com.musicstore.controller.OrderController;
import com.musicstore.controller.ResourceUtility;
import com.musicstore.controller.SessionConstants;
import com.musicstore.ws.cart.ShoppingCart;

/**
 * Servlet implementation class main
 */

@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      Used to handle all the requests coming from the users 
	 *      basically used for get information
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (request.getSession().getAttribute("authenticated") == null
				|| (boolean) request.getSession().getAttribute("authenticated") == false) {
			request.setAttribute(ResourceUtility.loggedName, "");
		}

		if (request.getSession().getAttribute(SessionConstants.cartAttr) == null) {
			request.getSession().setAttribute(ResourceUtility.cartItems, "");
		} else if ((ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr) != null) {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(SessionConstants.cartAttr);
			request.getSession().setAttribute(ResourceUtility.cartItems, Integer.toString(cart.getCount()));
		}

		if (path.equals("/categories") || path.equals("/products") || path.equals("/product")) {
			// Product and category processing
			CDCatalogController catcontroller = new CDCatalogController();
			catcontroller.processActionRequests(path, request, response);
		} else if (path.equals("/addtocart")) {
			OrderController orderController = new OrderController();
			orderController.orderRequests(path, request, response);
		} else if (path.equals("/login")) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (path.equals("/createaccount")) {
			request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
		} else if (path.equals("/checkout")) {
			OrderController orderController = new OrderController();
			orderController.orderRequests(path, request, response);
		}
		if (path.equals("/cart")) {
			OrderController orderController = new OrderController();
			orderController.orderRequests(path, request, response);
		} else if (path.equals("/account") || path.equals("/logout")) {
			// Account related processing.
			AccountController accountController = new AccountController();
			accountController.accountRequests(path, request, response);
		} else if (path.equals("/orderStatus")) {
			// OrderManager orderMgr = new OrderManager();
			// orderMgr.processActionRequests(actionPath, request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      Used to directs post request of users
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		if (path.equals("/login") || path.equals("/createaccount")) {
			AccountController acc = new AccountController();
			acc.accountRequests(path, request, response);
		} else if (path.equals("/addToCart") || path.equals("/viewCart") || path.equals("/removeFromCart")
				|| path.equals("/placeorder") || path.equals("/paymentManager")) {

			OrderController ord = new OrderController();
			System.err.println("ActionPath: " + path);
			ord.orderRequests(path, request, response);
		}
	}

}
