package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Train implements Serializable {

	private Integer id;
	private Integer empId;
	private String trainContent;
	private Timestamp startTime;
	private Timestamp endTime;
	private String trainLocation;
	private String tutor;
	private String trainResult;

	public Train() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getTrainContent() {
		return trainContent;
	}

	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getTrainLocation() {
		return trainLocation;
	}

	public void setTrainLocation(String trainLocation) {
		this.trainLocation = trainLocation;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getTrainResult() {
		return trainResult;
	}

	public void setTrainResult(String trainResult) {
		this.trainResult = trainResult;
	}

	@Override
	public String toString() {
		return "Train{" +
				" id=" + id +
				" empId=" + empId +
				" trainContent=" + trainContent +
				" startTime=" + startTime +
				" endTime=" + endTime +
				" trainLocation=" + trainLocation +
				" tutor=" + tutor +
				" trainResult=" + trainResult +
				"}";
	}
}