package com.vwits.visitorapp.validator;

import java.util.Scanner;

public class IntValidator {

	public static int getInt(Scanner scn) {
		int num = Integer.parseInt(scn.nextLine());
		if(num < 0) 
			return 0;
		return num;
	}
}
