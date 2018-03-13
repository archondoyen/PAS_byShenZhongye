package com.archon.po;

import java.io.Serializable;
public class Company implements Serializable {

	private Integer id;
	private String cName;
	private String cAdress;
	private String cInfo;

	public Company() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public String getCAdress() {
		return cAdress;
	}

	public void setCAdress(String cAdress) {
		this.cAdress = cAdress;
	}

	public String getCInfo() {
		return cInfo;
	}

	public void setCInfo(String cInfo) {
		this.cInfo = cInfo;
	}

	@Override
	public String toString() {
		return "Company{" +
				" id=" + id +
				" cName=" + cName +
				" cAdress=" + cAdress +
				" cInfo=" + cInfo +
				"}";
	}
}