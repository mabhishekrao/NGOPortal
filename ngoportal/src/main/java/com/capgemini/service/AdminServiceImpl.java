package com.capgemini.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.AdminDaoImpl;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.util.Util;

/**
 * AdminServiceImpl Class To implements all the method of AdminService Interface
 */
public class AdminServiceImpl implements AdminService {

	private final EntityManager entityManager;
	private AdminDao adminDao;

	public AdminServiceImpl() {
		Util util = Util.getInstance();
		entityManager = util.getEntityManager();
		adminDao = new AdminDaoImpl(entityManager);
	}

	/*
	 * Method To Add Employee
	 */
	public boolean addEmployee(Employee employee) throws DuplicateEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			adminDao.createEmployee(employee);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new DuplicateEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return false;
	}

	/*
	 * * Method to check whether Employee details is updated or not 
	 */
	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee emp = null;
		try {
			emp = adminDao.updateEmployee(employee);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return emp;
	}

	/*
	 * * Method to remove Employee 
	 */
	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			adminDao.deleteEmployee(employeeId);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return false;
	}

	/*
	 * * Method to Find Employee Details By Using Employee Id 
	 */
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee emp = null;
		try {
			emp = adminDao.readEmployeeById(employeeId);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return emp;
	}

	/*
	 * * Method to Find Employee Details By Using Employee Name 
	 */
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Employee> listOfEmployees = null;
		try {
			listOfEmployees = adminDao.readEmployeeByName(name);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return listOfEmployees;
	}

	/*
	 * Method to Find All Employees Details
	 */
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Employee> listOfEmployees = null;
		try {
			listOfEmployees = adminDao.readAllEmployees();
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchEmployeeException(e.getMessage());
		}
		entityTransaction.commit();
		return listOfEmployees;
	}

	/*
	 * *Method to Approve Donation
	 */
	public boolean approveDonation(DonationDistribution distribution) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		adminDao.approveDonation(distribution);
		entityTransaction.commit();
		return true;
	}

}
