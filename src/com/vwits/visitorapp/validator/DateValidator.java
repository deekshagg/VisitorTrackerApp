package com.vwits.visitorapp.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateValidator {

	public static Date getDate(Scanner scn) {
		String date = scn.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date visitDate = null;
		try {
			visitDate = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return visitDate;
	}
}
