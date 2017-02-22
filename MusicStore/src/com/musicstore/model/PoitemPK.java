package com.musicstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the poitem database table.
 * 
 */
@Embeddable
public class PoitemPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private int id;

	@Column(insertable = false, updatable = false)
	private String cdid;

	public PoitemPK() {
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PoitemPK)) {
			return false;
		}
		PoitemPK castOther = (PoitemPK) other;
		return (this.id == castOther.id) && this.cdid.equals(castOther.cdid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.cdid.hashCode();

		return hash;
	}
}