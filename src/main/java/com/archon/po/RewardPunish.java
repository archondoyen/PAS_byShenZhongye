package com.archon.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class RewardPunish implements Serializable {

	private Integer id;
	private Integer empId;
	private String rpType;
	private String rpContent;
	private Timestamp rpTime;
	private BigDecimal money;
	private Employee employee;
	private Integer salayId;
	public RewardPunish() {

	}

	public Integer getSalayId() {
		return salayId;
	}

	public void setSalayId(Integer salayId) {
		this.salayId = salayId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public String getRpType() {
		return rpType;
	}

	public void setRpType(String rpType) {
		this.rpType = rpType;
	}

	public String getRpContent() {
		return rpContent;
	}

	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}

	public Timestamp getRpTime() {
		return rpTime;
	}

	public void setRpTime(Timestamp rpTime) {
		this.rpTime = rpTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "RewardPunish{" +
				"id=" + id +
				", empId=" + empId +
				", rpType='" + rpType + '\'' +
				", rpContent='" + rpContent + '\'' +
				", rpTime=" + rpTime +
				", money=" + money +
				", employee=" + employee +
				", salayId=" + salayId +
				'}';
	}
}