package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementRequest;
import com.revature.daoimpl.ReimbursementRequestDAOImpl;

public class ReimbursementUtility {
	
	ReimbursementRequestDAOImpl rrdi = new ReimbursementRequestDAOImpl();
	
	public boolean generateReimbursement(ReimbursementRequest rr) {
		try {
			rrdi.addReimbursementSQL(rr);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<ReimbursementRequest> returnRequestsByEmployeeID(int id){
		
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnReimbursementRequestsByEmployeeID(id));
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
