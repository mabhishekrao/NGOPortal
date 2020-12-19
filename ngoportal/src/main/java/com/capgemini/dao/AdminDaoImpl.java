package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;

/*
 * AdminDaoImpl class to implements all the method of AdminDao Interface
 */
public class AdminDaoImpl implements AdminDao {

	private EntityManager entityManager;

	public AdminDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * Method To Add Employee
	 */
	public int createEmployee(Employee employee) throws SQLException {
		List<Employee> emp = entityManager.createNamedQuery("query by empusername", Employee.class)
				.setParameter("username", employee.getUsername()).getResultList();
		if (emp.size() > 0) {
			throw new SQLException("Employee With These Credentials Already Exists");
		}
		entityManager.persist(employee);
		return 0;
	}

	/*
	 * * Method to check whether Employee details is updated or not
	 */
	public Employee updateEmployee(Employee employee) throws SQLException {
		Employee emp = entityManager.find(Employee.class, employee.getEmployeeId());
		if (emp == null) {
			throw new SQLException("Employee with employee id " + employee.getEmployeeId() + " Does Not Exists");
		}
		entityManager.merge(employee);
		return employee;
	}

	/*
	 * * Method to remove Employee 
	 */
	public int deleteEmployee(int employeeId) throws SQLException {
		Employee emp = entityManager.find(Employee.class, employeeId);
		if (emp == null) {
			throw new SQLException("No Such Employee Found with Employee Id " + employeeId);
		}
		entityManager.remove(emp);
		return 0;
	}

	/*
	 * * Method to Find Employee Details By Using Employee Id
	 */
	public Employee readEmployeeById(int employeeId) throws SQLException {
		Employee emp = entityManager.find(Employee.class, employeeId);
		if (emp == null) {
			throw new SQLException("No Such Employee Found with Employee Id " + employeeId);
		}
		return emp;
	}

	/*
	 * * Method to Find Employee Details By Using Employee Name
	 */
	public List<Employee> readEmployeeByName(String name) throws SQLException {
		List<Employee> listOfEmployees = entityManager.createNamedQuery("query by name", Employee.class)
				.setParameter("name", name).getResultList();
		if (listOfEmployees.size() == 0) {
			throw new SQLException("No Employees Exists With Name " + name);
		}
		return listOfEmployees;
	}

	/*
	 * Method to Find All Employees Details
	 */
	public List<Employee> readAllEmployees() throws SQLException {
		List<Employee> listOfEmployees = entityManager.createQuery("select emp from Employee emp", Employee.class)
				.getResultList();
		if (listOfEmployees.size() == 0) {
			throw new SQLException("No Employees Found in the Database");
		}
		return listOfEmployees;
	}

	/*
	 * *Method to Approve Donation
	 */
	public boolean approveDonation(DonationDistribution distribution) {
		entityManager.persist(distribution);
		return true;
	}

}
