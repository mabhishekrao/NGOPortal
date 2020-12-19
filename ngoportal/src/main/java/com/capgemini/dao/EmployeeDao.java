package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

public interface EmployeeDao {
	public int login(Employee employee) throws SQLException;
	public int createNeedyPerson(NeedyPeople person);
	public int deleteNeedyPerson(NeedyPeople person);
	public NeedyPeople readNeedyPeopleById(int id);
	public List<NeedyPeople> readNeedyPeopleByName(String name);
	public List<NeedyPeople> readAllNeedyPeople();
	public String helpNeedyPerson(DonationDistribution distribute);
}
