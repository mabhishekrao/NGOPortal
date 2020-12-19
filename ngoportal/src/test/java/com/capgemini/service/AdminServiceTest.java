package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.dao.AdminDaoImpl;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import com.capgemini.service.AdminServiceImpl;

/**
 * 
 * AdminServiceTest class To Test All the Methods of AdminService Interface
 * 
 */

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

	// Make AdminDaoImpl as Mock Object
	@Mock
	private AdminDaoImpl adminDao;
	// Inject Mock Object in AdminServiceImpl Class
	@InjectMocks
	private AdminService adminService = new AdminServiceImpl();

	/**
	 * Method to check whether new employee is created or not
	 */
	@Test
	public void testCreateEmployee() throws DuplicateEmployeeException {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");

		adminService.addEmployee(e1);
		try {
			verify(adminDao, times(1)).createEmployee(e1);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	/**
	 * Method to check whether There is Duplicate Employee
	 */
//	@Test(expected = DuplicateEmployeeException.class)
//	public void whenDuplicateEmployeeThenThrowException() throws DuplicateEmployeeException {
//		Employee employee = new Employee();
//		employee.setEmployeeId(123);
//		adminService.addEmployee(employee);
//
//	}

	/**
	 * Method to check whether Employee Details are Updated or Not
	 */
	@Test
	public void modifyEmployeeTest() throws NoSuchEmployeeException {
		Employee employee = new Employee();
		Address address = new Address();
		address.setAddressId(456);
		address.setCity("pune");
		address.setState("mumbai");
		address.setPin("1234");
		address.setLandmark("shop");

		employee.setEmployeeId(123);
		employee.setEmployeeName("dcb");
		employee.setEmail("abcd@gmail.com");
		employee.setPhone("12345678");
		employee.setAddress(address);
		employee.setUsername("user");
		employee.setPassword("user123");
		adminService.modifyEmployee(employee);
		try {
			verify(adminDao, times(1)).updateEmployee(employee);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method to check whether Employee is Removed or Not
	 */
	@Test
	public void removeEmployeeTest() throws NoSuchEmployeeException {
		Employee employee = new Employee();
		Address address = new Address();
		address.setAddressId(456);
		address.setCity("pune");
		address.setState("mumbai");
		address.setPin("1234");
		address.setLandmark("shop");
		employee.setEmployeeId(123);
		employee.setEmployeeName("abc");
		employee.setEmail("abc@gmail.com");
		employee.setPhone("12345678");
		employee.setAddress(address);
		employee.setUsername("user");
		employee.setPassword("user123");
		adminService.removeEmployee(123);
		try {
			verify(adminDao, times(1)).deleteEmployee(123);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method to check whether there Employee of given Id Exist or Not
	 */
	@Test
	public void findEmployeeByIdTest() throws NoSuchEmployeeException {

		Employee employee = new Employee();
		Address address = new Address();
		address.setAddressId(456);
		address.setCity("pune");
		address.setState("mumbai");
		address.setPin("1234");
		address.setLandmark("shop");
		employee.setEmployeeId(123);
		employee.setEmployeeName("abc");
		employee.setEmail("abc@gmail.com");
		employee.setPhone("12345678");
		employee.setAddress(address);
		employee.setUsername("user");
		employee.setPassword("user123");
		adminService.findEmployeeById(123);
		try {
			verify(adminDao, times(1)).readEmployeeById(123);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method to check whether there is Employee of given Name or Not
	 */
	@Test
	public void findEmployeeByNameTest() throws NoSuchEmployeeException {

		Employee employee = new Employee();
		Address address = new Address();
		address.setAddressId(456);
		address.setCity("pune");
		address.setState("mumbai");
		address.setPin("1234");
		address.setLandmark("shop");
		employee.setEmployeeId(123);
		employee.setEmployeeName("abc");
		employee.setEmail("abc@gmail.com");
		employee.setPhone("12345678");
		employee.setAddress(address);
		employee.setUsername("user");
		employee.setPassword("user123");
		adminService.findEmployeeByName("abc");
		try {
			verify(adminDao, times(1)).readEmployeeByName("abc");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method to check whether All Employees Details are Retrieved or Not
	 */
	@Test
	public void findAllEmployeeTest() throws NoSuchEmployeeException {
		List<Employee> list1 = new ArrayList();
		Employee e1 = new Employee();
		Address address = new Address();
		address.setAddressId(456);
		address.setCity("pune");
		address.setState("mumbai");
		address.setPin("1234");
		address.setLandmark("shop");
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");
		list1.add(e1);
		adminService.findAllEmployee();
		try {
			verify(adminDao, times(1)).readAllEmployees();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Method to check whether Donation is Approved or Not
	 */
	@Test
	public void approveDonationTest() {
		DonationDistribution distribution = new DonationDistribution();
		boolean checkApproval = adminService.approveDonation(distribution);
		assertTrue(checkApproval);

	}
}