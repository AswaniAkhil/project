package com.supermarket.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	@FindBy(xpath="//li//a//i[@class='nav-icon fas fa-user']")
	private WebElement manageUsers;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonManageUsers;
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement enterName;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchListUsers;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr[1]/td[1]")
	private WebElement searchResult;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement deactiveAlert;
	
	
	public ManageUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 public String manage_Users()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 manageUsers.click();
		 searchButtonManageUsers.click();
		 enterName.sendKeys("tester 003");
		 searchListUsers.click();
		return generalutilities.get_TextOfElement(searchResult) ;
		 
		 
	 }
	 public void clickOnManageUsers()
	 {
		 generalutilities=new GeneralUtilities(driver);
		 manageUsers.click(); 
	 }
	 public void deactivate_User(String usersName)
	 {
		 pageutility=new PageUtility(driver);
		 
		 int i=0;
		 generalutilities=new GeneralUtilities(driver);
		 manageUsers.click(); 
		 List<String>loggedUsersNames=new ArrayList<String>();
		 
		 loggedUsersNames=generalutilities.get_TextOfElements("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]");
		 for(i=0;i<loggedUsersNames.size();i++)
		 {
			 if(usersName.equals(loggedUsersNames.get(i)))
			 {
				 i++;
				 break;
			 }
		 }
		 WebElement statusChangeButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[5]/a"));
		 pageutility.scrollAndClick(statusChangeButton);
		 
		 
		
	 }
	 public boolean alert_IsDisplayed()
	 {
		 generalutilities=new GeneralUtilities(driver);
			return generalutilities.is_Displayed(deactiveAlert); 
	 }
	 
	
}
