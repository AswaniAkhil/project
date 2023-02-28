package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD_WAIT=20;
	public static final long EXPLICIT_WAIT=10;
    public void wait_ForElementToBeVisible(WebElement element)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
    	wait.until(ExpectedConditions.visibilityOf(element));
     }
    public void wait_ForElementToBeClickable(WebElement element)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
     }
    public void wait_ForElementToBeSelectable(String xpath)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
    	wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
     }
    
    
}
