package com.ngalaxy.registration.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CustomerRegistration {

	@Id
	@GeneratedValue
	private Integer custId;
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	private String pinCode;
	private String city;
	private String adharNo;
	private String adharFile;

	public CustomerRegistration() {
		super();
	}

	public CustomerRegistration(String fname, String lname, String email, String mobile, String pinCode, String city,
			String adharNo, String addharFile) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.pinCode = pinCode;
		this.city = city;
		this.adharNo = adharNo;
		this.adharFile = addharFile;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAdharFile() {
		return adharFile;
	}

	public void setAdharFile(String addharFile) {
		this.adharFile = addharFile;
	}

	@Override
	public String toString() {
		return "CustomerRegistration [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", mobile=" + mobile + ", pinCode=" + pinCode + ", city=" + city + ", adharNo=" + adharNo
				+ ", addharFile=" + adharFile + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adharFile, adharNo, city, custId, email, fname, lname, mobile, pinCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRegistration other = (CustomerRegistration) obj;
		return Objects.equals(adharFile, other.adharFile) && Objects.equals(adharNo, other.adharNo)
				&& Objects.equals(city, other.city) && Objects.equals(custId, other.custId)
				&& Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(pinCode, other.pinCode);
	}

}
