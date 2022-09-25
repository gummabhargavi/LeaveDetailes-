package com.java.lms;

import java.util.Date;
import java.util.List;

public class LeaveBAL {
	
	static StringBuilder sb = new StringBuilder();
	
	static LeaveDAO dao = new LeaveDAO();
	
	
	
	
	public Leave  searchLeaveBal(int leaveId) {
		return dao.searchLeaveDao(leaveId);
		
	}
	
	public List<Leave> showLeaveBal(){
		return dao.showLeaveDao();
	}
	
	public String addLeaveBal(Leave leave) throws LeaveException{
		if(isValid(leave)==true) {
			throw new LeaveException(sb.toString());

    }
		return dao.addLeaveDao(leave);
	}
   public boolean isValid(Leave leave) {
	   boolean valid=true;
	   Date today = new Date();
		long diff = (long) today.getTime() - leave.getLeaveStartDate().getTime();
		int days = (int)(diff/(1000*60*60*24));
		days++;
		if (days >= 0) {
			sb.append("LeaveStartDate cannot be Yesterday's date...\r\n");
			valid=false;
		}

		diff = (long)today.getTime() - leave.getLeaveEndDate().getTime();
		days = (int)(diff/(1000*60*60*24));
		days++;
		if (days >= 0) {
			sb.append("LeaveEndDate Cannot be Yesterday's Date...\r\n");
			valid=false;
		}
		diff =(long)leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
		days = (int)(diff/(1000*24*60*60));
		days++;
		if (days <= 0) {
			sb.append("LeaveStartDate Cannot be Greater Than LeaveEndDate...\r\n");
		}
		if (valid==true) {
			leave.setNoOfDays(days);
		}
		return valid;
	}
}
	

