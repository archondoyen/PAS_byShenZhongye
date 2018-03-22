package com.archon.po;

import java.io.Serializable;
public class Resume implements Serializable {

	private Integer id;
	private Integer visiorId;
	private String selfAppraisal;
	private String interest;
	private Integer recruitmentId;

	public Resume() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVisiorId() {
		return visiorId;
	}

	public void setVisiorId(Integer visiorId) {
		this.visiorId = visiorId;
	}

	public String getSelfAppraisal() {
		return selfAppraisal;
	}

	public void setSelfAppraisal(String selfAppraisal) {
		this.selfAppraisal = selfAppraisal;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Integer getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(Integer recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	@Override
	public String toString() {
		return "Resume{" +
				" id=" + id +
				" visiorId=" + visiorId +
				" selfAppraisal=" + selfAppraisal +
				" interest=" + interest +
				" recruitmentId=" + recruitmentId +
				"}";
	}
}