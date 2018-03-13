package com.archon.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Employee implements Serializable {

	private Integer id;
	private Integer visitorId;
	private BigDecimal sal;
	private Integer companyId;
	private Timestamp hiredate;
	private Timestamp firedate;
	private Timestamp modifiedTime;
	private Integer deptandjobId;

	public Employee() {

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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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
		return deptandjobId;
	}

	public void setDeptandjobId(Integer deptandjobId) {
		this.deptandjobId = deptandjobId;
	}

	@Override
	public String toString() {
		return "Employee{" +
				" id=" + id +
				" visitorId=" + visitorId +
				" sal=" + sal +
				" companyId=" + companyId +
				" hiredate=" + hiredate +
				" firedate=" + firedate +
				" modifiedTime=" + modifiedTime +
				" deptandjobId=" + deptandjobId +
				"}";
	}
}