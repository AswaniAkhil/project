package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class PushNotificationsPage {
	WebDriver driver;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotofication;
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	@FindBy(xpath = "//input[@id='description']")
	WebElement description ;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement send ;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert ;
	public PushNotificationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void click_OnPushNotification()
	{
		
		pushNotofication.click();
	}
	public boolean send_Information(String tit,String des)
	{
		generalutilities=new GeneralUtilities(driver);
		waitutility=new WaitUtility(driver);
		title.sendKeys(tit);
		description.sendKeys(des);
		send.click();
		waitutility.wait_ForElementToBeVisible("//div[@class='alert alert-success alert-dismissible']");
		return generalutilities.is_Displayed(alert);
	}
	

}
