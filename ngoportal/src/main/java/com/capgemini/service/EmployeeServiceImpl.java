package com.capgemini.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.util.Util;
import com.capgemini.dao.EmployeeDaoImpl;

//EmployeeServiceImpl class to implements All the methods of EmployeeService Interface
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	private final EntityManager entityManager;
	
	public EmployeeServiceImpl() {
		Util util = Util.getInstance();
		entityManager = util.getEntityManager();
		employeeDao = new EmployeeDaoImpl(entityManager);
	}
//Method to Employee Login
	public boolean login(Employee employee) throws NoSuchEmployeeException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			employeeDao.login(employee);
		} catch (SQLException e) {
			throw new NoSuchEmployeeException("There is No employee With Matching credentials");
		}
		entityTransaction.commit();
		return true;
	}

//Method to Add NeedyPerson
	public boolean addNeedyPerson(NeedyPeople person) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		employeeDao.createNeedyPerson(person);
		entityTransaction.commit();
		return false;
	}

//Method to Remove NeedyPerson
	public boolean removeNeedyPerson(NeedyPeople person) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		employeeDao.deleteNeedyPerson(person);
		entityTransaction.commit();
		return false;
	}
//Method to Find NeedyPerson By Id
	public NeedyPeople findNeedyPeopleById(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		NeedyPeople needyPeople = employeeDao.readNeedyPeopleById(id);
		entityTransaction.commit();
		return needyPeople;
	}
//Method to Find NeedyPerson By Name
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<NeedyPeople> needyPeople = employeeDao.readNeedyPeopleByName(name);
		entityTransaction.commit();
		return needyPeople;
	}
//Method to Find All NeedyPeople
	public List<NeedyPeople> findAllNeedyPeople() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<NeedyPeople> needyPeople = employeeDao.readAllNeedyPeople();
		entityTransaction.commit();
		return needyPeople;
	}
//Method to Help NeedyPeople
	public String helpNeedyPerson(DonationDistribution distribute) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String s = employeeDao.helpNeedyPerson(distribute);
		entityTransaction.commit();
		return s;
	}

}
