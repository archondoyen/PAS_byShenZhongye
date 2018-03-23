package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Recruitment implements Serializable {

	private Integer id;
	private Integer jobAndDeptId;
	private String workType;
	private String workLocation;
	private Integer workerNumber;
	private Timestamp recruitmentCreateTime;
	private Timestamp recruitmentModifiedTime;
	private DeptAndJob deptAndJob;
	private Integer createrId;
	private List<Resume> resumeList;
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
				", createrId=" + createrId +
				", resumeList=" + resumeList +
				'}';
	}

	public List<Resume> getResumeList() {
		return resumeList;
	}

	public void setResumeList(List<Resume> resumeList) {
		this.resumeList = resumeList;
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

	public Integer getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}
}