package com.web.automation.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ChineseTest {
	public static void main(String[] args){

	  try {
		File fileDir = new File("testdata\\test.html");
			
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF-16"));
		/*
		out.append("Website UTF-8").append("\r\n");
		out.append("<h1> 选择贷款类别  </h1>").append("\r\n");
		out.append("选择贷款类别 UTF-8").append("\r\n");
		*/
		out.write("<h1> 选择贷款类别  </h1>");
		out.flush();
		out.close();
	        
	    } 
	   catch (UnsupportedEncodingException e) 
	   {
		System.out.println(e.getMessage());
	   } 
	   catch (IOException e) 
	   {
		System.out.println(e.getMessage());
	    }
	   catch (Exception e)
	   {
		System.out.println(e.getMessage());
	   } 
	}	
}