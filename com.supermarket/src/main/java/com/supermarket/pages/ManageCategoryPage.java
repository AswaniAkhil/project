package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageCategoryPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath="//i[@class='nav-icon fas fa-list-alt']")
	WebElement manageCategory ;
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]")
	WebElement  categoryMoreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="(//label[@class='radio-inline']//following-sibling::input[@value='no'])[1]")
	WebElement topMenuNoButton ;
	
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public boolean enable_NoButton()
	{
		manageCategory.click();
		generalutilities=new GeneralUtilities(driver);
		
	
		categoryMoreInfo.click();
		
		newButton.click();
		topMenuNoButton.click();
		return generalutilities.is_Enabled(topMenuNoButton);
		
	}
	

}
