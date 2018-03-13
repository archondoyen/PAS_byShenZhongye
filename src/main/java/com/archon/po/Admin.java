package com.archon.po;

import java.io.Serializable;
public class Admin implements Serializable {

	private Integer id;
	private String aName;
	private transient String aPassword;
	private Integer aType;

	public Admin() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAName() {
		return aName;
	}

	public void setAName(String aName) {
		this.aName = aName;
	}

	public String getAPassword() {
		return aPassword;
	}

	public void setAPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public Integer getAType() {
		return aType;
	}

	public void setAType(Integer aType) {
		this.aType = aType;
	}

	@Override
	public String toString() {
		return "Admin{" +
				" id=" + id +
				" aName=" + aName +
				" aPassword=" + aPassword +
				" aType=" + aType +
				"}";
	}
}