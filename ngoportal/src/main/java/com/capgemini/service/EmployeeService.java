package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

public interface EmployeeService {
	public boolean login(Employee employee)throws NoSuchEmployeeException;
	public boolean addNeedyPerson(NeedyPeople person);
	public boolean removeNeedyPerson(NeedyPeople person);
	public NeedyPeople findNeedyPeopleById(int id);
	public List<NeedyPeople> findNeedyPeopleByName(String name);
	public List<NeedyPeople> findAllNeedyPeople();
	public String helpNeedyPerson(DonationDistribution distribute);
}
