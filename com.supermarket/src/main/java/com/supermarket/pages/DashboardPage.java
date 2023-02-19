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

public class DashboardPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath="(//div[@class='container-fluid'])[2]")
	WebElement elements;
	
	 public DashboardPage(WebDriver driver) 
	
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 public List<String> get_TextOfElements()
	 {
		 waitutility=new WaitUtility(driver);
		 generalutilities = new GeneralUtilities(driver);
		 List<String> elementText = new ArrayList<String>();
		 waitutility.wait_ForElementToBeVisible("(//div[@class='container-fluid'])[2]//p");
		 elementText = generalutilities.get_TextOfElements("(//div[@class='container-fluid'])[2]//p");
		System.out.println(elementText);
		return elementText;
	 }
	 

}
