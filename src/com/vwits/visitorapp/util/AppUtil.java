package com.vwits.visitorapp.util;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.vwits.visitorapp.base.TestVisitorApp;
import com.vwits.visitorapp.model.Visitor;
import com.vwits.visitorapp.validator.DateValidator;
import com.vwits.visitorapp.validator.IntValidator;
import com.vwits.visitorapp.validator.StringValidator;

public class AppUtil extends TestVisitorApp{
	
	public static void menu() {
		System.out.println("\nWelcome to VWITS Visitor Application App!\n");
		System.out.println("1. Enter Visitor Details");
		System.out.println("2. Show Details");
		System.out.println("3. Update Purpose of Meet");
		System.out.println("4. Delete visitor");
		System.out.println("5. Show All records");
		System.out.println("6. Filter By Whom to meet");
		System.out.println("7. Filter By Date");
		System.out.println("8. Filter whom to meet on a specific date");
		System.out.println("9. Find Total Visitors");
		System.out.println("-1. Exit");
	}

	public static void enterVisitorDetails() {
		System.out.println("Enter id: ");
		id = IntValidator.getInt(sc);
		visitor.setId(id);

		System.out.println("Enter Name: ");
		name = StringValidator.getString(sc);
		visitor.setName(name);

		System.out.println("Enter Email id: ");
		emailId = StringValidator.getString(sc);
		visitor.setEmailId(emailId);
		
		System.out.println("Enter Visit Date: ");
		visitDate = DateValidator.getDate(sc);
		visitor.setVisitDate(visitDate);

		System.out.println("Enter Purpose of Visit: ");
		purpose = StringValidator.getString(sc);
		visitor.setPurposeOfVisit(purpose);

		System.out.println("Enter Whom to Meet: ");
		whomToMeet = StringValidator.getString(sc);
		visitor.setWhomToMeet(whomToMeet);

		daoImpl.addVisitor(visitor);
	}
	
	public static void showAVisitor() {
		System.out.println("Enter id: ");
		id = IntValidator.getInt(sc);
		visitor.setId(id);
		System.out.println(daoImpl.showVisitor(id));
	}
	
	public static void updateVisitor() {
		System.out.println("Enter Visitor id");
		id = IntValidator.getInt(sc);
		System.out.println("Enter Updated Purpose of Meet");
		purpose = sc.nextLine();
		daoImpl.updatePurposeOfMeet(id, purpose);
	}
	
	public static void deleteVisitor() {
		System.out.println("Enter id: ");
		id = IntValidator.getInt(sc);
		daoImpl.deleteVisitor(id);
	}
	
	public static void showAllMeetings() {
		System.out.println(visitorBook);
	}
	
	public static void filterWhomToMeet() {
		System.out.println("Enter Whom to Meet");
		String str = StringValidator.getString(sc);
		System.out.println(StreamUtil.filterVisitor(visitorBook, p -> p.getWhomToMeet().equals(str)));
	}
	
	public static void filterByDate() {
		System.out.println("Enter a date");
		Date date = DateValidator.getDate(sc);
		System.out.println(StreamUtil.filterVisitor(visitorBook, (a) -> 
		a.getVisitDate().compareTo(date) == 0 ? true : false));
	}
	
	public static void filterWhomToMeetAccToDate() {
		System.out.println("Enter date:");
		Date date = DateValidator.getDate(sc);
		System.out.println("Enter whom to meet:");
		String string = StringValidator.getString(sc);
		List<Visitor> list = StreamUtil.filterVisitor(visitorBook, (a) -> 
			a.getVisitDate().compareTo(date) == 0 ? true : false);
		System.out.println(StreamUtil.filterVisitor(list, p -> p.getWhomToMeet().equals(string)));
	}
	
	public static void findTotalVisitors() {
		System.out.println("1. by purpose");
		System.out.println("2. by visit date");
		System.out.println("3. by whom to meet");
		int i = IntValidator.getInt(sc);
		switch(i) {
		case 1:
			System.out.println("Enter purpose");
			String purpose = StringValidator.getString(sc);
			Predicate<Visitor> f = a -> a.getPurposeOfVisit().equals(purpose);
			System.out.println(StreamUtil.findTotalVisitors(visitorBook, f));
			break;
		case 2:
			System.out.println("Enter Visit Date");
			String visitDate = StringValidator.getString(sc);
			Predicate<Visitor> f2 = a2 -> a2.getPurposeOfVisit().equals(visitDate);
			System.out.println(StreamUtil.findTotalVisitors(visitorBook, f2));
			break;
		case 3:
			System.out.println("Enter Whom to Meet");
			String whomToMeet = StringValidator.getString(sc);
			Predicate<Visitor> f3 = a3 -> a3.getPurposeOfVisit().equals(whomToMeet);
			System.out.println(StreamUtil.findTotalVisitors(visitorBook, f3));
			break;
		}
				
	}
}
