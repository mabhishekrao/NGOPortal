package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="query by username", query="select dn from Donor dn where dn.donorUsername=:username"),
	@NamedQuery(name="query by username and password", query="select dn from Donor dn where dn.donorUsername=:username and dn.donorPassword=:password"),
	@NamedQuery(name="query by username for password", query="select dn from Donor dn where dn.donorUsername=:username")
})

public class Donor {
	@Id
	@GeneratedValue
	private int donorId;
	private String donorName;
	private String donorEmail;
	private String donorPhone;
	private String donorUsername;
	private String donorPassword;
	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public Donor(String donorName, String donorEmail, String donorPhone, String donorUsername, String donorPassword,
			Address address) {
		super();
		this.donorName = donorName;
		this.donorEmail = donorEmail;
		this.donorPhone = donorPhone;
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
		this.address = address;
	}

	public Donor() {
		super();
	}

	public int getDonorId() {
		return donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
