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

import com.musicstore.ws.CDCatalogServiceProxy;
import com.musicstore.ws.Cd;

/**
 * @author shobhna
 *
 */
/*
 * used to manage product related requests
 */
public class CDCatalogController {
	private static Logger logger = Logger.getLogger(CDCatalogController.class.getName());

	/**
	 * main servlet requests will be processed by method
	 * 
	 * @param actionPath
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void processActionRequests(String actionPath, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (actionPath.equals("/categories")) {
			getCategories(request, response);
		} else if (actionPath.equals("/products")) {
			getProducts(request, response);
		} else if (actionPath.equals("/product")) {
			getProduct(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getCategories(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionConstants.clearSession(request.getSession(), SessionConstants.cdAttr);

		String category = (String) request.getAttribute(ResourceUtility.categoriesAttr);

		List<String> categories = getCategoryList();
		List<Cd> products = getTopProducts();
		request.getSession().setAttribute(ResourceUtility.categoriesAttr, categories);
		request.getSession().setAttribute("TopProducts", products);

		List<Cd> productsList = getProductsForCategory(category == null ? "" : category);

		// Managing if productList was empty or not
		if (!productsList.isEmpty()) {
			request.setAttribute(ResourceUtility.productsListAttr, productsList);
		}

		String lastVisitedPath = request.getRequestURL().toString();

		if (request.getQueryString() != null) {
			lastVisitedPath += ("?" + request.getQueryString());
		}
		request.setAttribute("TopProducts", products);
		request.getSession().setAttribute(ResourceUtility.lastActionPath, lastVisitedPath);
		request.getRequestDispatcher("/categories.jsp").forward(request, response);
	}
/*
 * This method is used to get top selling products from he database
 * @return list of top selling products
 */
	private List<Cd> getTopProducts() {
		List<Cd> lst = new ArrayList<Cd>();

		lst.add(getProductById("cd001"));
		lst.add(getProductById("cd005"));
		lst.add(getProductById("cd017"));
		lst.add(getProductById("cd009"));

		return lst;
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * This method is sending response for specific productinfo request
	 */
	private void getProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cd product = getProductById((String) request.getParameter("cdid"));
		request.setAttribute(ResourceUtility.productsInfoAttr, product);
		request.getRequestDispatcher("/product.jsp").forward(request, response);

	}
	/**
	 * this method is used to get top selling product info of specifi id from the database 
	 * @param cdid
	 * @return product
	 */

	private Cd getProductById(String cdid) {
		CDCatalogServiceProxy proxy = new CDCatalogServiceProxy();

		Cd product = null;
		try {
			product = proxy.getProductInfo(cdid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return product;
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionConstants.clearSession(request.getSession(), SessionConstants.cdAttr);
		String category = request.getParameter(ResourceUtility.categoryAttr);
		List<String> categories = getCategoryList();
		request.getSession().setAttribute(ResourceUtility.categoriesAttr, categories);
		List<Cd> productList = getProductsForCategory(category);

		// Managing if productList was empty or not
		if ((productList != null) && (!productList.isEmpty())) {
			request.setAttribute(ResourceUtility.categoryAttr, category);

			request.setAttribute(ResourceUtility.productsListAttr, productList);

			String lastVisitedPath = request.getRequestURL().toString();
			if (request.getQueryString() != null) {
				lastVisitedPath += ("?" + request.getQueryString());
			}

			request.getSession().setAttribute(ResourceUtility.lastActionPath, lastVisitedPath);

			request.getRequestDispatcher("/products.jsp").forward(request, response);
		} else {
			/* Handling of incorrect categories. */
		}
	}

	/**
	 * this getcategorylist() is used to getlist of categories from database by using cdcatalogserviceproxy
	 * 
	 * @return the list of categories from the database
	 */
	private List<String> getCategoryList() {
		CDCatalogServiceProxy proxy = new CDCatalogServiceProxy();

		String[] categories = null;
		try {
			categories = proxy.getCategoryList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		// debugging
		System.out.println("CATEGORY LISTS: " + (categories == null ? null : categories));
		return Arrays.asList(categories);
	}

	/**this method is used to get list of productss from database by using cdcatalogserviceproxy
	 * @param categoryId
	 * @return list of products for specific category
	 */
	private List<Cd> getProductsForCategory(String categoryId) {
		CDCatalogServiceProxy proxy = new CDCatalogServiceProxy();
		Cd[] categoryProducts = null;
		try {
			categoryProducts = proxy.getProductList(categoryId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return Arrays.asList(categoryProducts);
	}

}
