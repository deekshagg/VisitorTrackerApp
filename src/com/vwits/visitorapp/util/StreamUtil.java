package com.vwits.visitorapp.util;

import java.util.List;
import java.util.function.Predicate;

import com.vwits.visitorapp.model.Visitor;

public class StreamUtil {

	public static List<Visitor> filterVisitor(List<Visitor> visitorBook, Predicate<Visitor> predicate) {
		return visitorBook.stream().filter(predicate).toList();
	}
	
	public static int findTotalVisitors(List<Visitor> visitorBook, Predicate<Visitor> predicate) {
		List<Visitor> list = visitorBook.stream().filter(predicate).toList();
		return list.size();
	}
}
