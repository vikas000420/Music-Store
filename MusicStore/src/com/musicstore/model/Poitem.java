package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the poitem database table.
 * 
 */
@Entity
@NamedQuery(name = "Poitem.findAll", query = "SELECT p FROM Poitem p")
public class Poitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PoitemPK id;

	private int price;

	// bi-directional many-to-one association to Po
	@ManyToOne
	@JoinColumn(name = "id")
	private Po po;

	// bi-directional many-to-one association to Cd
	@ManyToOne
	@JoinColumn(name = "cdid")
	private Cd cd;

	public Poitem() {
	}

	/**
	 * @return id
	 */
	public PoitemPK getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(PoitemPK id) {
		this.id = id;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return po
	 */
	public Po getPo() {
		return this.po;
	}

	/**
	 * @param po
	 */
	public void setPo(Po po) {
		this.po = po;
	}

	/**
	 * @return cd
	 */
	public Cd getCd() {
		return this.cd;
	}

	/**
	 * @param cd
	 */
	public void setCd(Cd cd) {
		this.cd = cd;
	}

}