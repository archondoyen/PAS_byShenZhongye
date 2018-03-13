package com.archon.po;

import java.io.Serializable;
public class Department implements Serializable {

	private Integer id;
	private Integer companyId;
	private String deptName;
	private String deptInfo;

	public Department() {

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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(String deptInfo) {
		this.deptInfo = deptInfo;
	}

	@Override
	public String toString() {
		return "Department{" +
				" id=" + id +
				" companyId=" + companyId +
				" deptName=" + deptName +
				" deptInfo=" + deptInfo +
				"}";
	}
}