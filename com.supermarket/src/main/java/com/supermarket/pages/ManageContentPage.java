package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageContentPage {
	WebDriver driver;
	PageUtility pageutility;
	
	GeneralUtilities generalutilities;
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[5]")
	WebElement managePages;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newContent;
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement description ;
	@FindBy(xpath="//input[@id='page']")
	WebElement page;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement choose;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	
	
	public ManageContentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void click_OnManageContent()
	{
		manageContent.click();
		managePages.click();
	}
	public boolean create_NewContent(String Title,String des,String imageName)
	{
		generalutilities=new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		newContent.click();
		title.sendKeys(Title);
		page.sendKeys(des);
		pageutility.upload_File(choose, imageName);
		pageutility.scrollAndClick(save);
		return generalutilities.is_Displayed(alert);
	}
	

}
