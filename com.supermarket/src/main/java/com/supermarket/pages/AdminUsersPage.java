package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath="(//a[@class='small-box-footer'])[2]")
	private WebElement adminUsersMoreInfo;
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	 public boolean update_UserDetails(String name,String u,String p)
	 {
		 int i;
		 adminUsersMoreInfo.click();
		 generalutilities=new GeneralUtilities(driver);
		 pageutility=new PageUtility(driver);
		 
 List<String>adminUsers=new ArrayList<String>();
		 
		 adminUsers=generalutilities.get_TextOfElements("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]");
		 for(i=0;i<adminUsers.size();i++)
		 {
			 if(name.equals(adminUsers.get(i)))
			 {
				 i++;
				 break;
			 }
		 }
		 WebElement editButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+i+"]//td[5]//a[2]"));
		 pageutility.scrollAndClick(editButton);
		 
		 userName.sendKeys(u);
		 password.sendKeys(p);
		 Select select=new Select(userType);
		 select.selectByIndex(3);
		 updateButton.click();
		 waitutility=new WaitUtility(driver);
		 waitutility.wait_ForElementToBeVisible("//div[@class='alert alert-success alert-dismissible']");
		 return generalutilities.is_Displayed(alert);
		 
		 
	 }
	

}
