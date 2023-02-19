package com.supermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.DashboardPage;
import com.supermarket.pages.LoginPage;

public class DashboardTest extends Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	@Test
	public void verify_DashboardElements() {

		loginpage = new LoginPage(driver);
		loginpage.login();
	dashboardpage=new DashboardPage(driver);
	 List<String> expectedText = new ArrayList<String>();
	
	 expectedText.add("Manage Pages");
	 expectedText.add("Admin Users");
	 expectedText.add("Dashboard");
	 expectedText.add("Category");
	 expectedText.add("Manage Product");
	 expectedText.add("Manage Offer Code");
	 expectedText.add("Manage Slider");
	 expectedText.add("Manage Package");
	 expectedText.add("Manage Delivery Boy");
	 expectedText.add("Manage Users");
	 expectedText.add("Manage Orders");
	 expectedText.add("Manage Location");
	 expectedText.add("Purchased Packages");
	 expectedText.add("Mobile Slider");
	 expectedText.add("Manage News");
	 expectedText.add("Manage Expense");
	 expectedText.add("Manage Gift cards &vouchers");
	 expectedText.add("Manage Gift cards &vouchers");
	 List<String> actualText = new ArrayList<String>();
	  actualText= dashboardpage.get_TextOfElements();
	Assert.assertEquals(actualText, expectedText);
	}
	@Test
	public void verify_SizeOfDashboardElements() {

		loginpage = new LoginPage(driver);
		loginpage.login();
	dashboardpage=new DashboardPage(driver);
	int expectedValue=18;
	int actualValue=dashboardpage.get_TextOfElements().size();
	Assert.assertEquals(actualValue, expectedValue);
	}
	
}
