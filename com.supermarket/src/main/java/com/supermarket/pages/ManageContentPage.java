package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;

public class ManageContentPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	public ManageContentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void click_OnManageContent()
	{
		manageContent.click();
	}

}
