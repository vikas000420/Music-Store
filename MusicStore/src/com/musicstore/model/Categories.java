package com.musicstore.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Categories implements Serializable{
	private static final long serialVersionUID = 1L;

	private ArrayList<String> categories;
/**
	 * @return
	 */
	public ArrayList<String> getCategories() {
		return categories;
	}
/**
	 * @param categories
	 */
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
}
