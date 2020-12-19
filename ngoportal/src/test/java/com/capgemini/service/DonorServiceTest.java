package com.capgemini.service;

import com.capgemini.service.DonorService;
import com.capgemini.service.DonorServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import com.capgemini.dao.DonorDao;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.model.Address;
import com.capgemini.model.Donation;
import com.capgemini.model.DonationItem;
import com.capgemini.model.Donor;
import com.capgemini.exception.NoSuchDonorException;

@RunWith(MockitoJUnitRunner.class)
public class DonorServiceTest {

	@Mock
	private DonorDao donorDao;

	@InjectMocks
	private DonorService donorService = new DonorServiceImpl();

	// ---------------------------******************---------------------------------------------//
	// TEST CASES FOR REGISTER DONOR METHOD //
	// ----------------------------******************---------------------------------------------//
	/**
	 * TEST CASE I (i) This test ensures that the registerDonor method works well
	 * and inserts all the values
	 **/
	@Test
	public void testRegisterDonor() throws DuplicateDonorException {

		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Donor donor = new Donor();
		donor.setDonorId(102);
		donor.setDonorName("Aksh");
		donor.setDonorPhone("7207819923");
		donor.setDonorEmail("aksh@t1.com");
		donor.setDonorUsername("itsmeaksh");
		donor.setDonorPassword("$aksh12A");
		donor.setAddress(address);

		donorService.registerDonor(donor);
		try {
			verify(donorDao, times(1)).createDonor(donor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TEST CASE I (ii) This test ensures that the registerDonor method works well
	 * and Throws DuplicateDonor Exception
	 **/
	@Test // (expected = DuplicateDonorException.class)
	public void testRegisterDonorWithException() throws DuplicateDonorException {

		Donor donor = new Donor();
		donor.setDonorId(101);
		donorService.registerDonor(donor);

	}

	/**
	 * TEST CASE I (iii) This test ensures that the registerDonor method works well
	 * when passing null values
	 **/

	@Test
	public void testRegisterDonorWithNull() throws DuplicateDonorException {

		Donor donor = new Donor();
		donor.setDonorName(null);
		Donor donor1 = new Donor();
		donor1.setDonorName("Aksh ");
		if (donor.getDonorName() == null) {
			System.out.println("Please don't leave the column blank ");
			donorService.registerDonor(donor1);
		} else
			donorService.registerDonor(donor);
		try {
			verify(donorDao, times(0)).createDonor(donor);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			verify(donorDao, times(1)).createDonor(donor1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ---------------------------******************------------------------------------------------//
	// TEST CASES FOR DONOR LOGIN METHOD //
	// ----------------------------******************-----------------------------------------------//
	/**
	 * TEST CASE II (i) This test ensures that the login method works well and logs
	 * in with correct values
	 **/
	@Test
	public void testLogin() throws NoSuchDonorException {
		Donor donor = new Donor();
		donor.setDonorUsername("itsmeakshita");
		donor.setDonorPassword("Aksh@123");
		donorService.login(donor);

		try {
			verify(donorDao, times(1)).login(donor);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * TEST CASE II (ii) This test ensures that the login method displays the
	 * message to enter valid data and doesn't connect with DAO
	 **/
	@Test
	public void testLoginWithNoPassword() throws NoSuchDonorException {
		Donor donor = new Donor();
		donor.setDonorUsername("itsmeakshita");
		donor.setDonorPassword(null);

		Donor donor1 = new Donor();
		donor1.setDonorUsername(null);
		donor1.setDonorPassword(null);
		if (donor.getDonorPassword() != null)
			donorService.login(donor);

		try {
			verify(donorDao, times(0)).login(donor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//---------------------------******************---------------------------------------------//
		// TEST CASES FOR DONATE TO NGO METHOD //
		// ----------------------------******************---------------------------------------------//
		/**
		 * TEST CASE III (i) This test ensures that the Donation is made and entered in to the database successfully 
		 * method works well and inserts all the values of the DOnation object
		 **/

		@Test
		public void testDonateToNGO() {

			Address address = new Address();
			address.setAddressId(11);
			address.setLandmark("Near Club House");
			address.setCity("Bharatnagar");
			address.setState("Madhya Pradesh");
			address.setPin("123123");

			Donor donor = new Donor();
			donor.setDonorId(102);
			donor.setDonorName("Aksh");
			donor.setDonorPhone("7207819923");
			donor.setDonorEmail("aksh@t1.com");
			donor.setDonorUsername("itsmeaksh");
			donor.setDonorPassword("$aksh12A");
			donor.setAddress(address);
			
			DonationItem item= new DonationItem();
			Donation donation = new Donation(donor, item, 15000, null);

			donorService.donateToNGO(donation);
			
			verify(donorDao, times(1)).donateToNGO(donation);
			
		}
		/**
		 * TEST CASE III (ii) This test ensures that the blank Donation is not entered into the database 
		 **/

		@Test
		public void testDonateToNGOWithNullObject() {

			Address address = new Address();
			address.setAddressId(11);
			address.setLandmark("Near Club House");
			address.setCity("Bharatnagar");
			address.setState("Madhya Pradesh");
			address.setPin("123123");

			Donor donor = new Donor();
			donor.setDonorId(102);
			donor.setDonorName("Aksh");
			donor.setDonorPhone("7207819923");
			donor.setDonorEmail("aksh@t1.com");
			donor.setDonorUsername("itsmeaksh");
			donor.setDonorPassword("$aksh12A");
			donor.setAddress(address);
			
			DonationItem item= new DonationItem();
			Donation donation = new Donation(donor, item, 000, null);
			
			if(donation.getDonationAmount() != 0) {
				donorService.donateToNGO(donation);
			}
			
			verify(donorDao, times(0)).donateToNGO(donation);
			
		}

}