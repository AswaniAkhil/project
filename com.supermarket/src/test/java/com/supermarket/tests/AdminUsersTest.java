package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	GeneralUtilities generalutilities=new GeneralUtilities();
	AdminUsersPage adminuserspage;
	@Test
	public void verify_UserDetailsUpdated()
	{
		String userName="ashash"+GeneralUtilities.getTimeStamp();
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		Assert.assertTrue(adminuserspage.update_UserDetails("deliveryBoy_sharee.emard",userName, "ash"));
	}

}
