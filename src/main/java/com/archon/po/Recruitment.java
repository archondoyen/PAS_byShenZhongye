package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Recruitment implements Serializable {

	private Integer id;
	private Integer jobAndDeptId;
	private String workType;
	private String workLocation;
	private Integer workerNumber;
	private Timestamp recruitmentCreateTime;
	private Timestamp recruitmentModifiedTime;
	private DeptAndJob deptAndJob;
	public Recruitment() {

	}

	@Override
	public String toString() {
		return "Recruitment{" +
				"id=" + id +
				", jobAndDeptId=" + jobAndDeptId +
				", workType='" + workType + '\'' +
				", workLocation='" + workLocation + '\'' +
				", workerNumber=" + workerNumber +
				", recruitmentCreateTime=" + recruitmentCreateTime +
				", recruitmentModifiedTime=" + recruitmentModifiedTime +
				", deptAndJob=" + deptAndJob +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJobAndDeptId() {
		return jobAndDeptId;
	}

	public void setJobAndDeptId(Integer jobAndDeptId) {
		this.jobAndDeptId = jobAndDeptId;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public Integer getWorkerNumber() {
		return workerNumber;
	}

	public void setWorkerNumber(Integer workerNumber) {
		this.workerNumber = workerNumber;
	}

	public Timestamp getRecruitmentCreateTime() {
		return recruitmentCreateTime;
	}

	public void setRecruitmentCreateTime(Timestamp recruitmentCreateTime) {
		this.recruitmentCreateTime = recruitmentCreateTime;
	}

	public Timestamp getRecruitmentModifiedTime() {
		return recruitmentModifiedTime;
	}

	public void setRecruitmentModifiedTime(Timestamp recruitmentModifiedTime) {
		this.recruitmentModifiedTime = recruitmentModifiedTime;
	}

	public DeptAndJob getDeptAndJob() {
		return deptAndJob;
	}

	public void setDeptAndJob(DeptAndJob deptAndJob) {
		this.deptAndJob = deptAndJob;
	}
}