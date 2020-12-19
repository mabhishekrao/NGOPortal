package com.capgemini.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DonationDistribution {
	@Id
	@GeneratedValue
	private int distributionId;
	@OneToOne(cascade = { CascadeType.ALL })
	private NeedyPeople person;
	@OneToOne(cascade = { CascadeType.ALL })
	private DonationItem item;
	@OneToOne(cascade = { CascadeType.ALL })
	private Employee distributedBy;
	private double amountDistributed;
	private Date dateOfDistribution;
	private Date approvalOrRejectedDate;
	private DonationDistributionStatus status;

	public DonationDistribution(NeedyPeople person, DonationItem item, Employee distributedBy, double amountDistributed,
			Date dateOfDistribution, Date approvalOrRejectedDate, DonationDistributionStatus status) {
		super();
		this.person = person;
		this.item = item;
		this.distributedBy = distributedBy;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
	}

	public DonationDistribution() {
		super();
	}

	public int getDistributionId() {
		return distributionId;
	}

	public NeedyPeople getPerson() {
		return person;
	}

	public DonationItem getItem() {
		return item;
	}

	public Employee getDistributedBy() {
		return distributedBy;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public void setPerson(NeedyPeople person) {
		this.person = person;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public void setDistributedBy(Employee distributedBy) {
		this.distributedBy = distributedBy;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}
}
