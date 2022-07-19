package com.training.model;

public class LeaveEntity 
{
	private int serialNo;
	private String employeeId;
	private String employeeName;
	private String fromDate;
	private String toDate;
	private String reason;
	private String managerId;
	private String Status;
	/**
	 * 
	 */
	public LeaveEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveEntity(int serialNo, String employeeId, String employeeName, String fromDate, String toDate,
			String reason, String managerId, String status) {
		super();
		this.serialNo = serialNo;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.managerId = managerId;
		Status = status;
	}

	public LeaveEntity(String employeeId, String employeeName, String fromDate, String toDate, String reason,
			String managerId, String status) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.managerId = managerId;
		Status = status;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "LeaveEntity [serialNo=" + serialNo + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", reason=" + reason + ", managerId=" + managerId
				+ ", Status=" + Status + "]";
	}

	
	
}
