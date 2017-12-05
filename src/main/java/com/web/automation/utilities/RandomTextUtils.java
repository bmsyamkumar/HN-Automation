package com.web.automation.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomTextUtils {
	
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static String getRandomDateOfBirth() throws ParseException{
		String Dob = null;
		
		Dob = getRandomNumberInRange(1,28) + "/" 
				+ getRandomNumberInRange(1,12) + "/" 
				+ getRandomNumberInRange(1990,2010);
		
		return formatDate(Dob);
	}
	
	
	public static String formatDate(String dateFormat) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(dateFormat);
		String st = sdf.format(date);
		return st;
	}
	
	public static String getRandomMobileNo(){
		String mobile;
		mobile = getRandomNumberInRange(11111,99999) + "" + getRandomNumberInRange(11111,99999);
		return mobile;
	}
	
	public static String getRandomText(int length){
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public static String getRandomEmailId( ){
		String email;
		email = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(7) + "." + "com"; 
		return email;
	}
	
	public static void main(String[] args) throws ParseException, InterruptedException, IOException, SQLException {

		
		System.out.println("选择联系时间");
	 //String dd="ME Profile has been updated Successfully And Change Request (MCR00) for Insight ME";
	 //dd=dd.split("\\(")[1].split("\\)")[0].trim();
		
		//System.out.println(getValidAwbNumber());
	 //System.out.println(dd);
	 /*   
	 for (c = 1; c <= 3; c++) {
	    	dd = getRandomMobileNo();
	 	      System.out.println(dd);
	    }*/
	   

	}

}
