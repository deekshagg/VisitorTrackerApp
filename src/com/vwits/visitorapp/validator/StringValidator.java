package com.vwits.visitorapp.validator;

import java.util.Scanner;

public class StringValidator {
	public static String getString(Scanner scn) {
		String str = scn.nextLine();
		if(str == "" || str == null) 
			return null;
		return str;
	}
}
