package com.musicstore.controller;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.musicstore.servlet.main;
import com.musicstore.ws.Account;
import com.musicstore.ws.Address;
import com.musicstore.ws.OrderServiceProxy;

/**
 * @author shobhna
 *
 */
/* 
 *This class is used for managing all account related requests
 */
public class AccountController {
	private static Logger logger = Logger.getLogger(AccountController.class.getName());

	/**
	 * @param path
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * method that process all the requests related to account that come from the main servlet
	 */
	public void accountRequests(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (path.toLowerCase().equals("/logout")) {
			signout(request, response);
		} else if (path.equals("/login")) {
			checkSigninRequest(request, response);
		} else if (path.equals("/createaccount")) {
			createAccount(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 */
	//Used for signout from the project and setting the authentication false
	private void createAccount(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter(ResourceUtility.usernameAttr);
		String password = request.getParameter(ResourceUtility.passwordAttr);
		String confirmPassword = request.getParameter(ResourceUtility.confirmPwdAttr);
		String email = request.getParameter(ResourceUtility.emailattr);
		String firstname = request.getParameter(ResourceUtility.firstNameAttr);
		String lastname = request.getParameter(ResourceUtility.lastNameAttr);
		String street = request.getParameter(ResourceUtility.streetAttr);
		String city = request.getParameter(ResourceUtility.cityAttr);
		String province = request.getParameter(ResourceUtility.provinceAttr);
		String zip = request.getParameter(ResourceUtility.zipAttr);
		String country = request.getParameter(ResourceUtility.countryAttr);
		String phone = request.getParameter(ResourceUtility.phoneAttr);

		Account account = new Account();
		account.setEmail(email);
		account.setFirstname(firstname);
		account.setLastname(lastname);
		account.setPswrd(password);
		account.setUsername(username);
		Address address = new Address();
		address.setCountry(country);
		address.setZip(zip);
		address.setPhone(phone);
		address.setStreet(street);
		address.setCity(city);
		address.setProvince(province);
		account.setAddress(address);

		OrderServiceProxy proxy = new OrderServiceProxy();
		boolean accountExists = false;
		boolean passwordMatch = password.equals(confirmPassword);
		try {
			Account existingAcc = proxy.getAccountByUserName(username);
			if (existingAcc.getEmail() != null) {
				accountExists = true;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage());
			logger.error("Create Account Failed");
			e1.printStackTrace();
		}
		if (accountExists || !passwordMatch) {
			logger.error("account already exists or password matched");
			if (accountExists)
				request.setAttribute(ResourceUtility.servletMessage, ResourceUtility.userExists);
			
			if (!passwordMatch)
				request.setAttribute(ResourceUtility.servletMessage, ResourceUtility.passwordNotMatch);
		
			request.setAttribute("account", account);
			try {
				request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
				return;
			} catch (ServletException e) {
				logger.error(e.getMessage());
				// TODO Auto-generated catch block

				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Account accountNew = null;
		try {
			accountNew = proxy.createAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		if (accountNew != null) {
			request.getSession().setAttribute(ResourceUtility.usernameAttr, username);
			request.getSession().setAttribute(ResourceUtility.loggedName,
					account.getLastname() + " " + account.getFirstname());
			request.getSession().setAttribute("authenticated", true);
			request.setAttribute(ResourceUtility.loggedName, account.getLastname() + "  " + account.getFirstname());
			request.getSession().setAttribute(ResourceUtility.passwordAttr, password);
			request.getSession().setAttribute(SessionConstants.accountAttr, accountNew);
			try {
				request.getRequestDispatcher("/categories.jsp").forward(request, response);
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

	}

	/**
	 * @param request
	 * @param response
	 */
	private void checkSigninRequest(HttpServletRequest request, HttpServletResponse response) {
		SessionConstants.clearSession(request.getSession(), SessionConstants.cdAttr);
		String username, password;
		username = request.getParameter(ResourceUtility.usernameAttr);
		password = request.getParameter(ResourceUtility.passwordAttr);
		Account account = getAccount(username, password);
		String email = account.getEmail();
		boolean validAccount = email != null;

		// Managing if login was successful or not
		if (validAccount) {

			request.getSession().setAttribute(ResourceUtility.usernameAttr, username);
			request.getSession().setAttribute(ResourceUtility.loggedName,
					account.getLastname() + account.getFirstname());
			request.getSession().setAttribute("authenticated", true);
			request.setAttribute(ResourceUtility.loggedName, account.getLastname() + "  " + account.getFirstname());
			request.getSession().setAttribute(ResourceUtility.passwordAttr, password);
			request.getSession().setAttribute(SessionConstants.accountAttr, account);
			String lastVisitedPage = ((String) request.getSession()
					.getAttribute(ResourceUtility.lastActionPath)) == null
							? (String) request.getContextPath() + "/categories"
							: (String) request.getSession().getAttribute(ResourceUtility.lastActionPath);
			System.err.println("Last visited page: " + lastVisitedPage);

			try {
				try {
					response.sendRedirect(lastVisitedPage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.getSession().setAttribute("authenticated", false);
			request.getSession().setAttribute(ResourceUtility.loggedName, "");
			request.setAttribute(ResourceUtility.loggedName, "");
			request.setAttribute(ResourceUtility.servletMessage, ResourceUtility.loginFailMessage);
			try {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
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

	}

	private void signout(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().setAttribute(ResourceUtility.usernameAttr, "");
		request.getSession().setAttribute(ResourceUtility.loggedName, "");
		request.getSession().setAttribute(ResourceUtility.cartAttr, null);
		request.getSession().setAttribute("authenticated", false);
		request.setAttribute(ResourceUtility.loggedName, "");
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (ServletException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * use to get account info by using web services
	 */
	private Account getAccount(String username, String password) {
		OrderServiceProxy proxy = new OrderServiceProxy();
		try {
			Account account = proxy.getAccount(username, password);
			return account;
		} catch (RemoteException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
