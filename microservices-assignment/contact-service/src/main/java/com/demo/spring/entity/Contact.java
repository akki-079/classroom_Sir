package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MYCONTACT")
public class Contact {
	@Id
	@Column(name="CONID")
	private int contactId;
	
	@Column(name="CONTAG")
	private String contactTag;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="PINCODE")
	private String pinCode;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="UID")
	private int userId;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactId, String contactTag, String city, String pinCode, String email, int userId) {
		
		this.contactId = contactId;
		this.contactTag = contactTag;
		this.city = city;
		this.pinCode = pinCode;
		this.email = email;
		this.userId = userId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactTag() {
		return contactTag;
	}

	public void setContactTag(String contactTag) {
		this.contactTag = contactTag;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}

