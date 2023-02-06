package com.supermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {
	WebDriver driver;
	public GeneralUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	public String get_TextOfElement(WebElement element)
	{
		
		return element.getText();
	}
	public String get_AttributeOfElement(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	public boolean is_Displayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public boolean is_Selected(WebElement element)
	{
		return element.isSelected();
	}
	public boolean is_Enabled(WebElement element)
	{
		return element.isEnabled();
	}
	public List<String> get_TextOfElements(String xpath)
	{
	List<String>textData=new ArrayList<String>();
	List<WebElement>elements=driver.findElements(By.xpath(xpath));
	for(WebElement element:elements)
	{
		textData.add(element.getText());
	}
	return textData;
	}
	public static String getTimeStamp()
	{ 
		//for avoid duplication
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
	
	
	

}
