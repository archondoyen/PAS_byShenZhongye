package com.archon.po;

import java.io.Serializable;
public class Jobtype implements Serializable {

	private Integer id;
	private String firstType;
	private String secondType;

	public Jobtype() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstType() {
		return firstType;
	}

	public void setFirstType(String firstType) {
		this.firstType = firstType;
	}

	public String getSecondType() {
		return secondType;
	}

	public void setSecondType(String secondType) {
		this.secondType = secondType;
	}

	@Override
	public String toString() {
		return "Jobtype{" +
				" id=" + id +
				" firstType=" + firstType +
				" secondType=" + secondType +
				"}";
	}
}