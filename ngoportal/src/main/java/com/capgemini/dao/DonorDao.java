package com.capgemini.dao;

import java.sql.SQLException;

import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

public interface DonorDao {
	public int createDonor(Donor donor) throws SQLException;
	public int login(Donor donor) throws SQLException;
	public Donation donateToNGO(Donation donation);
	public String forgotPassword(String username);
	public String resetPassword(String username);
}
