package com.archon.po;

import java.io.Serializable;
import java.math.BigDecimal;
public class Job implements Serializable {

	private Integer id;
	private Integer companyId;
	private String jName;
	private String jInfo;
	private Integer jTypeId;
	private BigDecimal sal;
	private Jobtype jobtype;

	public Job() {

	}

	public Jobtype getJobtype() {
		return jobtype;
	}

	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getJName() {
		return jName;
	}

	public void setJName(String jName) {
		this.jName = jName;
	}

	public String getJInfo() {
		return jInfo;
	}

	public void setJInfo(String jInfo) {
		this.jInfo = jInfo;
	}

	public Integer getJTypeId() {
		return jTypeId;
	}

	public void setJTypeId(Integer jTypeId) {
		this.jTypeId = jTypeId;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", companyId=" + companyId +
				", jName='" + jName + '\'' +
				", jInfo='" + jInfo + '\'' +
				", jTypeId=" + jTypeId +
				", sal=" + sal +
				", jobtype=" + jobtype +
				'}';
	}
}