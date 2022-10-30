package com.vwits.visitorapp.model;

import java.util.Date;

public class Visitor {
	
	
	public Visitor(int id, String name, String emailId, Date visitDate, String purposeOfVisit, String whomToMeet) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.visitDate = visitDate;
		this.purposeOfVisit = purposeOfVisit;
		this.whomToMeet = whomToMeet;
	}

	//would contain an model class as Visitor(entity unique id, name,unique key emailid, visit date, 
	//purpose of visit , whom to meet)

	public Visitor() {
		
	}

	//------------------------------------------ Entities--------------------------------------------------------------------//
	private int id;
	private String name;
	private String emailId;
	private Date visitDate;
	private String purposeOfVisit;
	private String whomToMeet;


	//------------------------------------------ Getter/Setter--------------------------------------------------------------------//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

	public String getWhomToMeet() {
		return whomToMeet;
	}

	public void setWhomToMeet(String whomToMeet) {
		this.whomToMeet = whomToMeet;
	}

//------------------------------------------------toString()--------------------------------------------------------------//

	@Override
	public String toString() {
		return "\nVisitor -> [ ID = " + id +
				" Name = " + name +
				" Email ID = " + emailId + 
				" Visit Date = " + visitDate + 
				" Purpose Of Visit = " + purposeOfVisit +
				" Whom To Meet = " + whomToMeet + "]";
	}

}
