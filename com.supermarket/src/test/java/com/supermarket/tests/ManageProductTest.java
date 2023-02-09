package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	ManageProductPage manageproductpage;
	LoginPage loginpage;
@Test
public void verify_ImageOfProduct()
{
	 manageproductpage=new ManageProductPage(driver);
	 loginpage=new LoginPage(driver);
	 loginpage.login();
			 
	 manageproductpage.click_OnManageProduct();
	 Assert.assertTrue(manageproductpage.is_ImagePresent());
}
@Test(groups = "sanity")
public void verify_AProductIsDeleted()
{ 
	manageproductpage=new ManageProductPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();

	Assert.assertTrue(manageproductpage.delete_AProduct("kk"));
}
}

