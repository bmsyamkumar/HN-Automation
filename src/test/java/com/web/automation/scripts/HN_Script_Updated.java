package com.web.automation.scripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.xml.transform.TransformerException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.fileutils.XMLUtils;
import com.web.automation.pages.HN_Pages;
import com.web.automation.pages.HN_Pages_Updated;
import com.web.automation.utilities.CommonVariables;
import com.web.automation.utilities.RandomTextUtils;

/*
 * Test Title:
 * Order Mac book through Harvey Norman 
 * 
 */

public class HN_Script_Updated extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private HN_Pages_Updated HN = null;
	
	protected String testDataPath = System.getProperty("user.dir").replace("\\", "/") + "/testdata/testdata.xml";
	private ExtentLogs extenLogs = new ExtentLogs();
	protected XMLUtils xmlTestData = null;
	Document doc;
	protected Properties config_prop = new Properties();
	
	
	/**
	 * @author Cigniti
	 * @param status
	 * @param reason
	 */
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}

	@BeforeMethod(alwaysRun = true, groups = { "smoke", "regression" })
	public void beforeMethod() throws IOException, TransformerException {
		
		xmlTestData = new XMLUtils();
		
		HN = new HN_Pages_Updated(CommonVariables.CommonDriver.get());
		
		
		try{
			FileReader reader;
			reader = new FileReader("config.properties");
			config_prop.load(reader);
		} catch (IOException e) {
			System.out.println("Failed to fetch/read 'config.properties' file.");
		}
		
		doc = xmlTestData.getDocObject(testDataPath);
		
		HN.setPostCode(xmlTestData.getData(doc,"//testdata/PostCode"));
		HN.setPrimaryPhno(xmlTestData.getData(doc,"//testdata/PhoneNumber"));
		HN.setPaymentMethod(xmlTestData.getData(doc, "//testdata/PaymentMethod"));
		HN.setPaymentTerm(xmlTestData.getData(doc, "//testdata/PaymentTerm"));
		HN.setCardNo(xmlTestData.getData(doc, "//testdata/CardNo"));
		HN.setCvv(xmlTestData.getData(doc, "//testdata/cvv" ));
		HN.setCardName(xmlTestData.getData(doc, "//testdata/CardName"));
		HN.setExpMonth(xmlTestData.getData(doc, "//testdata/ExpMonth"));
		HN.setExpYear(xmlTestData.getData(doc, "//testdata/ExpYear"));
		
		String FName = ActionsLibrary.generateRandomString(6, "ALPHA");
		String LName = ActionsLibrary.generateRandomString(6, "ALPHA");
		//String PrimaryPhno = ActionsLibrary.generateRandomString(10, "Number");
		String EmailID = FName + "." + LName + "@gmail.com";
		
		HN.setFirstName(FName);
		HN.setLastName(LName);
		HN.setEmailId(EmailID);
		//HN.setPrimaryPhno(PrimaryPhno);
		
		try{
			FileReader reader;
			reader = new FileReader("config.properties");
			config_prop.load(reader);
		} catch (IOException e) {
			System.out.println("Failed to fetch/read 'config.properties' file.");
		}
	}
	
	@Test(description = "purchase order online", groups = {"Demo"})
	public void HN_Script_Execution() throws Throwable {
		try {	
			
			
			
				//Order an item 
				HN.HN_OrderItem();
				
				//Post execution status to QA Complete
				HN.PostInQAComplete("Passed");
				
				//Post execution status to qTest Manager
				HN.PostInQTest("Passed");
								
		}catch (Exception e) {
			
			//Post execution status to QA Complete			
			HN.PostInQAComplete("Failed");
			
			//Post execution status to qTest Manager
			HN.PostInQTest("Failed");
			
			testCaseFailureReason = "Failed to execute Mac book order script ";
			String stackTrace = extenLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extenLogs.fail("Order Mac book ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}

	
	
	
}