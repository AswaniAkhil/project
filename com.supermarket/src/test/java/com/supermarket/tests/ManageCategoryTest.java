package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCategoryPage;
import com.supermarket.utilities.GeneralUtilities;

public class ManageCategoryTest extends Base {
	ManageCategoryPage managecategorypage;
	LoginPage loginpage;
	@Test
	public void verify_TopMenuNoButtonEnabled()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managecategorypage=new ManageCategoryPage(driver);
		Assert.assertTrue(managecategorypage.is_NoButtonEnabled()," disabled");
	}
	@Test
	public void verify_NewCategoryCreated()
	{
		String category = "fancy and gifts" + GeneralUtilities.getTimeStamp();
		loginpage=new LoginPage(driver);
		loginpage.login();
		managecategorypage=new ManageCategoryPage(driver);
		Assert.assertTrue(managecategorypage.create_NewCategory(category,"fancy"));
	}

}
