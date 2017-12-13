package com.web.automation.pages;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.google.common.base.Optional;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.objectrepository.HN_OR;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.xml.transform.TransformerException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.fileutils.XMLUtils;
import com.web.automation.pages.HN_Pages;
import com.web.automation.utilities.CommonVariables;
import com.web.automation.utilities.RandomTextUtils;


public class HN_Pages extends BasePage {

	public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("25"));
	public String emailId;
	public String password;
	
	//Payment Details
		public String PaymentMethod;
		public String PaymentTerm;
		public String Name;
		public String cardNo;
		public String ExpMonth;
		public String ExpYear;
		public String cvv;
		
		
		// Candidate Details
		public String PostCode;
		public String FirstName;
		public String LastName;
		public String EmailId;
		public String PhoneNumber;
		public String ErrorMsg;
		
	
	public HN_Pages(WebDriver driver) {
		super(driver);
	}

	public void HN_Function1() throws Throwable {
		try {
			extentLogs.info("HN Portal ", "HN Portal - Launched");
			
			if (actionLib.IsElementVisible(HN_OR.CompsAndTabs)) {
				
				//Select Product Category
				actionLib.Click(HN_OR.CompsAndTabs, "Comps and Tabs");				
				actionLib.Click(HN_OR.MacTab, "Macs");				
				actionLib.waitForElementPresent(HN_OR.AddtItemToCart, 60);
				
				//Add item to cart and view cart
				actionLib.Click(HN_OR.AddtItemToCart,"AddItemToCart");
				//actionLib.Click(HN_OR.AddCart,"AddCart");	
				actionLib.JSClick(HN_OR.AddCart);
				actionLib.Click(HN_OR.Viewcart,"ViewCart");				
				actionLib.waitForElementPresent(HN_OR.ShoppingCart,60);
				
				//Select pickup store and checkout
				//actionLib.Click(HN_OR.PickInStore, "PickInStore");
				actionLib.JSClick(HN_OR.PickInStore);
				actionLib.type(HN_OR.EnterPostalCode, PostCode, "PostCode");				
				actionLib.Click(HN_OR.FindStore, "FindStore");				
				actionLib.waitForElementPresent(HN_OR.SelectStore, 60);				
				actionLib.Click(HN_OR.SelectStore, "SelectStore");				
				//actionLib.Click(HN_OR.ContinueToChkOut, "ContinueToCheckOut");
				actionLib.JSClick(HN_OR.ContinueToChkOut);
				actionLib.waitForElementPresent(HN_OR.ReveiwYourOrder,60);
				
				//Enter invoice details
				actionLib.type(HN_OR.FirstName, FirstName, "FirstName");				
				actionLib.type(HN_OR.LastName, LastName, "LastName");
				actionLib.type(HN_OR.PhoneNum, PhoneNumber, "PhoneNumber");
				actionLib.type(HN_OR.Email, EmailId, "Emailid");
				
				//Accept T&C				
				actionLib.Click(HN_OR.Checkbox,"CheckBox");
				
				//Select payment method
				actionLib.selectByVisibleText(HN_OR.PaymentMethod, PaymentMethod, "PaymentMethod");
				Thread.sleep(10000);
				
				//Enter payment/card details
				actionLib.switchToFrameByIdOrName("gebuy_account_form");				
				Thread.sleep(3000);
				actionLib.selectByVisibleText(HN_OR.PaymentTerm, PaymentTerm ,"PaymentTerm");				
				actionLib.type(HN_OR.CardNumber, cardNo, "CardNumber");				
				actionLib.type(HN_OR.CvvNumber, cvv, "Cvv");				
				actionLib.type(HN_OR.Name, Name, "NameOnCard");				
				actionLib.selectByVisibleText(HN_OR.Month, ExpMonth, "ExpMonth");				
				actionLib.selectByVisibleText(HN_OR.Year, ExpYear, "ExpYear");	
				
				//Place order and validate error message
				actionLib.Click(HN_OR.PlaceOrder,"PlaceOrder");				
				Thread.sleep(9000);				
				if(actionLib.isElementDisplayed(HN_OR.ErrorMessage)){					
					extentLogs.pass("Place Order Error", "Order failed message successful displayed");
					return;
				}else{
						extentLogs.fail("Place Order Error", "Order failed messagen not displayed");
						return;
					}	
				
			} else {
				extentLogs.fail("HN Home Page", "HN Home Page is not displayed");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void PostInQAComplete(String strStatus) throws Throwable {
		
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
		patchReq.addHeader("Content-Type", "application/json");
		patchReq.addHeader("Authorization", "Basic c3lhbWt1bWFyLmJtQGNpZ25pdGkuY29tOkNpZ25pdGkxMjM=");
		
		//JSON
		JSONObject jj = new JSONObject();
		if (strStatus == "Passed")
		{
			jj.put("StatusCode","Passed");
		}else
		{
			jj.put("StatusCode","Failed");
		}
									
		StringEntity entityForPost1 = new StringEntity(jj.toString());				
		patchReq.setEntity(entityForPost1);
		
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
		
	}

	public void PostInQTest(String strStatus) throws Throwable {
		
		DefaultHttpClient httpClient3 = new DefaultHttpClient();
		HttpPost postReq = new HttpPost(
				"https://venugopalkadiri.qtestnet.com/api/v3/projects/64875/test-runs/29562565/test-logs");
		postReq.addHeader("accept", "application/json");
		postReq.addHeader("Content-Type", "application/json");
		postReq.addHeader("Authorization", "dmVudWdvcGFsa2FkaXJpfHZlbnVnb3BhbC5rYWRpcmlAY2lnbml0aS5jb206MTU0NDYyNjgxNTEyNjplNThkNDYzZmFiMzI3ZTRhOGNiZTkzOGU5YTExMDAwNQ=");
		
		
		//using JSON object to send body data
		String s1;
		if (strStatus == "Passed")
		{
			s1 = "601";	
		}else
		{
			s1 = "602";	
		}
					
		JSONObject jj = new JSONObject();
		jj.put("exe_start_date","2017-12-12T10:40:50+00:00");
		jj.put("exe_end_date","2017-12-12T10:40:50+00:00");
		jj.put("test_case_version_id","19960954");
		jj.put("status",Integer.parseInt(s1.trim()));				
		StringEntity entityForPost = new StringEntity(jj.toString());				
		postReq.setEntity(entityForPost);
		
		HttpResponse response3 = httpClient3.execute(postReq);
					
		if (response3.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response3.getStatusLine().getStatusCode());
		}				
		
		httpClient3.getConnectionManager().shutdown();
	}
	
	
	
	
	public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName){
		this.LastName = LastName;
	}
	
	public void setEmailId(String EmailId){
		this.EmailId = EmailId;
	}
	
	public void setCardName(String CardName) {
		this.Name = CardName;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setExpMonth(String ExpMonth) {
		this.ExpMonth = ExpMonth;
	}

	public void setExpYear(String expYear) {
		this.ExpYear = expYear;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setPostCode(String PostCode) {
		this.PostCode = PostCode;
	}

	public void setPrimaryPhno(String PrimaryPhno) {
		this.PhoneNumber = PrimaryPhno;
		
	}

	public void setPaymentMethod(String PaymentMethod) {
		
		this.PaymentMethod = PaymentMethod;
	}

	public void setPaymentTerm(String PaymentTerm) {
		this.PaymentTerm = PaymentTerm;
	}

		
	}
	
	
		
	

