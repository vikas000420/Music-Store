package com.musicstore.ws;

import javax.jws.WebService;

import com.musicstore.model.Account;
import com.musicstore.model.Cd;
import com.musicstore.model.CreditCardDetails;
import com.musicstore.model.Po;
import com.musicstore.model.Products;
import com.musicstore.model.dao.CDs.AccountManagerDAO;
import com.musicstore.model.dao.CDs.OrderManagerDAO;
import com.musicstore.model.dao.CDs.ProductsDAO;

/**
 * @author sowjanya
 *
 */
@WebService(endpointInterface = "com.musicstore.ws.OrderService")
public class OrderServiceImpl implements OrderService {
	
	/* Gets the full details of account by entering username and password
	 * 
	 */
	@Override
	public Account getAccount(String username, String password) {
		AccountManagerDAO accountManager = new AccountManagerDAO();
		Account acc = new Account();
		acc.setUsername(username);
		acc.setPswrd(password);
		Account account = accountManager.getAccount(acc);
		boolean status = account == null;
		if (!status) {
			account.setPswrd("");
		}
		return account;
	}

	/* Checks the username exits or not 
	 * 
	 */
	@Override
	public Account getAccountByUserName(String username) {
		AccountManagerDAO accountManager = new AccountManagerDAO();
		Account account = accountManager.getAccountByUserName(username);
		boolean status = account == null;
		if (!status) {
			account.setPswrd("");
		} else {
			account = new Account();
		}
		return account;
	}

	/* Creates new account 
	 * 
	 */
	@Override
	public Account createAccount(Account account) {
		AccountManagerDAO accountManager = new AccountManagerDAO();
		Account returnAcc = accountManager.createAccount(account);
		return returnAcc;
	}

	/* Saves the ordered items in the cart
	 * 
	 */
	@Override
	public Po saveOrder(Po cart) {
		OrderManagerDAO om = new OrderManagerDAO();
		om.saveOrder(cart);
		return new Po();

	}

	/* Gets confirmation of order
	 * returns order, ccinfo
	 */
	@Override
	public Po orderConfirmation(Po order, CreditCardDetails ccinfo) {
		OrderManagerDAO om = new OrderManagerDAO();
		return om.postOrder(order, ccinfo);

	}

	/* Gets multiple items 
	 * return items
	 */
	@Override
	public Products getCartItems(String items) {

		ProductsDAO productsDAO = new ProductsDAO();
		return productsDAO.getCartProducts(items);
	}

	/* Gets single item
	 * returns item
	 */
	@Override
	public Cd getCartItem(String item) {
		ProductsDAO productsDAO = new ProductsDAO();
		return productsDAO.getCartProducts(item).getProducts().get(0);
	}

}
