package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManagePaymentMethodsPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtilities generalutilities;
	WaitUtility waitutility;
	Properties prop = new Properties();
	FileInputStream ip;
	@FindBy(xpath="//i[@class='nav-icon fas fa-credit-card']")
	private WebElement managePaymentMethod ;
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	private WebElement editButton ;
	@FindBy(xpath="//input[@id='name']")
	private WebElement title;
	@FindBy(xpath="//input[@id='limit']")
	private WebElement paymentLimit;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateAlert;
	
	public ManagePaymentMethodsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public boolean update_PaymentMethodInformation(String cardTitle,String limit)
	{
		generalutilities=new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		pageutility.scrollAndClick(managePaymentMethod);
		editButton.click();
		title.sendKeys(cardTitle);
		paymentLimit.sendKeys(limit);
		updateButton.click();
		waitutility.wait_ForElementToBeVisible(updateAlert);
		return generalutilities.is_Displayed(updateAlert);
	}

}
