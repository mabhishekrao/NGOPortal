package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonationBox {

	private String ngoName;
	@Id
	private String registrationNumber;
	private String accountNumber;
	private double totalCollection;

	public DonationBox(String ngoName, String registrationNumber, String accountNumber, double totalCollection) {
		super();
		this.ngoName = ngoName;
		this.registrationNumber = registrationNumber;
		this.accountNumber = accountNumber;
		this.totalCollection = totalCollection;
	}

	public DonationBox() {
		super();
	}

	public String getNgoName() {
		return ngoName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getTotalCollection() {
		return totalCollection;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}

}
