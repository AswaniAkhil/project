package com.supermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	ManageUsersPage manageuserspage;
	LoginPage loginpage;
	@Test
	public void search_ListUser()
	{
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String expectedText="Sadfg Ddf";
		String actualText=manageuserspage.search_Users("Sadfg Ddf");
		Assert.assertEquals(actualText, expectedText,"Result Not Found");
		
	}
	@Test
	public void verify_ListUsersActivation()
	{
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		manageuserspage.deactivate_User("Neena Neena");
		Assert.assertTrue(manageuserspage.alert_IsDisplayed());
		
	}

}
