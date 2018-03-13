package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Visitor implements Serializable {

	private String vIdentityCard;
	private Integer id;
	private String vName;
	private transient String vPassword;
	private String vGender;
	private Integer vAge;
	private String vEmail;
	private String vPhone;
	private Timestamp vCreateTime;
	private Timestamp vModifiedTime;
	private String vPhoto;

	public Visitor() {

	}

	public String getVidentityCard() {
		return vIdentityCard;
	}

	public void setVIdentityCard(String vIdentityCard) {
		this.vIdentityCard = vIdentityCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVName() {
		return vName;
	}

	public void setVName(String vName) {
		this.vName = vName;
	}

	public String getVPassword() {
		return vPassword;
	}

	public void setVPassword(String vPassword) {
		this.vPassword = vPassword;
	}

	public String getVGender() {
		return vGender;
	}

	public void setVGender(String vGender) {
		this.vGender = vGender;
	}

	public Integer getVAge() {
		return vAge;
	}

	public void setVAge(Integer vAge) {
		this.vAge = vAge;
	}

	public String getVEmail() {
		return vEmail;
	}

	public void setVEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getVPhone() {
		return vPhone;
	}

	public void setVPhone(String vPhone) {
		this.vPhone = vPhone;
	}

	public Timestamp getVCreateTime() {
		return vCreateTime;
	}

	public void setVCreateTime(Timestamp vCreateTime) {
		this.vCreateTime = vCreateTime;
	}

	public Timestamp getVModifiedTime() {
		return vModifiedTime;
	}

	public void setVModifiedTime(Timestamp vModifiedTime) {
		this.vModifiedTime = vModifiedTime;
	}

	public String getVPhoto() {
		return vPhoto;
	}

	public void setVPhoto(String vPhoto) {
		this.vPhoto = vPhoto;
	}

	@Override
	public String toString() {
		return "Visitor{" +
				" vIdentityCard=" + vIdentityCard +
				" id=" + id +
				" vName=" + vName +
				" vPassword=" + vPassword +
				" vGender=" + vGender +
				" vAge=" + vAge +
				" vEmail=" + vEmail +
				" vPhone=" + vPhone +
				" vCreateTime=" + vCreateTime +
				" vModifiedTime=" + vModifiedTime +
				" vPhoto=" + vPhoto +
				"}";
	}
}