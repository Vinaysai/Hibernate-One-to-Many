package com.onetomany.all.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VendorDetails")

public class Vendor {

	@Id
	@Column(name = "vid")

	private int Vid;
	@Column(name = "Vname")

	private String Vname;

	@SuppressWarnings("rawtypes")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Customer.class)
	@JoinColumn(name = "venid", referencedColumnName = "vid")
	private Set child;

	public int getVid() {
		return Vid;
	}

	@SuppressWarnings("rawtypes")
	public Set getChild() {
		return child;
	}

	@SuppressWarnings("rawtypes")
	public void setChild(Set child) {
		this.child = child;
	}

	public void setVid(int vid) {
		Vid = vid;
	}

	public String getVname() {
		return Vname;
	}

	public void setVname(String vname) {
		Vname = vname;
	}

	public Vendor() {
		super();
	}

}
