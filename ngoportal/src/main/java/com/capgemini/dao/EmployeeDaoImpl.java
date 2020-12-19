package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

//EmployeeDaoImpl class to implements All the methods of EmployeeDao Interface
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public int login(Employee employee) throws SQLException {
		Employee emp = entityManager.find(Employee.class, employee.getEmployeeId());
		if(emp == null) {
			throw new SQLException();
		}
		return 0;
	}
//Method to Add NeedyPerson
	public int createNeedyPerson(NeedyPeople person) {
		entityManager.persist(person);
		return 0;
	}
//Method to Delete NeedyPerson
	public int deleteNeedyPerson(NeedyPeople person) {
		entityManager.remove(person);
		return 0;
	}
//Method to Find NeedyPerson By Id
	public NeedyPeople readNeedyPeopleById(int id) {
		NeedyPeople needyPeople = entityManager.find(NeedyPeople.class, id);
		return needyPeople;
	}
//Method to Find NeedyPerson By Name
	public List<NeedyPeople> readNeedyPeopleByName(String name) {
		List<NeedyPeople> needyPeople = entityManager.createNamedQuery("select people by name", NeedyPeople.class).setParameter("name", name).getResultList();
		return needyPeople;
	}
//Method to Read all Needy People
	public List<NeedyPeople> readAllNeedyPeople() {
		List<NeedyPeople> needyPeople =  entityManager.createQuery("select np from NeedyPeople np", NeedyPeople.class).getResultList();
		return needyPeople;
	}
//Method to help Needy People
	public String helpNeedyPerson(DonationDistribution distribute) {
		entityManager.createNativeQuery("select p from DonationDistribution dd");
		return "Hello";
	}

}
