package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

import com.revature.beans.Employee;
import com.revature.daoimpl.DAOUtility;

public class Login {
	
	Logger log = Logger.getRootLogger();
	
	public boolean checkEmployeeLoginCredentials(String userName,String password,int dptId) {
		List<Employee> employeeLoginList = new ArrayList<>();
		employeeLoginList.addAll(DAOUtility.tryReturnAllEmployeesByDptSQL(dptId));
		
		try {
			for(Employee e:employeeLoginList) {
				if(e.getUserName().contentEquals(userName)) {
					if(e.getPassword().contentEquals(password)) {
						log.trace("Account "+userName+" accessed");
						return true;
					}
				}
			}
		}catch(NullPointerException e) {
			log.fatal("employeeList came back null");
		}
		log.warn("Invalid Login attempt occurred for user account "+ userName);
		return false;
	}
	
	public boolean checkManagerLoginCredentials(String userName,String password,int dptId) {
		
		List<Employee> employeeLoginList = new ArrayList<>();
		
		employeeLoginList = DAOUtility.tryReturnAllEmployeesByDptSQL(dptId);
		try {
			for(Employee e: employeeLoginList) {
					if(e.getManagerOf() >= 1) {
						if(e.getUserName().contentEquals(userName)) {
							if(e.getPassword().contentEquals(password)) {
								return true;
							
						}
					}
				}
			}
		}catch(NullPointerException e) {
			log.fatal("Employee or Manager list came back null!");
		}
		log.warn("Invalid login attempt occurred for manager account "+userName);
		return false;
	}
}
