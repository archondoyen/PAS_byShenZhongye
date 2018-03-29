package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Attendance implements Serializable {

	private Integer id;
	private Integer empId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer statue;
	private Employee employee;
	public Attendance() {

	}

	@Override
	public String toString() {
		return "Attendance{" +
				"id=" + id +
				", empId=" + empId +
				", startTime=" + startTime +
				", endTime=" + endTime +
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