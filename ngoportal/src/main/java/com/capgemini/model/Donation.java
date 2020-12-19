package com.capgemini.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Donation {
	@Id
	@GeneratedValue
	private int donationId;
	@OneToOne(cascade = { CascadeType.ALL })
	private Donor donor;
	@OneToOne(cascade = { CascadeType.ALL })
	private DonationItem item;
	private double donationAmount;
	private Date donationDate;

	public Donation(Donor donor, DonationItem item, double donationAmount, Date donationDate) {
		super();
		this.donor = donor;
		this.item = item;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
	}

	public Donation() {
		super();
	}

	public int getDonationId() {
		return donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public DonationItem getItem() {
		return item;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

}
