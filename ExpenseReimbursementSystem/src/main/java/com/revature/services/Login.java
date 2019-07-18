package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class Login {
	
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	private static Logger log = Logger.getRootLogger();
	
	public boolean loginTest(String username, String password) {
		List<Employee> loginVerify = new ArrayList<>();

		try {
			loginVerify.addAll(edi.returnAllEmployeesSQL());
		} catch (SQLException e) {
			log.error("A SQL exception occured when attempting to access the database to return all employees");
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			log.error("An exception occured when attempting to access the database to return all employees");
			e.printStackTrace();
			return false;
		}
	
	
		for(Employee e :loginVerify) {
			if(e.getUserName() == username) {
				if(e.getPassword() == password) {
					return true;
				}
			}
		}
	
		log.warn("Invalid Login occured for "+ username);
		return false;
	}
}
