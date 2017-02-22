package com.musicstore.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.musicstore.model.Categories;
import com.musicstore.model.Cd;
import com.musicstore.model.Products;

/**
 * @author philip
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface CDCatalogService {
	/**
	 * @param cdid
	 * @return
	 */
	@WebMethod
	public Cd getProductInfo(@WebParam(name = "cdid") String cdid);

	/**
	 * @return list of category
	 */
	@WebMethod
	public Categories getCategoryList();

	/**
	 * @param category
	 * @return products
	 */
	@WebMethod
	public Products getProductList(@WebParam(name = "category") String category);

}
