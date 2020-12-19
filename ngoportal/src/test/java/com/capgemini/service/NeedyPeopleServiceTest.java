package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.capgemini.dao.NeedyPeopleDaoImpl;
import com.capgemini.model.Address;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.NeedyPeopleServiceImpl;

/**
 * NeedyPeopleTest Class to test the NeedyPeople method
 */

@RunWith(MockitoJUnitRunner.class)
public class NeedyPeopleServiceTest {
	// Make NeedyPeopleDaoImpl as Mock Object
	@Mock
	private NeedyPeopleDaoImpl needyPeopleDao;
	// Inject Mock Object in NeedyPeopleServiceImpl class
	@InjectMocks
	private NeedyPeopleServiceImpl needyPeopleService;

	/**
	 * Method to check whether new NeedyPeople is added or created in the list or not
	 */

	@Test
	public void createNeedyPersonTest() {
		Address address = new Address();
		address.setAddressId(34);
		address.setLandmark("Near Club House");
		address.setCity("Ujjain");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonId(101);
		needyPerson.setNeedyPersonName("Shyam");
		needyPerson.setPhone("9826019923");
		//needyPerson.setFamilyIncome("5000");
		needyPerson.setAddress(address);

		needyPeopleService.registerNeedyPerson(needyPerson);
		verify(needyPeopleDao, times(1)).createNeedyPerson(needyPerson);

	}
	
	/*
	 * Method to check the registration of the NeedyPeople
	 */

	@Test
	public void testRegisterNeedyPeopleWithNull() {

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonName(null);
		NeedyPeople d1 = new NeedyPeople();
		d1.setNeedyPersonName("Shyam ");
		if (needyPerson.getNeedyPersonName() == null) {
			System.out.println("Please don't leave the column blank ");
			needyPeopleService.registerNeedyPerson(d1);
		} else
			needyPeopleService.registerNeedyPerson(needyPerson);
		verify(needyPeopleDao, times(0)).createNeedyPerson(needyPerson);
		verify(needyPeopleDao, times(1)).createNeedyPerson(d1);

	}
	
	/*
	 * Method to check or read the data of the Needy Person by Id or other details
	 */

	@Test
	public void testreadLoginData() {
		NeedyPeople d = new NeedyPeople();
		d.setNeedyPersonId(101);
		d.setNeedyPersonName("Shyam");
		d.setPhone("9826078199");
		//d.setFamilyIncome("5000");
		needyPeopleService.login(d);

		verify(needyPeopleDao, times(1)).readLoginData(d);

	}
	
	/*
	 * Method to check the Invalid Id of any Needy Person
	 */

	@Test
	public void testreadLoginDataWithInvalidId() {
		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonId(101);
		needyPeopleService.registerNeedyPerson(needyPerson);

		verify(needyPeopleDao, times(0)).readLoginData(needyPerson);

	}

}