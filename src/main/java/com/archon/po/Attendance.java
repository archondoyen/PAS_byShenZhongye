package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Attendance implements Serializable {

	private Integer id;
	private Integer empId;
	private Timestamp starttime;
	private Timestamp endtime;
	private Integer statue;
	private Employee employee;
	public Attendance() {

	}

	@Override
	public String toString() {
		return "Attendance{" +
				"id=" + id +
				", empId=" + empId +
				", starttime=" + starttime +
				", endtime=" + endtime +
				", statue=" + statue +
				", employee=" + employee +
				'}';
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

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}