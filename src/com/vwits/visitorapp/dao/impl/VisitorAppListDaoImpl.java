package com.vwits.visitorapp.dao.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vwits.visitorapp.model.Visitor;
public class VisitorAppListDaoImpl {
	
	List<Visitor> visitorBook = new ArrayList<Visitor>();
	Iterator<Visitor> i;
	
//	-------------------------------------------------------C - Create--------------------------------------------------------// 
	public void addVisitor(Visitor visitor) {
		visitorBook.add(visitor); 
		System.out.println("Visitor Added Successfully!");
	}
	
//	-------------------------------------------------------R - Read----------------------------------------------------------// 
	public List<Visitor> showAllVisitor() {
		return visitorBook;
	}
	
	public void showVisitor(int id) {
		i = visitorBook.iterator();
		while(i.hasNext()) {
			Visitor visitor = (Visitor) i.next();
			if(visitor.getId() == id) {
				System.out.println(visitor);
			}
		}
	}

//	-------------------------------------------------------U - Update--------------------------------------------------------// 
	public void updatePurposeOfMeet(int id, String purpose) {
		i = visitorBook.iterator();
		while(i.hasNext()) {
			Visitor visitor = (Visitor) i.next();
			if(visitor.getId() == id) {
				visitor.setPurposeOfVisit(purpose);
			}
		}
		System.out.println("purpose updated successfully.");
	
	}
	
//	-------------------------------------------------------R - Read----------------------------------------------------------//		
	public void deleteVisitor(int id) {
		i = visitorBook.iterator();
		while(i.hasNext()) {
			Visitor visitor = (Visitor) i.next();
			if(visitor.getId() == id) {
				i.remove();
			}
		}
		System.out.println("visitor deleted successfully.");
	}
	
}
