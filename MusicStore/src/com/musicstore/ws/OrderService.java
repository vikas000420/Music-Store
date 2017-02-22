package com.musicstore.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.musicstore.model.Account;
import com.musicstore.model.Cd;
import com.musicstore.model.Products;
import com.musicstore.model.CreditCardDetails;
import com.musicstore.model.Po;

/**
 * @author sowjanya
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface OrderService {
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@WebMethod
	public Account getAccount(@WebParam(name = "username") String username,
			@WebParam(name = "password") String password);

	/**
	 * @param username
	 * @return
	 */
	@WebMethod
	public Account getAccountByUserName(@WebParam(name = "username") String username);

	/**
	 * @param account
	 * @return
	 */
	@WebMethod
	public Account createAccount(@WebParam(name = "account") Account account);

	/**
	 * @param order
	 * @return
	 */
	@WebMethod
	public Po saveOrder(@WebParam(name = "cart") Po order);

	/**
	 * @param order
	 * @param ccinfo
	 * @return
	 */
	@WebMethod
	public Po orderConfirmation(@WebParam(name = "order") Po order,
			@WebParam(name = "ccinfo") CreditCardDetails ccinfo);

	/**
	 * @param items
	 * @return
	 */
	@WebMethod
	public Products getCartItems(@WebParam(name = "items") String items);

	/**
	 * @param item
	 * @return
	 */
	@WebMethod
	public Cd getCartItem(@WebParam(name = "item") String item);
}
