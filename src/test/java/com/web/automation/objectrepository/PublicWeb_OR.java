package com.web.automation.objectrepository;

import org.openqa.selenium.By;

public class PublicWeb_OR {

	//LANDING PAGE
	public static By brokerMnu = By.xpath("//a[@title='Broker']");
	public static By brokerSignUpMnu = By.xpath("//a[@title='Broker Signup']");
	public static By loginLnk = By.xpath("//a[contains(text(),'login')]");
	public static By loanDealsMnu = By.xpath("//a[@title='Loan Deals']");
	public static By getMeThisDealBtn = By.xpath("//a[contains(text(),'GET ME THIS DEAL')]");
	public static By brokerFinderLnk = By.xpath("//a[@title='Broker Finder']");
	public static By findOutMoreBtn = By.xpath("//a[@title='Find Out More']");
	public static By myAccountMnu = By.xpath("//a[@title='Blog']/../following-sibling::li/a");
	
	
	//BROKER SIGNUP
	public static By brokerRegForm = By.id("BrokerRegister");
	public static By fnameTxt = By.xpath("//input[@name='firstName']");
	public static By lnameTxt = By.xpath("//input[@name='lastName']");
	public static By businessNameTxt = By.xpath("//input[@name='business_name']");
	public static By businessAbnTxt = By.xpath("//input[@name='abn']");
	public static By industryAssocSelect = By.xpath("//div[contains(@class,'industry_association multiSelectCustom')]");
	public static By indusAssoFbaaOpt = By.xpath("//input[@value='FBAA']");
	public static By industryQualificationSelect = By.xpath("//div[contains(@class,'industry_qualification multiSelectCustom')]");
	public static By indusQualCertiOpt = By.xpath("//input[@value='Certificate IV in Mortgage Broking']");
	public static By aclCrnTypeBtn = By.xpath("//div[@class='aclCrnField']//button");
	public static By aclCrnTypeAclOpt = By.xpath("//div[@class='aclCrnField']//a[contains(text(),'ACL')]");
	public static By aclCrnTypeCrnOpt = By.xpath("//div[@class='aclCrnField']//a[contains(text(),'CRN')]");
	public static By aclCrnTxt = By.xpath("//input[@name='afsl_acl']");
	public static By aclTxtError = By.xpath("//div[@class='aclCrnField']/following-sibling::label[contains(text(),'Please enter a valid')]");
	public static By aggregatorSelect = By.id("aggregator");
	public static By servicingAreaTxt = By.xpath("//input[@name='broker_postcode']");
	public static By servicingAreaError = By.xpath("//input[@name='broker_postcode']/following-sibling::label[contains(text(),'Please enter a valid')]");
	public static By servicingAreaWithinSelect = By.xpath("//select[@name='broker_radius']");
	public static By servicingAreaWithin5Km = By.xpath("//option[contains(text(),'5 km')]");
	public static By officeAddressTxt = By.xpath("//textarea[contains(@name,'address')]");
	public static By suburbTxt = By.xpath("//input[@name='suburb']");
	public static By suburbTxtError = By.xpath("//div[contains(text(),'Please enter a valid Suburb')]");
	public static By suburbOpt = By.xpath("//div[contains(@class,'suburb-container')]//a");
	public static By stateSelect = By.xpath("//select[contains(@name,'state')]");
	public static By defaultState = By.xpath("//option[contains(text(),'New South Wales')]");
	public static By weekendAvailYes = By.xpath("//input[@value='Yes']");
	public static By weekendAvailNo = By.xpath("//input[@value='No']");
	
	//PROFILE PIC UPLOAD
	public static By chooseProfilePicLnk = By.xpath("//img[@class='file-preview-image']");
	public static By chooseFileInput = By.xpath("//input[@id='avatarInput']");
	public static By profilePicSubmitBtn = By.xpath("//button[contains(text(),'Done')]");
	
	public static By totalExpTxt = By.xpath("//input[contains(@name,'exp')]");
	public static By totalExpError = By.xpath("//input[@name='expr']/following-sibling::label[contains(text(),'Please enter a valid')]");
	public static By chooseLangSelect = By.xpath("//div[contains(@class,'languages')]/button");
	public static By langSearchTxt = By.xpath("//div[contains(@class,'languages')]//input");
	public static By langSelectEnglishOpt = By.xpath("//input[@value='English']");
	public static By businessEmailTxt = By.xpath("//input[@name='email']");
	public static By mobileTxt = By.xpath("//input[@name='mobile']");
	public static By passwordTxt = By.xpath("//input[@name='password']");
	public static By confirmPasswordTxt = By.xpath("//input[@name='password_confirmation']");
	public static By confirmPasswordError = By.xpath("//input[@id='password_confirm']/following-sibling::label[contains(text(),'This field is required')]");
	public static By promoCodeTxt = By.xpath("//input[@name='promo_code']");
	public static By captchaChkbox = By.xpath("//div[contains(@class,'recaptcha-checkbox')]");
	//SUBMIT
	public static By brokerRegSubmitBtn = By.id("broker-register-submit");
	public static By brokerRegSuccessMsg = By.xpath("//em[contains(text(),'You Account has been successfully created')]");
	
	//LOGIN
	public static By loginEmailTxt = By.id("email");
	public static By loginPasswordTxt = By.id("password");
	public static By loginBtn = By.xpath("//button[@type='submit']");
	
	//SUBSCRIBER PROFILE PAGE
	public static By updateProfileFnameTxt = By.xpath("//label[contains(text(),'First Name')]");
	//public static By updateProfileFnameTxt = By.xpath("//span[contains(text(),'Welcome back, testusercigniti!')]");
	
	public static By subscriber_brokerSignupSuccessMsg = By.xpath("//h3[contains(text(),'Thank you for submitting your verified broker request to HashChing')]");
	
	//PROFILE PAGE
	public static By stateSelectedOpt = By.xpath("//select[@name='state']/option[@selected='selected']");
	public static By profilePicImg = By.xpath("//div[@ng-model='BrokerProfile']//img[contains(@src,'.png')]");
	public static By servicingAreaWithinSelected = By.xpath("//select[@name='broker_radius']//option[@selected='selected']");
	public static By indusAssoSelected = By.xpath("//div[contains(@class,'industry_association')]/button/span");
	public static By indusQualificationSelected = By.xpath("//div[contains(@class,'industry_qualification')]/button/span");
	public static By aboutMeTxt = By.xpath("//textarea[@name='about_me']");
	public static By languagesSelected = By.xpath("//div[contains(@class,'languages')]/button/span");
	public static By weekendAvailabilityYesChecked = By.xpath("//input[@checked='checked' and @value='Yes']");
	public static By weekendAvailabilityNoChecked = By.xpath("//input[@checked='checked' and @value='No']");
	public static By updateProfileBtn = By.xpath("//button[contains(text(),'Update Profile')]");
	public static By officeAddressErr = By.xpath("//textarea[@name='address']/following-sibling::label[contains(text(),'This field is required')]");
	public static By totalExpBlankErr = By.xpath("//input[@name='experience']/following-sibling::label[contains(text(),'This field is required')]");
	public static By languageSelect = By.xpath("//div[contains(@class,'languages')]/button");
	public static By languageInputTxt = By.xpath("//div[contains(@class,'languages')]//input");
	
	//LEAD FORM
	public static By leadFnameTxt = By.xpath("//input[@name='first_name']");
	public static By leadLnameTxt = By.xpath("//input[@name='last_name']");
	public static By leadPostcodeTxt = By.xpath("//input[@name='postcode']");
	public static By leadEmailTxt = By.xpath("//form[@id='deal_lead_form']//input[@name='email']");
	public static By leadMobileTxt = By.xpath("//input[@name='mobile']");
	public static By leadSendCodeBtn = By.xpath("//button[contains(text(),'Send Code')]");
	public static By leadVerifyCodeTxt = By.xpath("//input[@name='mobileVerify']");
	public static By leadVerifyBtn = By.xpath("//button[contains(@class,'verify-mobile')]");
	public static By leadSubmitGetDealBtn = By.xpath("//input[@value='GET ME THIS DEAL']");
	public static By leadLoanTypeSelect = By.xpath("//select[@name='loan_type']");
	public static By leadLoanAmtTxt = By.xpath("//input[@name='loan_amount']");
	public static By leadContactDayTxt = By.xpath("//input[@name='contact_day']");
	public static By leadCurrentDayTxt = By.xpath("//td/a[contains(@class,'state-highlight') or contains(@href,'#')]");
	public static By leadNextMonthBtn = By.xpath("//a[contains(@class,'ui-datepicker-next')]/span");
	public static By leadContactTimeSelect = By.xpath("//select[@name='contact_time']");
	public static By leadCurrLenderSelect = By.xpath("//select[@name='current_lender']");
	public static By leadCommentTxt = By.xpath("//textarea[@name='comment']");
	public static By leadPromoCodeTxt = By.xpath("//input[@name='promo_code']");
	public static By leadSubmitSuccessMsg = By.xpath("//h2[contains(text(),'Thank you for submitting your details')]");
	public static By leadIagreeBtn = By.xpath("//span[@class='checkmark checkmark_contact']");
	
	//BROKER FINDER
	public static By brokerFinderTitle = By.xpath("//h3[contains(text(),'Mortgage Broker Finder')]");
	public static By contactMeBtn = By.xpath("//a[contains(@class,'contact_me_broker')]");
	public static By leadContactMeBtn = By.xpath("//input[@value='CONTACT ME']");
	public static By brokerLeaveStatus = By.xpath("//div[contains(@class,'leave_statu_profile')]");
	
	//FIND OUT MORE
	public static By leadFindOutMoreBtn = By.xpath("//input[@value='FIND OUT MORE']");
	
	//FREE HOME LOAN ENQUIRY PAGE
	public static By iWantSaveMoneyBtn = By.xpath("//input[contains(@value,'I WANT TO SAVE MONEY')]");

	//TEASER LEAD FORM
	public static By teaserIWantSaveMoneyBtn = By.xpath("//input[contains(@value,'I want to save money')]");
	public static By teaserEmailTxt = By.xpath("//input[@name='email']");
	
	//CHINESE LEAD SUBMISSION FORM
	public static By chienseGetThisDealBtn = By.xpath("//input[contains(@class,'get-me-deal-btn')]");
	public static By chineseLeadSubmitSuccessMsg = By.xpath("//h2[contains(text(),'感谢您提交的详细资料')]");
	
	//BROKER DASHBOARD
	public static By logoutDropdownMnu = By.xpath("//a[@class='dropdown-toggle']");
	public static By logoutLnk = By.xpath("//a[contains(@href,'log-out')]");
	public static By enterMyLeaveLnk = By.xpath("//div[contains(@ng-if,'leave.status')]//a");
	public static By removeLeaveLnk = By.xpath("//a[contains(@class,'remove-leave')]");
	public static By leaveStatusOnLeave = By.xpath("//span[contains(@class,'leave_content') and contains(text(),'On leave')]");
	public static By leaveStartDate = By.xpath("//input[@name='start_date']");
	public static By leaveEndDate = By.xpath("//input[@name='end_date']");
	public static By leaveMessageTxt = By.xpath("//form[@id='ApplyLeave']//div[contains(@class,'broker-leave-msg')/textarea]");
	public static By leaveSubmitBtn = By.xpath("//input[@name='submit_leave']");
	public static By profileLnk = By.xpath("//a[contains(@href,'your-profile')]");
	
}