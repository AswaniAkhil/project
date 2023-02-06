package com.supermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.model.ITest;
import com.supermarket.constants.Constants;
import com.supermarket.utilities.Screenshot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Screenshot screenshot=new Screenshot();
	Properties prop = new Properties();
	FileInputStream ip;

	public Base() {
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}

	public void initialize(String browser, String url) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));

	}
	@BeforeMethod
	public void setUpBrowser()
	{
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		initialize(browser, url);
	}
	@AfterMethod
	public void tearDown(ITestResult itestresult)
	{
		//listeners used to identify wheather a testcase is pass or fail,here we use itestresult
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			String testCaseName=itestresult.getName();
			screenshot.takeScreenshot(driver,testCaseName);
		}
	}

}
