package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the po database table.
 * 
 */
@Entity
@NamedQuery(name = "Po.findAll", query = "SELECT p FROM Po p")
public class Po implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String fname;

	private String lname;

	private String status;

	// bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name = "address")
	private Address addressBean;

	// bi-directional many-to-one association to Poitem
	@OneToMany(mappedBy = "po")
	private List<Poitem> poitems;

	public Po() {
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return fname
	 */
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return lname
	 */
	public String getLname() {
		return this.lname;
	}

	/**
	 * @param lname
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return addressBean
	 */
	public Address getAddressBean() {
		return this.addressBean;
	}

	/**
	 * @param addressBean
	 */
	public void setAddressBean(Address addressBean) {
		this.addressBean = addressBean;
	}

	/**
	 * @return poitems
	 */
	public List<Poitem> getPoitems() {
		return this.poitems;
	}

	/**
	 * @param poitems
	 */
	public void setPoitems(List<Poitem> poitems) {
		this.poitems = poitems;
	}

	public Poitem addPoitem(Poitem poitem) {
		getPoitems().add(poitem);
		poitem.setPo(this);

		return poitem;
	}

	public Poitem removePoitem(Poitem poitem) {
		getPoitems().remove(poitem);
		poitem.setPo(null);

		return poitem;
	}

}