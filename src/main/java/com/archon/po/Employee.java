package com.archon.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Employee implements Serializable {

	private Integer id;
	private Integer visitorId;
	private BigDecimal sal;
	private Timestamp hiredate;
	private Timestamp firedate;
	private Timestamp modifiedTime;
	private Integer deptAndJobId;
	private DeptAndJob deptAndJob;
	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", visitorId=" + visitorId +
				", sal=" + sal +
				", hiredate=" + hiredate +
				", firedate=" + firedate +
				", modifiedTime=" + modifiedTime +
				", deptandjobId=" + deptAndJobId +
				", deptAndJobId=" + deptAndJobId +
				'}';
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

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public Timestamp getHiredate() {
		return hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public Timestamp getFiredate() {
		return firedate;
	}

	public void setFiredate(Timestamp firedate) {
		this.firedate = firedate;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getDeptandjobId() {
		return deptAndJobId;
	}

	public void setDeptandjobId(Integer deptAndJobId) {
		this.deptAndJobId = deptAndJobId;
	}

	public DeptAndJob getDeptAndJob() {
		return deptAndJob;
	}

	public void setDeptAndJob(DeptAndJob deptAndJob) {
		this.deptAndJob = deptAndJob;
	}
}