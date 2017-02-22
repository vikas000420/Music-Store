package com.musicstore.model;

import java.io.Serializable;

public class CreditCardDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ccNumber;
	private String ccvCode;
	private String nameOnCC;
	private String expMonth;

	public String getExpMonth() {
		return expMonth;
	}

	/**
	 * @param expMonth
	 */
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	/**
	 * @return expYear
	 */
	public String getExpYear() {
		return expYear;
	}

	/**
	 * @param expYear
	 */
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	private String expYear;

	/**
	 * @return ccNumber
	 */
	public String getCcNumber() {
		return ccNumber;
	}

	/**
	 * @param ccNumber
	 */
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	/**
	 * @return ccvCode
	 */
	public String getCcvCode() {
		return ccvCode;
	}

	/**
	 * @param ccvCode
	 */
	public void setCcvCode(String ccvCode) {
		this.ccvCode = ccvCode;
	}

	/**
	 * @return nameOnCC
	 */
	public String getNameOnCC() {
		return nameOnCC;
	}

	/**
	 * @param nameOnCC
	 */
	public void setNameOnCC(String nameOnCC) {
		this.nameOnCC = nameOnCC;
	}

}
