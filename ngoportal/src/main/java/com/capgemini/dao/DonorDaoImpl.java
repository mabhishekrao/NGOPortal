package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

public class DonorDaoImpl implements DonorDao {

	private EntityManager entityManager;

	/*
	 * Instantiating entityManager 
	 */
	public DonorDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Method : createDonor 
	 * Use : This method is used to create the Donor, by taking
	 * the attribute values from the user in form of the Donor Object.
	 * 
	 * @param donor
	 * @return Donor
	 */
	public int createDonor(Donor donor) throws SQLException {
		List<Donor> donors = entityManager.createNamedQuery("query by username", Donor.class)
				.setParameter("username", donor.getDonorUsername()).getResultList();
		if (donors.size() > 0) {
			throw new SQLException("Donor Already Exists With Id " + donor.getDonorUsername());
		}
		entityManager.persist(donor);
		return 0;
	}

	/**
	 * Method : login 
	 * Use : This method is used to log the Donor in to his/her
	 * account by taking the username and password from the donor object.
	 * 
	 * @param donor
	 * @return boolean: to ensure whether logged or not!
	 */
	public int login(Donor donor) throws SQLException {
		List<Donor> donors = entityManager.createNamedQuery("query by username and password", Donor.class)
				.setParameter("username", donor.getDonorUsername()).setParameter("password", donor.getDonorPassword())
				.getResultList();
		if (donors.size() == 0) {
			throw new SQLException("No Donors With Matching credentials Exists");
		}
		return 0;
	}

	/**
	 * Method : donateToNGO 
	 * Use : This method is used to create the Donation, by
	 * taking the attribute values from the donor in form of the Donation Object.
	 * 
	 * @param Donation
	 * @return Donation
	 */
	public Donation donateToNGO(Donation donation) {
		entityManager.persist(donation);
		return donation;
	}
	
	/**
	 * Method : forgotPassword 
	 * Use : This method is used to change the Password of
	 * the Donor's account.
	 * 
	 * @param username : The username of account to forgot its password.
	 * @param password : The new password to be updated.
	 * @return boolean: to ensure whether password changed or not. True/False
	 */
	public String forgotPassword(String username) {
		Donor donor = entityManager.createNamedQuery("query by username for password", Donor.class)
				.setParameter("username", username).getSingleResult();
		return donor.getDonorPassword();
	}
	/**
	 * Method : resetPassword 
	 * Use : This method is used to change the Password of
	 * the Donor's account.
	 * 
	 * @param username : The username of account to resetf its password.
	 * @param password : The new password to be updated.
	 * @return boolean: to ensure whether password changed or not. True/False
	 */
	public String resetPassword(String username) {
		Donor donor = entityManager.createNamedQuery("query by username for password", Donor.class)
				.setParameter("username", username).getSingleResult();
		donor.setDonorPassword("New Password");
		return donor.getDonorPassword();
	}

}
