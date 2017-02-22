package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cd database table.
 * 
 */
@Entity
@NamedQuery(name="Cd.findAll", query="SELECT c FROM Cd c")
public class Cd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cdid;

	private int availability;

	private String category;

	private int price;

	private String title;

	//bi-directional many-to-one association to Poitem
	@OneToMany(mappedBy="cd")
	private List<Poitem> poitems;

	//bi-directional many-to-one association to Visitevent
	@OneToMany(mappedBy="cd")
	private List<Visitevent> visitevents;

	public Cd() {
	}
/**
	 * @return cdid
	 */
	public String getCdid() {
		return this.cdid;
	}
/**
	 * @param cdid
	 */
	public void setCdid(String cdid) {
		this.cdid = cdid;
	}
/**
	 * @return availability
	 */
	public int getAvailability() {
		return this.availability;
	}
/**
	 * @param availability
	 */
	public void setAvailability(int availability) {
		this.availability = availability;
	}
/**
	 * @return category
	 */
	public String getCategory() {
		return this.category;
	}
/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * @param poitem
	 * @return poitem
	 */
	public Poitem addPoitem(Poitem poitem) {
		getPoitems().add(poitem);
		poitem.setCd(this);

		return poitem;
	}

	public Poitem removePoitem(Poitem poitem) {
		getPoitems().remove(poitem);
		poitem.setCd(null);

		return poitem;
	}

	/**
	
	 * @return visitevents
	 */
	public List<Visitevent> getVisitevents() {
		return this.visitevents;
	}
/**
	 * @param visitevents
	 */
	public void setVisitevents(List<Visitevent> visitevents) {
		this.visitevents = visitevents;
	}

	public Visitevent addVisitevent(Visitevent visitevent) {
		getVisitevents().add(visitevent);
		visitevent.setCd(this);

		return visitevent;
	}

	public Visitevent removeVisitevent(Visitevent visitevent) {
		getVisitevents().remove(visitevent);
		visitevent.setCd(null);

		return visitevent;
	}

}