package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;

public class MobileSliderTest extends Base {
	MobileSliderPage mobilesliderpage;
	LoginPage loginpage;
	
	@Test(groups= {"smoke","sanity"})
	public void verify_NewListCreation()
	{
		mobilesliderpage=new MobileSliderPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		mobilesliderpage.click_OnMobileSlider();
		mobilesliderpage.createNewList(Constants.PIZZA_FILE_PATH);
		Assert.assertTrue(mobilesliderpage.is_AlertDisplayed());
	}

}
