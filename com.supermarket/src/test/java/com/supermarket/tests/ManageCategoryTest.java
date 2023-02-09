package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCategoryPage;

public class ManageCategoryTest extends Base {
	ManageCategoryPage managecategorypage;
	LoginPage loginpage;
	@Test
	public void verify_TopMenuNoButtonEnabled()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managecategorypage=new ManageCategoryPage(driver);
		Assert.assertTrue(managecategorypage.enable_NoButton()," disabled");
	}

}
