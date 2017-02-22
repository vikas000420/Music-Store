package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String country;

	private String phone;

	private String province;

	private String street;

	private String zip;

	private String city;

	
	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "address")
	private List<Account> accounts;

	// bi-directional many-to-one association to Po
	@OneToMany(mappedBy = "addressBean")
	private List<Po> pos;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address() {
	}

	/**
	 * @return phone
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * @return phone
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return country
	 */

	public String getCountry() {
		return this.country;
	}

	/**
	 * @param country
	 */

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return phone
	 */

	public String getPhone() {
		return this.phone;
	}

	/**
	 * @param phone
	 */

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return province
	 */

	public String getProvince() {
		return this.province;
	}

	/**
	 * @param province
	 */

	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return street
	 */

	public String getStreet() {
		return this.street;
	}

	/**
	 * @param street
	 */

	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return zip
	 */

	public String getZip() {
		return this.zip;
	}

	/**
	 * @param zip
	 */

	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @param accounts
	 */
	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @param account
	 * @return
	 */
	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAddress(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAddress(null);

		return account;
	}

	/**
	 * @return pos
	 */
	public List<Po> getPos() {
		return this.pos;
	}

	/**
	 * @param pos
	 */
	public void setPos(List<Po> pos) {
		this.pos = pos;
	}

	/**
	 * @param po
	 * @return po
	 */
	public Po addPo(Po po) {
		getPos().add(po);
		po.setAddressBean(this);

		return po;
	}

	/**
	 * @param po
	 * @return po
	 */
	public Po removePo(Po po) {
		getPos().remove(po);
		po.setAddressBean(null);

		return po;
	}

}