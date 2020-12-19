package com.capgemini;

import java.util.List;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;
import com.capgemini.model.Donation;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.DonationDistributionStatus;
import com.capgemini.model.DonationItem;
import com.capgemini.model.DonationType;
import com.capgemini.model.Donor;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.AdminService;
import com.capgemini.service.AdminServiceImpl;
import com.capgemini.service.DonorService;
import com.capgemini.service.DonorServiceImpl;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImpl;
import com.capgemini.service.NeedyPeopleService;
import com.capgemini.service.NeedyPeopleServiceImpl;
import com.capgemini.util.Util;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMain a = new AppMain();

		System.out.println("<<<<<<<<<<<<<<<<FirstFirstFirst>>>>>>>>>>>>>");
		a.executeAdminService();
		
		System.out.println("<<<<<<<<<<<<<<<<SecondSecondSecond>>>>>>>>>>>>>");
		a.executeDonorService();

		System.out.println("<<<<<<<<<<<<<<<<ThirdThirdThird>>>>>>>>>>>>>");
		try {
			a.executeEmployeeService();
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("<<<<<<<<<<<<<<<<FourthFourthFourth>>>>>>>>>>>>>");
		a.executeNeedyPeopleService();

		Util util = Util.getInstance();
		util.close();

	}

	public void executeDonorService() {
		DonorService donorService = new DonorServiceImpl();
		Address address = new Address("abc", "bcd", "cda", "dab");
		Donor donor = new Donor("abc", "aabc", "aann", "aamm", "mmaa", address);
		try {
			donorService.registerDonor(donor);
		} catch (DuplicateDonorException e) {
			System.out.println(e.getMessage());
		}

		DonationItem donationItem = new DonationItem(DonationType.BOOKS, "BOOKS AND BOOKS AND NOTHING ELSE");
		Donation donation = new Donation(donor, donationItem, 45, null);
		donorService.donateToNGO(donation);

		try {
			donorService.login(donor);
		} catch (NoSuchDonorException e) {
			System.out.println(e.getMessage());
		}
	}

	public void executeAdminService() {
		AdminService adminService = new AdminServiceImpl();
		Address address = new Address("abc", "bcd", "cda", "dab");
		Employee employee = new Employee("abc", "abc", "abc", address, "abc", "abc");
		try {
			adminService.addEmployee(employee);
		} catch (DuplicateEmployeeException e) {
			System.out.println(e.getMessage());
		}

		NeedyPeople person = new NeedyPeople("abc", "abc", 4.5, address);
		DonationItem donationItem = new DonationItem(DonationType.BOOKS, "BOOKS AND BOOKS AND NOTHING ELSE");
		DonationDistribution donationDistribution = new DonationDistribution(person, donationItem, employee, 45, null,
				null, DonationDistributionStatus.APPROVED);
		adminService.approveDonation(donationDistribution);

		List<Employee> emps = null;
		try {
			emps = adminService.findAllEmployee();
		} catch (NoSuchEmployeeException e) {
			System.out.println(e.getMessage());
		}
		for (Employee emp : emps) {
			System.out.println("Employee is " + emp.getPassword());
		}

		Employee emp = new Employee();
		try {
			emp = adminService.findEmployeeById(2);
		} catch (NoSuchEmployeeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(emp.getEmployeeId());

		List<Employee> emN = null;
		try {
			emN = adminService.findEmployeeByName("abc");
		} catch (NoSuchEmployeeException e) {
			System.out.println(e.getMessage());
		}

		for (Employee e : emN) {
			System.out.println(e.getEmail());
		}

		try {
			emp = adminService.modifyEmployee(employee);
		} catch (NoSuchEmployeeException e1) {
			System.out.println(e1.getMessage());
		}

		try {
			adminService.removeEmployee(2);
		} catch (NoSuchEmployeeException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void executeNeedyPeopleService() {
		NeedyPeopleService needyPeopleService = new NeedyPeopleServiceImpl();
		Address address = new Address("abc", "bcd", "cda", "dab");
		NeedyPeople person = new NeedyPeople("abc", "abc", 4.5, address);
		needyPeopleService.registerNeedyPerson(person);

		needyPeopleService.login(person);

		needyPeopleService.requestForHelp(person);
	}

	public void executeEmployeeService() {
		EmployeeService service = new EmployeeServiceImpl();
		Address address = new Address("abc", "bcd", "cda", "dab");
		NeedyPeople needyPeople = new NeedyPeople("abc", "bcd", 4.5, address);
		service.addNeedyPerson(needyPeople);
		// Employee employee = new Employee();
		// try {
		// service.login(employee);
		// } catch (NoSuchEmployeeException e) {
		// System.out.println(e.getMessage());
		// }
		NeedyPeople np = service.findNeedyPeopleById(1);
		if(np == null) {
			throw new RuntimeException("No Needy People with matching id found");
		}
		System.out.println(np.getFamilyIncome());
		List<NeedyPeople> needyPeopl = service.findNeedyPeopleByName("abc");
		for (NeedyPeople np1 : needyPeopl) {
			System.out.println(np1.getNeedyPersonId());
		}
		needyPeopl = service.findAllNeedyPeople();
		for (NeedyPeople np1 : needyPeopl) {
			System.out.println(np1.getNeedyPersonId());
		}
		service.removeNeedyPerson(needyPeople);
		Employee employee = new Employee("abc", "acd", "adc", address, "acv", "jjj");
		try {
			service.login(employee);
		} catch (NoSuchEmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
