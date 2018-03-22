package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class EducationExp implements Serializable {

	private Integer id;
	private Integer visitorId;
	private Timestamp startdate;
	private Timestamp enddate;
	private String school;
	private String positionRewarding;

	public EducationExp() {

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

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPositionRewarding() {
		return positionRewarding;
	}

	public void setPositionRewarding(String positionRewarding) {
		this.positionRewarding = positionRewarding;
	}

	@Override
	public String toString() {
		return "EducationExp{" +
				" id=" + id +
				" visitorId=" + visitorId +
				" startdate=" + startdate +
				" enddate=" + enddate +
				" school=" + school +
				" positionRewarding=" + positionRewarding +
				"}";
	}
}