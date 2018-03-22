package com.archon.po;

import java.io.Serializable;
public class Skill implements Serializable {

	private Integer id;
	private Integer visitorId;
	private String sName;
	private String certificate;

	public Skill() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "Skill{" +
				" id=" + id +
				" visitorId=" + visitorId +
				" sName=" + sName +
				" certificate=" + certificate +
				"}";
	}
}