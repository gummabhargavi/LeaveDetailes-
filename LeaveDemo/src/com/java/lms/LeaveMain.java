package com.java.lms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LeaveMain {
	
	static LeaveBAL bal = new LeaveBAL();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. Add Leave");
			System.out.println("2. Show Leave");
			System.out.println("3. Search Leave");
			System.out.println("Enter Your Choice   ");
			choice=sc.nextInt();
			switch(choice) {
			case 1 : 
				try {
					addLeave();
				} catch (ParseException | LeaveException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2 : 
				showLeave();
				break;
			case 3 : 
				searchLeave();
				break;
			}
		} while(choice!=6);
	}

	public static void searchLeave() {
		int leaveId;
		System.out.println("Enter Leave Id  ");
		leaveId = sc.nextInt();
		Leave leave = bal.searchLeaveBal(leaveId);
		if (leave!=null) {
			System.out.println(leave);
		} else {
			System.out.println("*** Record Not Found ***");
		}
	}
	public static void showLeave() {
		List<Leave> leaves = bal.showLeaveBal();
		for (Leave ld : leaves) {
			System.out.println(ld);
		}
	}
	public static void addLeave() throws ParseException, LeaveException {
		Leave leave = new Leave();
		System.out.println("Enter Employ Id  ");
		leave.setEmpId(sc.nextInt());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Enter LeaveStart Date (yyyy-MM-dd) ");
		leave.setLeaveStartDate(sdf.parse(sc.next()));
		System.out.println("Enter Leave EndDate (yyyy-MM-dd)   ");
		leave.setLeaveEndDate(sdf.parse(sc.next()));
		System.out.println("Enter LeaveType (EL/PL/ML)  ");
		String type=sc.next();
		if (type.equals("EL")) {
			leave.setLeaveType(LeaveType.EL);
		}
		if (type.equals("PL")) {
			leave.setLeaveType(LeaveType.PL);
		}
		if (type.equals("ML")) {
			leave.setLeaveType(LeaveType.ML);
		}
		System.out.println("Enter Leave Reason   ");
		leave.setLeaveReason(sc.next());
		System.out.println(bal.addLeaveBal(leave));
	}
}

