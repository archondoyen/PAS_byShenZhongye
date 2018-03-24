package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Train implements Serializable {
	public static final String TRAIN_RESULT_BEST = "优秀";
	public static final String TRAIN_RESULT_MIDDLE = "中等";
	public static final String TRAIN_RESULT_LOW = "低";
	private Integer id;
	private Integer empAndTrainId;
	private String trainContent;
	private Timestamp startTime;
	private Timestamp endTime;
	private String trainLocation;
	private String coach;
	private String trainResult;

	public Train() {

	}

	@Override
	public String toString() {
		return "Train{" +
				"id=" + id +
				", empAndTrainId=" + empAndTrainId +
				", trainContent='" + trainContent + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", trainLocation='" + trainLocation + '\'' +
				", coach='" + coach + '\'' +
				", trainResult='" + trainResult + '\'' +
				'}';
	}

	public Integer getEmpAndTrainId() {
		return empAndTrainId;
	}

	public void setEmpAndTrainId(Integer empAndTrainId) {
		this.empAndTrainId = empAndTrainId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getcoach() {
		return coach;
	}

	public void setcoach(String coach) {
		this.coach = coach;
	}

	public String getTrainResult() {
		return trainResult;
	}

	public void setTrainResult(String trainResult) {
		this.trainResult = trainResult;
	}

}