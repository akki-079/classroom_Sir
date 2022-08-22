package com.demo.application;

class Address {
	private String doorNo;
	private String city;
	private int pinCode;

	public Address(String doorNo, String city, int pinCode) {
		this.doorNo = doorNo;
		this.city = city;
		this.pinCode = pinCode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

}