package com.supermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.constants.DataProviders;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelRead;

public class LoginTest extends Base {
	LoginPage loginpage;
	ExcelRead excelread;
	@Test(groups = "smoke")
	public void verifyLogin()
	{
		excelread=new ExcelRead();
		excelread.setExcelFile("InvalidLogin","InvalidLoginCredentials");
		System.out.println(excelread.getCellData(0,0));
		System.out.println(excelread.getCellData(0,1));
		loginpage=new LoginPage(driver);
		Assert.assertTrue(loginpage.login());
	}
	@Test(groups ="smoke" )
	public void verify_InvalidCredentialsErrorMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("aswani", "admin");
		String expectedErrorMessage=Constants.expectedErrorMessage;
		String actualErrorMessage=loginpage.get_ErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"error message is not displayed");
	}
	@Test(dataProvider="invalidLoginCredentials",dataProviderClass=DataProviders.class)
	public void verify_InvalidLoginCredentials(String userName,String password)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		System.out.println(userName+" "+password);
		
	}
	@Test
	public void verify_LogoDisplayed()
	{
		loginpage=new LoginPage(driver);
		Assert.assertTrue(loginpage.logoDisplayed());
	}
	@Test
	public void verify_LogoText()
	{
		loginpage=new LoginPage(driver);
		String expectedText="7rmart supermarket";
		String actualText=loginpage.logoText();
		Assert.assertEquals(actualText, expectedText,"Logo Not Displayed");
	}
	@Test
	public void verify_CheckBoxIsEnabled()
	{
		loginpage=new LoginPage(driver);
		Assert.assertTrue(loginpage.clickOnRememeberMe());
		
	}
	@Test(groups = "smoke")
	public void verify_TextOfSignInButton()
	{
		loginpage=new LoginPage(driver);
		String expectedText="Sign In";
		String actualText=loginpage.get_TextOfSignInButton();
		Assert.assertEquals(actualText, expectedText,"wrong text");
	}
	@Test
	public void verify_ProfileTextElement()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		String expectedText="Admin";
		String actualText=loginpage.profile_TextElement();
		Assert.assertEquals(actualText, expectedText,"wrong text");
	}
	@Test
	public void verify_DashboardContents()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		List<String>expectedDashboardCatagories=new ArrayList<String>();
		expectedDashboardCatagories.add("Manage Pages");
		List<String>actualDashboardCatagories=new ArrayList<String>();
		 actualDashboardCatagories=loginpage.get_CatagoriesOfDashboard();
		System.out.println(actualDashboardCatagories);
		System.out.println(actualDashboardCatagories.size());
		Assert.assertEquals(actualDashboardCatagories.size(), 18);
	}
	@Test
	public void verify_LoggedOutAlert()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		
		String expectedText="Sign in to start your session";
		String actualText=loginpage.is_UserLoggedOut();
		Assert.assertEquals(actualText, expectedText,"Wrong text");
	}
	
	

}
