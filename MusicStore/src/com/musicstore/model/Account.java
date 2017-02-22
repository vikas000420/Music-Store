package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name = "accounts")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String email;

	private String firstname;

	private String lastname;

	private String pswrd;

	// bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	public Account() {
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @param username
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return username
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @param username
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return pswrd
	 */
	public String getPswrd() {
		return this.pswrd;
	}

	/**
	 * @param pswrd
	 */
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}

	/**
	 * @return address
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * @return address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}