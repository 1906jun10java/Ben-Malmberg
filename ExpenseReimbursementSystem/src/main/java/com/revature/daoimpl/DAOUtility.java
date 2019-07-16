package com.revature.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;
import com.revature.beans.Employee;
import com.revature.beans.ReimbursementRequest;

public class DAOUtility {
	
	private static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	private static ReimbursementRequestDAOImpl rrdi = new ReimbursementRequestDAOImpl();
	private static Logger log = Logger.getRootLogger();
	
	public static Employee tryReturnEmployeeSQL(int id) {
		try {
			
			Employee e = edi.returnEmployeeSQL(id);
			return e;
			
		} catch (SQLException e) {
			log.error("SQL exception thrown when attempting to return new employee" + e.getStackTrace()[0]);
		}catch(Exception e) {
			log.error("General exception thrown when attempting to return a new employee" + e.getStackTrace()[0]);
		}
		return null;
	}
	
	public static boolean tryAddEmployeeSQL(Employee e) {
		try {
			edi.addEmployeeSQL(e);
			return true;
		} catch (SQLException e1) {
			log.error("SQL exception thrown when attempting to add an employee to the database" + e1.getStackTrace()[0]);
		}catch(Exception e1) {
			log.error("General exception thrown when attempting to add an employee to the database" +e1.getStackTrace()[0]);
		}return false;
	}
	
	public static List<Employee> tryReturnAllEmployeesByDptSQL(int dptId){
		List<Employee> tempList = new ArrayList<>();
		try {
			tempList.addAll(edi.returnAllEmployeesByDptSQL(dptId));
			return tempList;
		} catch (SQLException e) {
			log.error("SQL Exception was thrown when attempting to return all employees by dpt from the database"+e.getStackTrace()[0]);
		}catch(Exception e) {
			log.error("General Exception thrown when attempting to return all employees by dpt from the database"+e.getStackTrace()[0]);
		}
		return null;
	}
	
	public static boolean tryUpdateEmployeeSQL(Employee e) {
		
		try {
			edi.updateEmployeeSQL(e);
			return true;
		} catch (SQLException e1) {
			log.error("A SQL Exception occured when attempting to update the Employee table on the database"+e1.getStackTrace()[0]);
		}catch(Exception e1) {
			log.error("An exception occured when attempting to update the Employee table on the database"+e1.getStackTrace()[0]);
		}return false;
	}
	
	public static boolean tryRemoveEmployeeSQL(Employee e) {
		
		try {
			edi.removeEmployeeSQL(e);
			return true;
		} catch (SQLException e1) {
			log.error("A SQL Exception occured when attempting to remove an employee from the database"+e1.getStackTrace()[0]);
		}catch(Exception e1) {
			log.error("An exception occured when attempting to remove an employee from the database"+e1.getStackTrace()[0]);
		}return false;
	}
		
	public static List<ReimbursementRequest> tryReturnAllReimbursementRequestsSQL(){
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnAllReimbursementRequestsSQL());
			return tempList;
		} catch (SQLException e) {
			log.error("A SQL Exception occured when attempting to return all reimbursement requests from the database "+e.getStackTrace()[0]);
		} catch(Exception e) {
			log.error("An exception occured when attempting to return all reimbursement requests from the database"+e.getStackTrace()[0]);
		}
		return tempList = new ArrayList<>();
	}
	
	public static List<ReimbursementRequest> tryReturnReimbursementRequestByDptSQL(int dptId){
		List<ReimbursementRequest> tempList = new ArrayList<>();
		
		try {
			tempList.addAll(rrdi.returnReimbursementRequestByDptSQL(dptId));
			return tempList;
		} catch (SQLException e) {
			log.error("A SQL Exception occured when attempting to return all reimbursement requests by department from the database"+e.getStackTrace()[0]);
		} catch(Exception e) {
			log.error("An Exception occured when attempting to return all reimbursement requests by department from the database"+e.getStackTrace()[0]);
		}
		return null;
	}
	
	public static boolean tryAddReimbursementSQL(ReimbursementRequest rr) {
		try {
			rrdi.addReimbursementSQL(rr);
			return true;
		} catch (SQLException e) {
			log.error("A SQL Exception occured when attempting to add a reimbursement request to the database"+e.getStackTrace()[0]);
			e.printStackTrace();
		} catch(Exception e) {
			log.error("An Exception occured when attempting to add a reimbursement request to the database"+e.getStackTrace()[0]);
			e.printStackTrace();
		}return false;
	}
	
	public static boolean tryRemoveReimbursementRequestSQL(int rID) {
		
		try {
			rrdi.removeReimbusementRequestSQL(rID);
			return true;
		} catch (SQLException e) {
			log.error("A SQL Exception occured when attempting to remove a reimbursement request from the database"+e.getStackTrace()[0]);
		} catch(Exception e) {
			log.error("An exception occured when attempting to remove a reimbursement request from the database"+e.getStackTrace()[0]);
		}
		return false;
	}
	
	public static List<ReimbursementRequest> tryReturnReimbursementRequestByEmployeeId(int id) {
		
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnReimbursementRequestsByEmployeeID(id));
			return tempList;
		} catch (SQLException e) {
			log.error("A SQL Exception occured when attemting to return a reimbursement request from the database by employeeId"+e.getStackTrace()[0]);
		} catch (Exception e) {
			log.error("An exception occured when attempting to return a reimbursement request from the database by employee id"+e.getStackTrace()[0]);
		}
		return null;
	}
	

}
