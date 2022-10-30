package com.vwits.visitorapp.base;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vwits.visitorapp.dao.VisitorAppDao;
import com.vwits.visitorapp.dao.impl.VisitorAppJdbcDaoImpl;
import com.vwits.visitorapp.model.Visitor;
import com.vwits.visitorapp.util.AppUtil;

public class TestVisitorApp {
	
	public static int id;
	public static String name;
	public static String emailId;
	public static Date visitDate;
	public static String purpose;
	public static String whomToMeet;
	
	public static Scanner sc = new Scanner(System.in);
	public static Visitor visitor = new Visitor();
	public static VisitorAppDao daoImpl = new VisitorAppJdbcDaoImpl();
	public static List<Visitor> visitorBook = daoImpl.showAllVisitor();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int option = -1;
			
		do {	
			AppUtil.menu();
			option = Integer.parseInt(sc.nextLine());

			switch (option) {

			case 1:
				AppUtil.enterVisitorDetails();
				break;

			case 2:
				AppUtil.showAVisitor();
				break;

			case 3:
				AppUtil.updateVisitor();
				break;

			case 4:
				AppUtil.deleteVisitor();
				break;
				
			case 5:
				AppUtil.showAllMeetings();
				break;
				
			case 6:
				AppUtil.filterWhomToMeet();
				break;
				
			case 7:
				AppUtil.filterByDate();
				break;
			
			case 8:
				AppUtil.filterWhomToMeetAccToDate();
				break;
				
			case 9:
				AppUtil.findTotalVisitors();
				break;
			}

		} while (option != -1);

		sc.close();
	}

}
