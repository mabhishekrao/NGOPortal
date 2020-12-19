package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;

public interface AdminDao {
	public int createEmployee(Employee employee)throws SQLException;
	public Employee updateEmployee(Employee employee)throws SQLException;
	public int deleteEmployee(int employeeId)throws SQLException;
	public Employee readEmployeeById(int employeeId)throws SQLException;
	public List<Employee> readEmployeeByName(String name)throws SQLException;
	public List<Employee> readAllEmployees()throws SQLException;
	public boolean approveDonation(DonationDistribution distribution);
}
