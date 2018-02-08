package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class HN_OR {

	//LOGINnn
	
	public static By CompsAndTabs = By.xpath("//*[@id='navMdList']/ul/li[3]/a");
	public static By MacTab = By.xpath("//*[@id='navMdContent']/div/div[1]/div[2]/ul[2]/li[1]/a");
	

	public static By PageHeading = By.xpath("//*[@class='page-heading']");

	//public static By AddtItemToCart = By.xpath("(//a[@class='name fn l_mgn-tb-sm l_dsp-blc'])[13]");
	public static By AddtItemToCart = By.xpath("(//a[@class='name fn l_mgn-tb-sm l_dsp-blc'])[14]");
			
	public static By AddCart = By.xpath("//*[@id='btn-add-to-cart']");

	public static By Viewcart = By.xpath("//*[@title='Proceed to Cart']");

	public static By ShoppingCart = By.xpath("(//*[contains(text(),'Shopping Cart')])[3]");

	public static By PickInStore = By.xpath("(//*[@class='shipmethod'])[1]");

	public static By EnterPostalCode = By.xpath("//*[@title='Enter postcode']");

	public static By FindStore = By.xpath("//*[@name='submit_postcode']");

	public static By SelectStore = By.xpath("(//*[@class='btn btn_block btn_primary'])[1]");

	public static By ContinueToChkOut = By.xpath("//*[contains(text(),'Continue to checkout')]");

	public static By ReveiwYourOrder = By.xpath("(//*[contains(text(),'Review your order')])[1]");

	public static By FirstName = By.id("billing:firstname");

	public static By LastName = By.id("billing:lastname");

	public static By PhoneNum = By.id("billing:telephone");

	public static By Email = By.id("billing:email");

	public static By Checkbox = By.xpath("(//*[@type='checkbox'])[2]");

	public static By PaymentMethod = By.xpath("//*[@class='form-control validate-select']");

	public static By PaymentTerm = By.xpath("//*[@id='promotion-code']");

	public static By ApplyNow = By.xpath("//*[@class='interest-free-lightbox-link modal-normal']");

	public static By CardNumber = By.name("card_accountNumber");

	public static By CvvNumber = By.name("card_cvNumber");

	public static By Name = By.xpath("//*[@title='Name on card']");

	public static By Month = By.xpath("//*[@id='geccpay_hosted_expiration']");

	public static By Year = By.xpath("//*[@id='geccpay_hosted_expiration_yr']");

	public static By PlaceOrder = By.xpath("//*[@name='place_order']");

	public static By ErrorMessage = By.xpath("//ul[@class='section error strong']/li");

	
	
}
