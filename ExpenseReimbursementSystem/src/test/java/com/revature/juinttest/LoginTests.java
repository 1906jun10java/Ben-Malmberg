package com.revature.juinttest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.runners.*;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.ReimbursementRequest;
import com.revature.daoimpl.DAOUtility;
import com.revature.services.Login;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {

	Login login = new Login();

	@Test
	public void AemployeeLoginFailureTest() {
		assertFalse(login.checkEmployeeLoginCredentials("wrong", "wrong", 0));
	}

	@Test
	public void BmanagerLoginFailureTest() {
		assertFalse(login.checkManagerLoginCredentials("wrong", "wrong", 0));
	}

	@Test
	public void CaddEmployeeTest() {
		Employee e = new Employee(0, "Tony", "Danza", "whoseTheBoss@gmail.com", "the", "boss", 0, 0);
		assertTrue(DAOUtility.tryAddEmployeeSQL(e));
	}

	@Test
	public void DreturnEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		assertNotNull(DAOUtility.tryReturnEmployeeSQL(e.getEmployeeId()));
	}

	public Employee returnAllEmployeesByDptTest() {
		List<Employee> tempList = new ArrayList<>();
		tempList.addAll(DAOUtility.tryReturnAllEmployeesByDptSQL(0));
		for (Employee e : tempList) {
			if (e.getUserName().equals("the")) {
				return e;
			}
		}
		return null;
	}

	@Test
	public void EupdateEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		e.setEmail("newemail@gmail.com");
		assertTrue(DAOUtility.tryUpdateEmployeeSQL(e));
	}
	
	@Test
	public void FaddReimbursementTest() {
		Employee e = returnAllEmployeesByDptTest();
		ReimbursementRequest rr = new ReimbursementRequest(e.getEmployeeId(), 20.00, "test",null, 1, e.getDepartmentId());
		assertTrue(DAOUtility.tryAddReimbursementSQL(rr));
	}

	@Test
	public void zDeleteEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		assertTrue(DAOUtility.tryRemoveEmployeeSQL(e));
	}

}
