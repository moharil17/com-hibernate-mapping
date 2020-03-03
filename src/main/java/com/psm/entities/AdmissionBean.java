package com.psm.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "admission")
public class AdmissionBean {

	@Id
	@GeneratedValue
	private int student_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "admission_To_Class")
	private int admssnToClass;

	@Column(name = "state")
	private int state;

	@Column(name = "Zip")
	private String zip;

	@Column(name = "city")
	private int city;

	@Column(name = "created_On_Date", columnDefinition = "TIMESTAMP")
	private String createdOnDate;

	@Column(name = "created_by")
	private int created_by;

	@Column(name = "enquiry_id")
	private int enquiry_id;

	@Transient
	private String userName;

	@Transient
	private double paid_fees;

	@Transient
	private double totalFees;

	public double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	public double getPaid_fees() {
		return paid_fees;
	}

	public void setPaid_fees(double paid_fees) {
		this.paid_fees = paid_fees;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(String createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAdmssnToClass() {
		return admssnToClass;
	}

	public void setAdmssnToClass(int admssnToClass) {
		this.admssnToClass = admssnToClass;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AdmissionBean [student_id=" + student_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", admssnToClass="
				+ admssnToClass + ", state=" + state + ", zip=" + zip + ", city=" + city + ", createdOnDate="
				+ createdOnDate + ", created_by=" + created_by + ", enquiry_id=" + enquiry_id + ", userName=" + userName
				+ "]";
	}

}
