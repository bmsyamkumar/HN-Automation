package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class AdminPortal_OR {

	//LOGIN
	public static By emailTxt = By.id("email");
	public static By passwordTxt = By.id("password");
	public static By loginBtn = By.xpath("//button[@type='submit']");
	
	//LOGOUT
	public static By logoutMnu = By.xpath("//img[@class='profile-img']");
	public static By logoutLnk = By.xpath("//a[contains(@href,'log-out')]");
	
	//HOME PAGE
	public static By brokersMnu = By.xpath("//a/span[contains(text(),'Brokers')]");
	public static By newRequestLnk = By.xpath("//a[contains(text(),'New Requests')]");
	public static By verifiedBrokerLnk = By.xpath("//a[contains(text(),'Verified Brokers')]");
	
	public static By usersMnu = By.xpath("//a/span[contains(text(),'Users')]");
	public static By usersLnk = By.xpath("//a[contains(@href,'users')]");
	public static By dashboardMnu = By.xpath("//a/span[contains(text(),'Dashboard')]");
	public static By leadsMnu = By.xpath("//a/span[contains(text(),'Leads')]");
	public static By leadMgmtLnk = By.xpath("//a[contains(text(),'Lead Management')]");
	
	
	//BROKERS - NEW BROKERS REQUEST PAGE
	public static By nameFilterTxt = By.xpath("//input[@id='fullnameFilter']");
	
	//USERS
	public static By userSearchTxt = By.xpath("//input[@ng-model='userSearch']");
	
	//EDIT USER
	public static By roleSelect = By.xpath("//select[@ng-model='selectedRole']");
	public static By updateUserBtn = By.xpath("//input[@value='Update User']");
	public static By aboutMeTxt = By.xpath("//textarea[@name='about_me']");
	public static By mobileTxt = By.xpath("//input[@name='mobile']");
	
	public static By industryAssociationSelected = By.xpath("//label[contains(text(),'Industry Association')]/following-sibling::div//span");
	public static By industryQualificationSelected = By.xpath("//label[contains(text(),'Industry Qualification')]/following-sibling::div//span");
	public static By languageSelected = By.xpath("//label[contains(text(),'Languages')]/following-sibling::div//span");
	public static By withInSelected = By.xpath("//select[@name='broker_radius']/option[@selected='selected']");
	
	//LEAD MANAGEMENT
	public static By leadSearchTxt = By.xpath("//input[@name='clientSearchfield']");
	public static By leadSearchResultRow = By.xpath("//div[@id='NewLeads']");
	public static By assignedLeadSearchResultRow = By.xpath("//div[contains(@ng-repeat,'assignedlead')]");
	public static By leadDeleteBtn = By.xpath("//a[contains(@class,'delete_lead_btn')]");
	public static By leadsAssignedTab = By.xpath("//ul[@id='leadsTab']//a[contains(text(),'Assigned')]");
	public static By leadSearchByBrokerSelect = By.xpath("//select[@ng-model='brokerselected']");
	
	//LEAD DETAILS PAGE
	public static By assignLnk = By.xpath("//span[@class='lead_assignment']//a[contains(text(),'Assign')]");
	public static By brokerAssignmentSelect = By.xpath("//select[@name='broker_for_assignment']");
	public static By reAssignLnk = By.xpath("//span[@class='lead_assignment']//a[contains(text(),'Re-assign')]");
	public static By remarkLbl = By.xpath("//article[@id='remarkslist']//strong[contains(text(),'Posted by')]");
	public static By leadStatusAssigned = By.xpath("//span[contains(@class,'leadStatus') and contains(text(),'Assigned')]");
	public static By leadSearchResultsFirstRow = By.xpath("//div[@id='NewLeads']");
	public static By deleteLeadConfirmBtn = By.xpath("//button[@class='del_confirm']");
	public static By emptyLeadDetails = By.xpath("//p[@class='emptyLeadDetail']");
	
	//VERIFIED BROKER DETAILS PAGE
	public static By tier2_checked = By.xpath("//input[@name='tier_2' and @checked='checked']");
	public static By autoAssign_checked = By.xpath("//input[@name='autoAssign' and @checked='checked']");
	public static By autoAssign_unchecked = By.xpath("//input[@name='autoAssign']");
	public static By alwaysPremium_checked = By.xpath("//input[@name='key_premium' and @checked='checked']");
		
	
}
