package com.revature.beans;

import java.sql.Blob;

public class ReimbursementRequest {
	

	private int reimbursementId;
	private int employeeId;
	private	double dollarAmount;
	private String reason;
	private Blob imageFile;
	private int status;
	private int dptId;
	
	public ReimbursementRequest(int employeeId, double dollarAmount, String reason, Blob imageFile,
			int status,int dptId) {
		super();
		this.employeeId = employeeId;
		this.dollarAmount = dollarAmount;
		this.reason = reason;
		this.imageFile = imageFile;
		this.status = status;
		this.setDptId(dptId);
	}	
	
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getDollarAmount() {
		return dollarAmount;
	}
	public void setDollarAmount(double dollarAmount) {
		this.dollarAmount = dollarAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Blob getImageFile() {
		return imageFile;
	}
	public void setImageFile(Blob imageFile) {
		this.imageFile = imageFile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDptId() {
		return dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId
				+ ", dollarAmount=" + dollarAmount + ", reason=" + reason + ", imageFile=" + imageFile + ", status="
				+ status + ", dptId=" + dptId + "]";
	}



	
	

}
