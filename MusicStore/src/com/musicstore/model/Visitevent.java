package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the visitevent database table.
 * 
 */
@Entity
@NamedQuery(name = "Visitevent.findAll", query = "SELECT v FROM Visitevent v")
public class Visitevent implements Serializable {
	private static final long serialVersionUID = 1L;

	private String day;

	private String eventtype;

	// bi-directional many-to-one association to Cd
	@ManyToOne
	@JoinColumn(name = "cdid")
	private Cd cd;

	public Visitevent() {
	}

	/**
	 * @return day
	 */
	public String getDay() {
		return this.day;
	}

	/**
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return event type
	 */
	public String getEventtype() {
		return this.eventtype;
	}

	/**
	 * @param eventtype
	 */
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
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