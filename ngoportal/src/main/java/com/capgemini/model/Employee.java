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
	@NamedQuery(name="query by empusername", query = "select emp from Employee emp where emp.username=:username"),
	@NamedQuery(name="query by name", query = "select emp from Employee emp where emp.employeeName=:name")
})
public class Employee {
	@Id
	@GeneratedValue
	private int employeeId;
	private String employeeName;
	private String email;
	private String phone;
	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;
	private String username;
	private String password;

	public Employee(String employeeName, String email, String phone, Address address, String username,
			String password) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
