package com.musicstore.model.dao.CDs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.musicstore.model.Account;
import com.musicstore.model.Address;

/**
 * @author sowjanya
 *
 */
public class AccountManagerDAO {
	private static Logger logger = Logger.getLogger(AccountManagerDAO.class.getName());
	private DBAgent agent = null;

	public AccountManagerDAO() {
		agent = new DBAgent();
		agent.initialize();
	}

	/**
	 * @param username and password are used for validating the account.
	 * @return true for success and false for failure.
    **/
	public Account getAccount(Account account) {

		String username = account.getUsername();
		String pwd = account.getPswrd();

		if (pwd == null || pwd.equals("")) {
			logger.error("Password id emtpy");
			return null;
		}

		List<String> parameters = new ArrayList<String>();

		parameters.add(username);
		parameters.add(pwd);

		getUserAccount(account, parameters, true);

		return account;
	}

	/**
	 * @param account
	 * @param pwd
	 * @param parameters
	 * Used to get UserAccount by using (key,value) pairs 
	 */
	private void getUserAccount(Account account, List<String> parameters, boolean usePassword) {
		List<Map<String, Object>> queryResult = null;
		if (usePassword) {
			queryResult = agent.getQueryResult(DBQueryList.get_Account, DBQueryList.AccountType, parameters);
		} else {
			queryResult = agent.getQueryResult(DBQueryList.get_Account_By_UserName, DBQueryList.AccountType,
					parameters);
		}

		if (queryResult.isEmpty()) {
			logger.error("no account found");
			account = null;
			return;
		}

		for (Map.Entry<String, Object> entry : queryResult.get(0).entrySet()) {
			if (entry.getKey().equals(DBQueryList.accountPwdCol)) {
				String passwordInDB = (String) entry.getValue();
				if (!account.getPswrd().equals(passwordInDB)) {
					account = null;
					return;
				}
			} else if (entry.getKey().equals(DBQueryList.accountFNCol))
				account.setFirstname((String) entry.getValue());

			else if (entry.getKey().equals(DBQueryList.accountLNCol))
				account.setLastname((String) entry.getValue());

			else if (entry.getKey().equals(DBQueryList.accountEmailcol))
				account.setEmail((String) entry.getValue());

			else if (entry.getKey().equals(DBQueryList.accountAddressCol)) {
				int addressId = Integer.parseInt(entry.getValue().toString());

				parameters = new ArrayList<String>();

				parameters.add(String.valueOf(addressId));

				account.setAddress(getUserAddress(account.getUsername()));
			}
		}
	}

	/* Creates the account by validating username
	 * 
	 */
	public Account createAccount(Account account) {
		String username = account.getUsername();
		String pwd = account.getPswrd();

		if (pwd == null || pwd.equals("")) {

			return null;
		}

		List<String> parameters = new ArrayList<String>();

		parameters.add(username);

		List<Map<String, Object>> queryResult = agent.getQueryResult(DBQueryList.get_Account_By_UserName,
				DBQueryList.AccountType, parameters);

		/* Adds the account values to the database
         * 
         */
		if (queryResult.isEmpty()) {
			parameters = new ArrayList<String>();
			parameters.add(account.getFirstname());
			parameters.add(account.getLastname());
			parameters.add(account.getUsername());
			parameters.add(account.getPswrd());
			parameters.add(account.getEmail());
			agent.executeSQL(DBQueryList.create_Account, DBQueryList.AccountType, parameters);

			/* Adds the address values to the to the database
             * 
             */
			List<String> addressParams = new ArrayList<String>();
			addressParams.add(account.getAddress().getStreet());
			addressParams.add(account.getAddress().getCity());
			addressParams.add(account.getAddress().getProvince());
			addressParams.add(account.getAddress().getCountry());
			addressParams.add(account.getAddress().getZip());
			addressParams.add(account.getAddress().getPhone());
			agent.executeSQL(DBQueryList.create_Address, DBQueryList.AddressType, addressParams);

			List<Map<String, Object>> lastAddressResponse = agent.getQueryResult(DBQueryList.get_last_id,
					DBQueryList.AddressType, new ArrayList<String>());
			String lastAddressId = null;
			for (Map.Entry<String, Object> entry : lastAddressResponse.get(0).entrySet()) {
				if (entry.getKey().equals("LastAddressId")) {
					lastAddressId = entry.getValue().toString();

				}
			}

			parameters = new ArrayList<String>();
			parameters.add(lastAddressId);
			parameters.add(account.getUsername());
			
			@SuppressWarnings("unused")
			int updateAccountAddressResult = agent.executeSQL(DBQueryList.update_Account_Address,
					DBQueryList.AccountType, parameters);

			parameters = new ArrayList<String>();

			parameters.add(username);
			parameters.add(account.getPswrd());
			getUserAccount(account, parameters, true);
		}
		return account;
	}

	/* 
	 * Gets the user address
	 */
	public Address getUserAddress(String userName) {
		List<String> parameters = new ArrayList<String>();
		parameters.add(userName);
		List<Map<String, Object>> addresses = agent.getQueryResult(DBQueryList.get_Account_By_UserName,
				DBQueryList.AddressType, parameters);

		if (addresses.size() == 0) {
			logger.error("No address for this user");
			return new Address();
		}

		return createAddress(addresses.get(0));
	}

	/** Creates the address 
	 * @param rs
	 * @return address
	 * creates address for a particular user 
	 */
	private Address createAddress(Map<String, Object> rs) {
		Address address = new Address();
		String idCol = "id";
		String provinceCol = "province";
		String countryCol = "country";
		String cityCol = "city";
		String zipcol = "zip";
		String phoneCol = "phone";
		String streetCol = "street";

		for (Map.Entry<String, Object> entry : rs.entrySet()) {
			if (entry.getKey().equals(idCol))
				address.setId(Integer.parseInt(entry.getValue().toString()));

			else if (entry.getKey().equals(provinceCol))
				address.setProvince((String) entry.getValue());

			else if (entry.getKey().equals(countryCol))
				address.setCountry((String) entry.getValue());

			else if (entry.getKey().equals(zipcol))
				address.setZip((String) entry.getValue());

			else if (entry.getKey().equals(phoneCol))
				address.setPhone((String) entry.getValue());
			else if (entry.getKey().equals(cityCol))
				address.setCity((String) entry.getValue());

			else if (entry.getKey().equals(streetCol))
				address.setStreet((String) entry.getValue());
		}

		return address;

	}

	/* Returns the account by username
	 * 
	 */
	public Account getAccountByUserName(String username) {
		logger.info("get user by user name: " + username);
		List<String> parameters = new ArrayList<String>();

		parameters.add(username);
		Account account = new Account();

		getUserAccount(account, parameters, false);

		return account;
	}

}
