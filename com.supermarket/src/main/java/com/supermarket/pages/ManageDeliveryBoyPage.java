package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	WebElement manageDeliveryBoy;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> deliveryBoyNames ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='name']")
	WebElement deliveryBoyName;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailId;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//button[@name='create']")
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert ;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[8]//a[2]")
	List<WebElement> deleteButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+i+\"]//td[8]//a[2]")
	WebElement deleteAUser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	WebElement nameField;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement downSearchButton;
	@FindBy(xpath="//span[@id='res']")
	WebElement resultMsg;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 
	public int print_NoOfDeliveryBoysPresent()
	{
		generalutilities = new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		pageutility.scrollAndClick(manageDeliveryBoy);
		List<String> names = new ArrayList<String>();
		
		 names=generalutilities.get_TextOfElements(deliveryBoyNames);
		System.out.println(names);
			return names.size();
		
	}
	public boolean create_NewDeliveryBoy(String name,String email,String phone,String user,String pass)
	{
		generalutilities = new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		pageutility.scrollAndClick(manageDeliveryBoy);
		newButton.click();
		deliveryBoyName.sendKeys(name);
		emailId.sendKeys(email);
		phoneNumber.sendKeys(phone);
		userName.sendKeys(user);
		password.sendKeys(pass);
		pageutility.scrollAndClick(save);
		
		waitutility.wait_ForElementToBeVisible(alert);
		
		return generalutilities.is_Displayed(alert);
	}
	public boolean delete_ADeliveryBoyAndSearch(String name)
	{
		generalutilities=new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		pageutility.scrollAndClick(manageDeliveryBoy);
		int i=0;
		List<String> deliveryBoyNames=new ArrayList<String>();
		
		deliveryBoyNames=generalutilities.get_TextOfElements(deleteButton);
		 for(i=0;i<deliveryBoyNames.size();i++)
		 {
			 if(name.equals(deliveryBoyNames.get(i)))
			 {
				 i++;
				 break;
			 }
		 }
		 pageutility.scrollAndClick(deleteAUser);
		 
		 pageutility.accept_Alert();
		 
		 searchButton.click();
			nameField.sendKeys(name);
			waitutility.wait_ForElementToBeClickable(downSearchButton);
			downSearchButton.click();
			waitutility.wait_ForElementToBeVisible(resultMsg);
			return generalutilities.is_Displayed(resultMsg);
		 
		 }
	
	

}
