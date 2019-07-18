package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public Employee returnEmployeeSQL(int id)
	throws SQLException;
	
	public void addEmployeeSQL(Employee e)
	throws SQLException;
	
	public List<Employee>returnAllEmployeesSQL()
	throws SQLException;
	
	public void updateEmployeeSQL(Employee e)
	throws SQLException;
	
	public void removeEmployeeSQL(int id)
	throws SQLException;

}
