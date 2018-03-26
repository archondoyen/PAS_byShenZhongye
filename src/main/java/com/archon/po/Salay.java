package com.archon.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Salay implements Serializable {
	public static final Double AVG_RATIO = 0.8;
	private Integer id;
	private Integer empId;
	private BigDecimal base;
	private BigDecimal rewardAndPunish;
	private BigDecimal workerPerformance;
	private BigDecimal ratio;
	private Timestamp getSalDate;
	private Employee employee;
	private List<RewardPunish> rewardPunishList;
	private Integer companyId;
	public Salay() {

	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Salay{" +
				"id=" + id +
				", empId=" + empId +
				", base=" + base +
				", rewardAndPunish=" + rewardAndPunish +
				", workerPerformance=" + workerPerformance +
				", ratio=" + ratio +
				", getSalDate=" + getSalDate +
				", employee=" + employee +
				", rewardPunishList=" + rewardPunishList +
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

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getRewardAndPunish() {
		return rewardAndPunish;
	}

	public void setRewardAndPunish(BigDecimal rewardAndPunish) {
		this.rewardAndPunish = rewardAndPunish;
	}

	public BigDecimal getWorkerPerformance() {
		return workerPerformance;
	}

	public void setWorkerPerformance(BigDecimal workerPerformance) {
		this.workerPerformance = workerPerformance;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public Timestamp getGetSalDate() {
		return getSalDate;
	}

	public void setGetSalDate(Timestamp getSalDate) {
		this.getSalDate = getSalDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<RewardPunish> getRewardPunishList() {
		return rewardPunishList;
	}

	public void setRewardPunishList(List<RewardPunish> rewardPunishList) {
		this.rewardPunishList = rewardPunishList;
	}
}