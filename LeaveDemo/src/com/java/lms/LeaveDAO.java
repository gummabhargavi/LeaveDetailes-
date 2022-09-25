package com.java.lms;

import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
	
	static List<Leave> leaveList;
	
	static {
		leaveList = new ArrayList<Leave>();
	}
	
	
	public Leave searchLeaveDao(int leaveId) {
		Leave leaveFound = null;
		for (Leave leave : leaveList) {
			if(leave.getLeaveId()==leaveId) {
				leaveFound=leave;
				break;
			}
		}
		return leaveFound;
		
		
	}
	public List<Leave> showLeaveDao(){
		return leaveList;
	}
	
	public int generateLeaveId() {
		int leaveId=0;
		if(leaveList.isEmpty()) {
			leaveId=1;
			return leaveId;
	 }else {
		 for (Leave le : leaveList) {
			leaveId=le.getLeaveId();
		}
	 }
		leaveId++;
		return leaveId;
	}
    
	
	public String addLeaveDao(Leave leave) {
		int leaveId = generateLeaveId();
		leave.setLeaveId(leaveId);
		leaveList.add(leave);
		return "Leave record inserted";
	}
}
