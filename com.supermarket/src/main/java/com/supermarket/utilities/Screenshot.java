package com.supermarket.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	TakesScreenshot takescreenshot;
	public void takeScreenshot(WebDriver driver,String imageName)
	{
		try {
			
			takescreenshot=(TakesScreenshot) driver;
			//captured screenshot
			File file=takescreenshot.getScreenshotAs(OutputType.FILE);
			//avoid duplication
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination=System.getProperty("user.dir")+"\\Screenshots\\"+imageName+timeStamp+".png";
			File finaldestination=new File(destination);
			//copy paste
			FileHandler.copy(file, finaldestination);
			
		}
		catch(Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}
	
		

}
