package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.DataProviders;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	GeneralUtilities generalutilities = new GeneralUtilities();
	AdminUsersPage adminuserspage;

	@Test
	public void verify_UserDetailsUpdated() {
		String userName = "ashash" + GeneralUtilities.getTimeStamp();
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		Assert.assertTrue(adminuserspage.update_UserDetails("adminhhhjj", userName, "ash"));
	}

	@Test(dataProvider="usersCredentials",dataProviderClass=DataProviders.class)
	public void verify_newUserCreation(String userName,String password,String userType) {
		
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.login();
		
		String user_Name=userName+GeneralUtilities.getTimeStamp();
		
	
		
		Assert.assertTrue(adminuserspage.create_NewUser(user_Name,password,userType));
	}

	@Test
	public void verify_SearchUserIsPresent() {

		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.login();
		String expectedResult = "admin_melva.wiza";

		String actualText = adminuserspage.search_ForAUser("admin_melva.wiza", "staff");
		Assert.assertEquals(actualText, expectedResult);

	}

}
