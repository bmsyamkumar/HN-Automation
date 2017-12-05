package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class Gmail_OR {

	public static By emailTxt = By.xpath("//input[@id='identifierId']");
	public static By nextBtn = By.id("identifierNext");
	public static By passwordTxt = By.xpath("//input[@type='password']");
	public static By pwdNextBtn = By.id("passwordNext");
	public static By searchTxt = By.xpath("//input[@aria-label='Search']");
	public static By searchBtn = By.xpath("//button[@aria-label='Search Gmail']");
	
}
