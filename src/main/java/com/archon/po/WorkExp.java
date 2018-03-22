package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class WorkExp implements Serializable {

	private Integer id;
	private Timestamp startDate;
	private Timestamp endDate;
	private String positionRewarding;
	private Integer visitorId;

	public WorkExp() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getPositionRewarding() {
		return positionRewarding;
	}

	public void setPositionRewarding(String positionRewarding) {
		this.positionRewarding = positionRewarding;
	}

	public Integer getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	@Override
	public String toString() {
		return "WorkExp{" +
				" id=" + id +
				" startDate=" + startDate +
				" endDate=" + endDate +
				" positionRewarding=" + positionRewarding +
				" visitorId=" + visitorId +
				"}";
	}
}