package com.psm.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		System.out.println(date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //aplyala havya tya format mdhe karta yete
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
		String str = " ";
		System.out.println(str.length());
		
		String str1 = "ROLE_1";
		str1 = str1.substring(str1.indexOf('_')+1,str1.length());
		System.out.println(str1);
		
	}

}
