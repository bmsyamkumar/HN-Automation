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
import com.web.automation.utilities.CommonVariables;
import com.web.automation.utilities.RandomTextUtils;

/*
 * Test Title:
 * Auto Assignment Case #1: Test Lead Submission and auto assignment to the broker - Lead pHNtcode same as Broker pHNtcode
 *  
 * Pre-condition: Broker is not on leave 
 * 
 * 
 */

public class HN_Script extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private HN_Pages HN = null;
	
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
		
		HN = new HN_Pages(CommonVariables.CommonDriver.get());
		
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
	
	
	@Test(description = "purchase order online", groups = { "smoke", "regression" })
	public void HN_Script_Execution() throws Throwable {
		try {
				
				HN.HN_Function1();
				
				//POST
				 DefaultHttpClient httpClient1 = new DefaultHttpClient();
				HttpPost postReq = new HttpPost(
						"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns");
				postReq.addHeader("accept", "application/json");
				postReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("TestId", "5120088"));
				postReq.setEntity(new UrlEncodedFormEntity(pairs ));			
				HttpResponse response1 = httpClient1.execute(postReq);
							
				if (response1.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response1.getStatusLine().getStatusCode());
				}

				BufferedReader br1 = new BufferedReader(
		                         new InputStreamReader((response1.getEntity().getContent())));

				String output1;
				StringBuilder stringBuilder1 = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output1 = br1.readLine()) != null) {
					System.out.println(output1);
					stringBuilder1.append(output1);
				}
				
				String result1 = stringBuilder1.toString();
				
				
				JSONParser parse1 = new JSONParser();
				JSONObject jobj1 = (JSONObject)parse1.parse(result1);
				//JSONArray jarray1 = (JSONArray)jobj1.get("id");
				
				//JSONObject jobj1_1 = (JSONObject)jarray1.get(0);
				Long TestId1 = (Long) jobj1.get("id");
				
				
				System.out.println(TestId1);
				
				
				httpClient1.getConnectionManager().shutdown();
				
				 
				//GET
				DefaultHttpClient httpClient2 = new DefaultHttpClient();
				
				HttpGet getRequest = new HttpGet(
				"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/" + TestId1 + "/items");
				getRequest.addHeader("accept", "application/json");
				getRequest.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				HttpResponse response2 = httpClient2.execute(getRequest);
				
				if (response2.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response2.getStatusLine().getStatusCode());
				}

				BufferedReader br2 = new BufferedReader(
		                         new InputStreamReader((response2.getEntity().getContent())));

				String output2;
				StringBuilder stringBuilder2 = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output2 = br2.readLine()) != null) {
					System.out.println(output2);
					stringBuilder2.append(output2);
				}
				String result2 = stringBuilder2.toString();
				
				
				
					
				JSONParser parse = new JSONParser();
				JSONObject jobj = (JSONObject)parse.parse(result2);
				JSONArray jarray = (JSONArray)jobj.get("results");
				
				JSONObject jobj_1 = (JSONObject)jarray.get(0);
				Long TestId2 = (Long) jobj_1.get("id");
				
				
				System.out.println(TestId2);
				System.out.println(TestId2);
				httpClient2.getConnectionManager().shutdown();
				
				//PATCH
				DefaultHttpClient httpClient3 = new DefaultHttpClient();
				HttpPatch patchReq = new HttpPatch(
						"https://app.qacomplete.smartbear.com/rest-api/service/api/v2/projects/106798/testruns/"+TestId1+"/items/"+TestId2);
				patchReq.addHeader("accept", "application/json");
				patchReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
				
				List<NameValuePair> pairs1 = new ArrayList<NameValuePair>();
				pairs1.add(new BasicNameValuePair("StatusCode", "Failed"));
				
				List<NameValuePair> pairs2 = new ArrayList<NameValuePair>();
				pairs2.add(new BasicNameValuePair("StepName", "step1"));
				pairs2.add(new BasicNameValuePair("StatusCode", "Failed"));
				
				patchReq.setEntity(new UrlEncodedFormEntity(pairs1));
				patchReq.setEntity(new UrlEncodedFormEntity(pairs2));
				HttpResponse response3 = httpClient3.execute(patchReq);
				
				
				
				if (response3.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response3.getStatusLine().getStatusCode());
				}

				BufferedReader br3 = new BufferedReader(
		                         new InputStreamReader((response3.getEntity().getContent())));
				
				String output3;
				StringBuilder stringBuilder3 = new StringBuilder();
				System.out.println("Output from Server .... \n");
				while ((output3 = br3.readLine()) != null) {
					System.out.println(output3);
					stringBuilder3.append(output3);
				}
				String result3 = stringBuilder3.toString();
				
				httpClient3.getConnectionManager().shutdown();
				
				
				
		}catch (Exception e) {
			testCaseFailureReason = "Failed to Auto Assign Lead to Broker ";
			String stackTrace = extenLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extenLogs.fail("AutoAssignmentCase1 - Test Lead Submission and auto assignment to the broker", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	}

	
	
	
}