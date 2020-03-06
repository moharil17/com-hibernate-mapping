package com.psm.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fees_details")
public class FeesDetails implements Serializable {

	@Id
	@Column(name = "student_id")
	private int student_id;

	@Id
	@Column(name = "std")
	private int standard;

	@Column(name = "paid_fees")
	private double paidFees;

	@Column(name = "total_fees")
	private double totalFees;

	public FeesDetails() {
		
	}
	public FeesDetails(int student_id,int standard) {
		this.student_id = student_id;
		this.standard = standard;
	}
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(double fees) {
		this.paidFees = fees;
	}

	@Override
	public String toString() {
		return "FeesDetails [student_id=" + student_id + ", totalFees=" + totalFees + ", standard=" + standard
				+ ", paidFees=" + paidFees + "]";
	}

}
