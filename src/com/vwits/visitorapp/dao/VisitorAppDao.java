package com.vwits.visitorapp.dao;

import java.util.List;

import com.vwits.visitorapp.model.Visitor;

public interface VisitorAppDao {

	public void addVisitor(Visitor visitor);
	public List<Visitor> showAllVisitor();
	public Visitor showVisitor(int id);
	public void updatePurposeOfMeet(int id, String purpose);
	public void deleteVisitor(int id);
}
