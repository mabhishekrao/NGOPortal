package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "select people by name", query = "select np from NeedyPeople np where np.needyPersonName=:name")
public class NeedyPeople {
	public NeedyPeople(int needyPersonId, String needyPersonName, String phone, double familyIncome, Address address) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.address = address;
	}

	@Id
	@GeneratedValue
	private int needyPersonId;
	private String needyPersonName;
	private String phone;
	private double familyIncome;
	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public NeedyPeople(String needyPersonName, String phone, double familyIncome, Address address) {
		super();
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.address = address;
	}

	public NeedyPeople() {
		super();
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public Address getAddress() {
		return address;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
