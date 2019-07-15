package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.ConnFactory;
import com.revature.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();
		
	//returns an employee with a matching id number
	@Override
	public Employee returnEmployeeSQL(int id) throws SQLException {
		Connection conn = cf.getConnection();			
		String sql  = "Select * FROM EMPLOYEE WHERE ID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs  = ps.executeQuery();
		Employee e = null;
		while(rs.next()) {
		//constructs and returns a new employee
			e = new Employee(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(9));
			e.setEmployeeId(rs.getInt(1));
		}
		return e;
	}

	//adds a new employee object to the database
	@Override
	public void addEmployeeSQL(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ CALL INSERT_EMPLOYEE(?,?,?,?,?,?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, e.getDepartmentId());
		ps.setString(2,e.getFirstName());
		ps.setString(3,e.getLastName());
		ps.setString(4,e.getEmail());
		ps.setString(5, e.getUserName());
		ps.setString(6, e.getPassword());
		ps.setInt(7, e.getReportsTo());
		ps.setInt(8, e.getManagerOf());
		ps.execute();
	}

	//returns a list of employees in a specific department
	@Override
	public List<Employee> returnAllEmployeesByDptSQL(int dptId) throws SQLException {
		
		List<Employee> employeeListByDpt = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dptId);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(9));
			e.setEmployeeId(rs.getInt(1));
			employeeListByDpt.add(e);
		}
		return employeeListByDpt;
	}

	@Override
	public void updateEmployeeSQL(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql ="{CALL UPDATE_EMPLOYEE(?,?,?,?,?,?,?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, e.getEmployeeId());
		ps.setInt(2, e.getDepartmentId());
		ps.setString(3, e.getFirstName());
		ps.setString(4, e.getLastName());
		ps.setString(5, e.getEmail());
		ps.setString(6, e.getUserName());
		ps.setString(7, e.getPassword());
		ps.setInt(8,e.getReportsTo());
		ps.setInt(9, e.getManagerOf());
		ps.execute();
	}

	@Override
	public void removeEmployeeSQL(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e.getEmployeeId());
		ps.executeUpdate();

	}

}
