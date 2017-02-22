package com.musicstore.model.dao.CDs;

/**
 * @author Sowjanya
 *
 */
public class DBQueryList {
	/* queries */

	public static final String CategoryType = "gCategory";
	public static final String AccountType = "gAccount";
	public static final String POItemType = "gPoItem";
	public static final String POType = "gPO";
	public static final String VisitEventType = "gVisitEvent";
	public static final String AddressType = "gAddress";
	public static final String create_Po = "1";
	public static final String create_PoItems = "1";
	public static final String place_Po = "2";
	public static final String poCount = "3";
	public static final String getProduct = "3";

	// Select Queries
	public static final String get_Account = "1";
	public static final String create_Account = "2";
	public static final String create_Address = "2";
	public static final String get_last_id = "3";
	public static final String update_Account_Address = "3";
	public static final String get_Account_By_UserName = "4";
	public static final String get_Address_By_UserName = "4";
	public static final String get_Cart_Products = "3";
	public static final String Get_Address_By_Id = "1";
	public static final String Get_Categoy_List = "1";
	public static final String Get_Products_By_Category = "2";
	public static final String accountPwdCol = "pswrd";
	public static final String accountFNCol = "Firstname";
	public static final String accountLNCol = "Lastname";
	public static final String accountEmailcol = "Email";
	public static final String accountAddressCol = "address_id";
}
