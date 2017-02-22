/**
 * 
 */
package com.musicstore.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Cd> products;

	/**
	 * @return products
	 */
	public ArrayList<Cd> getProducts() {
		return products;
	}

	/**
	 * @param products
	 */
	public void setProducts(ArrayList<Cd> products) {
		this.products = products;
	}

}
