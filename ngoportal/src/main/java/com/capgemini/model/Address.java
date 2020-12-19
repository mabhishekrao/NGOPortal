package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	private String city;
	private String state;
	private String pin;
	private String landmark;

	public int getAddressId() {
		return addressId;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPin() {
		return pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Address(String city, String state, String pin, String landmark) {
		super();
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public Address() {
		super();
	}

}
