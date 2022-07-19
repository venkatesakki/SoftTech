package com.training.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateEx 
{
	//static LocalDate fromDate =LocalDate.parse();
	public static void main(String[] args) {
		
		DateFormat fromDate =SimpleDateFormat.getDateInstance(10/10/1996);
		System.out.println(fromDate);
		String dt=fromDate.toString();
		System.out.println(dt);
	}
}
