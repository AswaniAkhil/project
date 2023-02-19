package com.supermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.constants.Constants;

public class PageUtility {
	WebDriver driver;
	public PageUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void select_ByIndex(int index,WebElement element)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void select_ByValue(String value,WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void select_ByVisibility(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(text);
	}
	
	
	public void double_Click(WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public void click_element(WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).build().perform();
	}
	public void moveToElement(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void right_Click(WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public void scroll_Down(int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void scroll_IntoView(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		
	}
	public void scrollAndClick(WebElement element)
	{
		int x=0;
		JavascriptExecutor js=(JavascriptExecutor) driver;
		while(is_Clicked(element))
		{ 
			js.executeScript("window.scrollBy(0," + x + ")");
			x=x+20;
			
			
		}
		
	}
	public boolean is_Clicked(WebElement element)
	{
		try
		{
			element.click();
			return false;
		}catch(Exception e)
		{
		return true;	
		}
		
	}
	public void click_UsingJavascript(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public String get_Text()
	{
		String s=driver.switchTo().alert().getText();
		return s;
		
		
	}
	public void accept_Alert()
	{
		driver.switchTo().alert().accept();
	}
	public void dismiss_Alert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void upload_File(WebElement element,String fileName)
	{
		String path=Constants.IMAGES_FILE_PATH+fileName+".jfif";
		element.sendKeys(path);
		
		
	}

}
