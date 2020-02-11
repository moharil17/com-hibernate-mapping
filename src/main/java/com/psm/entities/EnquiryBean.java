package com.psm.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiery_info")
public class EnquiryBean {

	@Id
	@GeneratedValue

	private int enquiry_id;
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

	@Column(name = "prev_Year_Marks")
	private float prevYrMarks;

	@Column(name = "admission_To_Class")
	private int admssnToClass;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "Zip")
	private String zip;

	@Column(name = "enquiry_Date", columnDefinition = "TIMESTAMP")
	Date date;
	@Column(name = "created_by")
	private int created_by;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
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

	public float getPrevYrMarks() {
		return prevYrMarks;
	}

	public void setPrevYrMarks(float prevYrMarks) {
		this.prevYrMarks = prevYrMarks;
	}

	public int getAdmssnToClass() {
		return admssnToClass;
	}

	public void setAdmssnToClass(int admssnToClass) {
		this.admssnToClass = admssnToClass;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "EnquiryBean [enquiry_id=" + enquiry_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", prevYrMarks="
				+ prevYrMarks + ", admssnToClass=" + admssnToClass + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", startDateTime=" + date + "]";
	}

}
