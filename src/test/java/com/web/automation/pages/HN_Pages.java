package com.web.automation.pages;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

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
			extentLogs.info("Admin Portal ", "Admin Portal - Login");
			if (actionLib.IsElementVisible(HN_OR.CompsAndTabs)) {
				
				actionLib.Click(HN_OR.CompsAndTabs, "Comps and Tabs");
				
				actionLib.Click(HN_OR.MacTab, "Macs");
				
				actionLib.waitForElementPresent(HN_OR.AddtItemToCart, 60);
				

				actionLib.Click(HN_OR.AddtItemToCart,"AddItemToCart");
				actionLib.Click(HN_OR.AddCart,"AddCart");
				
				actionLib.Click(HN_OR.Viewcart,"ViewCart");
				
				actionLib.waitForElementPresent(HN_OR.ShoppingCart,60);
				
				actionLib.Click(HN_OR.PickInStore, "PickInStore");
				
				actionLib.type(HN_OR.EnterPostalCode, PostCode, "PostCode");
				
				actionLib.Click(HN_OR.FindStore, "FindStore");
				
				actionLib.waitForElementPresent(HN_OR.SelectStore, 60);
				
				actionLib.Click(HN_OR.SelectStore, "SelectStore");
				
				actionLib.Click(HN_OR.ContinueToChkOut, "ContinueToCheckOut");
				
				actionLib.waitForElementPresent(HN_OR.ReveiwYourOrder,60);
				
				actionLib.type(HN_OR.FirstName, FirstName, "FirstName");
				
				actionLib.type(HN_OR.LastName, LastName, "LastName");
				
				actionLib.type(HN_OR.Email, EmailId, "Emailid");
				
				actionLib.type(HN_OR.PhoneNum, PhoneNumber, "PhoneNumber");
				
				actionLib.Click(HN_OR.Checkbox,"CheckBox");
				
				actionLib.selectByVisibleText(HN_OR.PaymentMethod, PaymentMethod, "PaymentMethod");
				
				Thread.sleep(10000);
				
				//WebElement e = driver.findElement(By.id("gebuy_account_form"));
				

				//List<WebElement> l = new List<WebElement> (driver.findElements(By.tagName("iframe")));
				
				
				actionLib.switchToFrameByIdOrName("gebuy_account_form");
				
				Thread.sleep(3000);
				
				//driver.switchTo().frame("gebuy_account_form");
				
				//actionLib.waitForElementPresent(HN_OR.PaymentTerm, 30);
				
				actionLib.selectByVisibleText(HN_OR.PaymentTerm, PaymentTerm ,"PaymentTerm");
				
				actionLib.type(HN_OR.CardNumber, cardNo, "CardNumber");
				
				actionLib.type(HN_OR.CvvNumber, cvv, "Cvv");
				
				actionLib.type(HN_OR.Name, Name, "NameOnCard");
				
				actionLib.selectByVisibleText(HN_OR.Month, ExpMonth, "ExpMonth");
				
				actionLib.selectByVisibleText(HN_OR.Year, ExpYear, "ExpYear");
				
				actionLib.Click(HN_OR.PlaceOrder,"PlaceOrder");
				
				Thread.sleep(5000);
				
				if(actionLib.isElementDisplayed(HN_OR.ErrorMessage)){
					
					extentLogs.pass("Place Order", "Order Failed successful");
					return;
				}else{
						extentLogs.fail("Place Order", "Order exit");
						return;
					}	
				
			} else {
				extentLogs.fail("Admin Portal - Login Page", "Admin Login Page is Not displayed");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void PostInQAComplete() throws Throwable {
		
		
		
		
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
	
	
		
	

