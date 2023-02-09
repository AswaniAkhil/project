package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;

public class LoginPage
{
	WebDriver driver;
	GeneralUtilities generalutilities;
	Properties prop = new Properties();
	FileInputStream ip;
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
	private WebElement signInButton;
	@FindBy(xpath="//h5[text()=' Alert!']")
	private WebElement invalidmessage;
	@FindBy(xpath="//div[@class='login-logo']")
	private WebElement logo;
	@FindBy(xpath="//div[@class='icheck-dark']")
	private WebElement rememberme;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
	private WebElement signin;
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement admin;
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement adminDropDown;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logOut;
	@FindBy(xpath="//p[@class='login-box-msg']")
	private WebElement signInAlert;
	
	
	
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}
	 public void enterUserName(String userName)
	 {
		 userNameField.sendKeys(userName);
	 }
	 public void enterPassword(String password)
	 {
		 passwordField.sendKeys(password);
	 }
	 public void clickOnSignInButton()
	 {
		 signInButton.click();
	 }
	 public void login(String userName,String password)
	 {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	 public void login()
	 {
		 String username=prop.getProperty("username");
		 String password=prop.getProperty("password");
		 login(username,password);
	 }
	 public String get_ErrorMessage()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 
		 
		return generalutilities.get_TextOfElement(invalidmessage);
	 }
	 public boolean logoDisplayed()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 return generalutilities.is_Displayed(logo);
	 }
	 public String logoText()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 return generalutilities.get_TextOfElement(logo);
	 }
	 public boolean clickOnRememeberMe()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 rememberme.click();
		 return  generalutilities.is_Enabled(rememberme);
		 
	 }
	 public String get_TextOfSignInButton()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 return generalutilities.get_TextOfElement(signin);
	 }
	 public String profile_TextElement()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 return generalutilities.get_TextOfElement(admin);
		 
	 }
	 public List<String> get_CatagoriesOfDashboard()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 
		return generalutilities.get_TextOfElements("//div[@class='inner']//p");
		
		 
	 }
	 public String is_UserLoggedOut()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 adminDropDown.click();
		 Actions action=new Actions(driver);
		 action.moveToElement(logOut).click().build().perform();
		 return generalutilities.get_TextOfElement(signInAlert);
	 }
	
	 
}
