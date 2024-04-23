package com.ngalaxy.registration.model;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class CustomerRegistration {

	@Id
	@GeneratedValue
	private Integer custId;
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	private String pincode;
	private String city;
	private String adharNo;
	private String adharFileName;
	@Lob
	private byte[] adharFile;

	public CustomerRegistration() {
		super();
	}

	public CustomerRegistration(String fname, String lname, String email, String mobile, String pincode, String city,
			String adharNo, String addharFile, byte[] adharFileContent) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.pincode = pincode;
		this.city = city;
		this.adharNo = adharNo;
		this.adharFileName = addharFile;
		this.adharFile = adharFileContent;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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
		return adharFileName;
	}

	public void setAdharFileName(String adharFileName) {
		this.adharFileName = adharFileName;
	}

	public byte[] getAdharFileContent() {
		return adharFile;
	}

	public void setAdharFileContent(byte[] adharFileContent) {
		this.adharFile = adharFileContent;
	}

	@Override
	public String toString() {
		return "CustomerRegistration [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", mobile=" + mobile + ", pinCode=" + pincode + ", city=" + city + ", adharNo=" + adharNo
				+ ", adharFileName=" + adharFileName + ", adharFileContent=" + Arrays.toString(adharFile) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(adharFile);
		result = prime * result
				+ Objects.hash(adharFileName, adharNo, city, custId, email, fname, lname, mobile, pincode);
		return result;
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
		return Arrays.equals(adharFile, other.adharFile)
				&& Objects.equals(adharFileName, other.adharFileName) && Objects.equals(adharNo, other.adharNo)
				&& Objects.equals(city, other.city) && Objects.equals(custId, other.custId)
				&& Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(pincode, other.pincode);
	}

}
