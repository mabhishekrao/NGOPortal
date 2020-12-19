package com.capgemini.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.dao.EmployeeDaoImpl;
import com.capgemini.model.Address;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	@Mock
	private EmployeeDaoImpl employeeDao;

	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	// ---------------------------******************----------------------------------------------//
	//                 TEST CASES FOR REGISTER EMPLOYEE METHOD                                    //
	// ----------------------------******************---------------------------------------------//

	@Test  
	//Test Case to ensure that needy person is added
	public void testAddNeedyPerson() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//needyPerson.setDonationDistribution(null);

		employeeService.addNeedyPerson(needyPerson);
		verify(employeeDao, times(1)).createNeedyPerson(needyPerson);
	}

	@Test  
	//Test Case to ensure that needy person is removed
	public void testRemoveNeedyPerson() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//needyPerson.setDonationDistribution(null);

		employeeService.removeNeedyPerson(needyPerson);
		verify(employeeDao, times(1)).deleteNeedyPerson(needyPerson);
	}
	@Test  
	//Test Case to ensure that needy person is find by ID
	public void testfindNeedyPeopleById() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonId(123);
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//needyPerson.setDonationDistribution(null);

		employeeService.findNeedyPeopleById(123);
		verify(employeeDao, times(1)).readNeedyPeopleById(123);
	}
	
	@Test  
	//Test Case to ensure that needy person is find by Name
	public void readNeedyPeopleByName() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonName("Ram");
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//needyPerson.setDonationDistribution(null);

		employeeService.findNeedyPeopleByName("Ram");
		verify(employeeDao, times(1)).readNeedyPeopleByName("Ram");
	}
}
