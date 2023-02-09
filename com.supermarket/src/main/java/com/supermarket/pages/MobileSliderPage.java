package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class MobileSliderPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	@FindBy(xpath="//i[@class='nav-icon fas fa-window-minimize']")
	WebElement mobileSlider;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newList;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement choose;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	
	
	public MobileSliderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	  
	public void click_OnMobileSlider()
	{
		 pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(mobileSlider);
		
	}
	public void createNewList(String imageName)
	{
		newList.click();
		choose.sendKeys(imageName);
		save.click();
		
	}
	public boolean is_AlertDisplayed()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.is_Displayed(alert);
	}

}
