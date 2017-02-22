package com.musicstore.model.dao.CDs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.musicstore.model.Categories;
import com.musicstore.model.Cd;
import com.musicstore.model.Products;

/**
 * @author philip
 *
 */
public class ProductsDAO {

	DBAgent agent = new DBAgent();

	/*
	 * Gets the list of categories param return categories
	 */
	public Categories getCategories() {
		ArrayList<String> parameterList = new ArrayList<String>();
		Categories cl = new Categories();
		ArrayList<String> categories = new ArrayList<String>();
		String type = "Type";

		agent.initialize();
		List<Map<String, Object>> clList = agent.getQueryResult(DBQueryList.Get_Categoy_List, DBQueryList.CategoryType,
				parameterList);
		for (Entry<String, Object> map : clList.get(0).entrySet()) {
			if (type.equalsIgnoreCase(map.getKey())) {
				String cltmp = (String) map.getValue();
				int length = cltmp.length();
				cltmp = cltmp.substring(5, length - 1);
				for (String str : cltmp.split(",")) {
					categories.add(str.substring(1, str.length() - 1));
				}
			}
		}

		agent.finalize();
		cl.setCategories(categories);
		return cl;

	}

	/*
	 * Gets the list of products
	 * 
	 * @param
	 * 
	 * @return products
	 */

	public Products getProducts(String categoryId) {
		ArrayList<String> parameterList = new ArrayList<String>();
		Products pl = new Products();
		ArrayList<Cd> productList = new ArrayList<Cd>();
		List<Map<String, Object>> plList = new ArrayList<Map<String, Object>>();
		agent.initialize();
		if (null == categoryId || categoryId.length() <= 0) {
			
			plList = agent.getQueryResult(DBQueryList.Get_Categoy_List, DBQueryList.CategoryType, parameterList);
			
		} else {
			
			parameterList.add(0, categoryId);
			plList = agent.getQueryResult(DBQueryList.Get_Products_By_Category, DBQueryList.CategoryType,
					parameterList);
			
		}

		populateProductList(productList, plList);

		agent.finalize();
		pl.setProducts(productList);

		return pl;
	}

	/**
	 * @param productList
	 * @param plList
	 * @param cdid
	 * @param title
	 * @param availability
	 * Used to update all the values of the product list 
	 */
	private void populateProductList(ArrayList<Cd> productList, List<Map<String, Object>> plList) {
		String cdid = "cdid";
		String title = "title";
		String availability = "availability";
		String price = "price";

		for (int i = 0; i < plList.size(); i++) {
		
			Cd cdtmp = new Cd();
			for (Map.Entry<String, Object> entry : plList.get(i).entrySet()) {

				if (cdid.equalsIgnoreCase(entry.getKey())) {
					cdtmp.setCdid((String) entry.getValue());
				} else if (title.equalsIgnoreCase(entry.getKey())) {
					cdtmp.setTitle((String) entry.getValue());
				} else if (availability.equals(entry.getKey())) {
					cdtmp.setAvailability((int) entry.getValue());
				} else if (price.equals(entry.getKey())) {
					try {
						if (entry.getValue() != null) {
							cdtmp.setPrice(Integer.parseInt(entry.getValue().toString()));
						}
					} catch (Exception ex) {

					}
				}
			}
			productList.add(cdtmp);
		}
	}

	/*
	 * Gives the list of products in a cart
	 */

	public Products getCartProducts(String items) {
		String[] itemsList = items.split(",");
		ArrayList<String> parameters = new ArrayList<String>();
		Products pl = new Products();
		ArrayList<Cd> productList = new ArrayList<Cd>();
		List<Map<String, Object>> plList = new ArrayList<Map<String, Object>>();

		agent.initialize();
		for (int i = 0; i < itemsList.length; i++) {
			parameters = new ArrayList<String>();
			parameters.add(itemsList[i]);
			plList = agent.getQueryResult(DBQueryList.get_Cart_Products, DBQueryList.CategoryType, parameters);
			populateProductList(productList, plList);
		}
		agent.finalize();
		pl.setProducts(productList);

		return pl;
	}

	/*
	 * Gives the details of products
	 */

	public Cd getProductInfo(String cdid) {
		Products products = getCartProducts(cdid);
		return products.getProducts().get(0);
	}
}
