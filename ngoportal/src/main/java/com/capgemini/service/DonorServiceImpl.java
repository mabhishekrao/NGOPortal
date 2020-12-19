package com.capgemini.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capgemini.dao.DonorDao;
import com.capgemini.dao.DonorDaoImpl;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donation;
import com.capgemini.model.Donor;
import com.capgemini.util.Util;

//Class DonorServiceImpl
public class DonorServiceImpl implements DonorService {
	
	private final EntityManager entityManager;
	private DonorDao donorDao;
	
	/*
	 * Instantiating entityManager using the Util Class that is created as a common
	 * class to be used throughout the project for the Management of Transactions
	 * and the Entity Managers.
	 */
	public DonorServiceImpl() {
		Util util = Util.getInstance();
		entityManager = util.getEntityManager();
		donorDao = new DonorDaoImpl(entityManager);
	}
	/**
	 * Method : registereDonor 
	 * Use : This method is used to register the Donor, by taking
	 * the attribute values from the user in form of the Donor Object.
	 * 
	 * @param donor
	 * @return Donor
	 */
	public boolean registerDonor(Donor donor) throws DuplicateDonorException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			donorDao.createDonor(donor);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new DuplicateDonorException(e.getMessage());
		}
		entityTransaction.commit();
		return true;
	}
	/**
	 * Method : login 
	 * Use : This method is used to log the Donor in to his/her
	 * account by taking the username and password from the donor object.
	 * 
	 * @param donor
	 * @return boolean: to ensure whether logged or not!
	 */
	public boolean login(Donor donor) throws NoSuchDonorException {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			donorDao.login(donor);
		} catch (SQLException e) {
			entityTransaction.commit();
			throw new NoSuchDonorException(e.getMessage());
		}
		entityTransaction.commit();
		return true;
	}
	/**
	 * Method : donateToNGO 
	 * Use : This method is used to create the Donation, by
	 * taking the attribute values from the donor in form of the Donation Object.
	 * 
	 * @param Donation object
	 * @return Donation object
	 */
	public Donation donateToNGO(Donation donation) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Donation dn = donorDao.donateToNGO(donation);
		entityTransaction.commit();
		return dn;
	}

	public void sendThankyouMailToDonator(Donor donor) {
		boolean status;
		try {
			status = login(donor);
		} catch (NoSuchDonorException e) {
			throw new RuntimeException(e.getMessage());
		}
		if(status) {
			System.out.println("Thank You " + donor.getDonorName() + " For Donating Amount");
		}
		
	}
	/**
	 * Method : forgotPassword 
	 * Use : This method is used to change the Password of
	 * the Donor's account.
	 * 
	 * @param username : The username of account to forgot its password.
	 * @param password : The new password to be updated.
	 * @return String  : It returns password
	 */
	public String forgotPassword(String username) {
		String password = donorDao.forgotPassword(username);
		return password;
	}
	/**
	 * Method : resetPassword 
	 * Use : This method is used to change the Password of
	 * the Donor's account.
	 * 
	 * @param username : The username of account to resetf its password.
	 * @param password : The new password to be updated.
	 * @return String  : It returns password
	 */
	public String resetPassword(String username) {
		String password = donorDao.resetPassword(username);
		return password;
	}
	/**
	 * Method : emailPasseordToDonor 
	 * Use : This method is used to change the Password of
	 * the Donor's account.
	 * 
	 * @param username : The email of the DOnor is passed.
	 * @return void    : It displays thank you msg and email to the user
	 */
	public void emailPasswordToDonor(String email) {
		resetPassword(email);
		System.out.println("Thank You");
	}

}
