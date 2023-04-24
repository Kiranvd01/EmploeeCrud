package com.kiran.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empweb")

public class Emploee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int eNo;
	private String eName;

	public Emploee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmploeeDaoImpl [eNo=" + eNo + ", eName=" + eName + ", eSalary=" + eSalary + "]";
	}

	public int geteNo() {
		return eNo;
	}

	public void seteNo(int eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double geteSalary() {
		return eSalary;
	}

	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}

	public Emploee(int eNo, String eName, double eSalary) {
		super();
		this.eNo = eNo;
		this.eName = eName;
		this.eSalary = eSalary;
	}

	private double eSalary;

}
