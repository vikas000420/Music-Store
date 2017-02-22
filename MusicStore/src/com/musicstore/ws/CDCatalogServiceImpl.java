package com.musicstore.ws;

import javax.jws.WebService;


import com.musicstore.model.Categories;
import com.musicstore.model.Cd;
import com.musicstore.model.Products;
import com.musicstore.model.dao.CDs.ProductsDAO;

/**
 * @author philip
 *
 */
// Service Implementation
@WebService(endpointInterface = "com.musicstore.ws.CDCatalogService")
public class CDCatalogServiceImpl implements CDCatalogService {
	
	

	/**
	 * Gets the details of a product.
	 * @param cdid
	 * @return Cd
	 * Used to get getProductInfo for particular cd from the database
	 */

	@Override
	public Cd getProductInfo(String cdid) {
		ProductsDAO products = new ProductsDAO();
		return products.getProductInfo(cdid);
	}

	/*
	 * Gets the list of categories for the store.
	 */
	@Override
	public Categories getCategoryList() {
		ProductsDAO productsDAO = new ProductsDAO();
		return productsDAO.getCategories();
	}

	/**
	 * Gets the list of products.
	 * @param categoryId
	 * @return ProductList
	 */
	@Override
	public Products getProductList(String category) {
		ProductsDAO productsDAO = new ProductsDAO();
		return productsDAO.getProducts(category);
	}

}
