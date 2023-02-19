package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.utilities.ExcelRead;
import com.supermarket.utilities.GeneralUtilities;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ExcelRead excelread;
	ManageDeliveryBoyPage managedeliveryboypage;
	@Test
	public void verify_SizeOfDeliveryBoys() {

		loginpage = new LoginPage(driver);
		 managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		int expectedValue=40;
		int actualValue=managedeliveryboypage.print_NoOfDeliveryBoysPresent();
		Assert.assertEquals(actualValue, expectedValue);
	}
	@Test
	public void verify_AlertDisplayed() 
	{
		loginpage = new LoginPage(driver);
		 managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		 excelread=new ExcelRead();
		loginpage.login();
		excelread.setExcelFile("Deliveryboy","NewDeliveryBoy");
		String name=excelread.getCellData(0,0)+GeneralUtilities.getTimeStamp();
		String email=excelread.getCellData(0,1);
		String phone=excelread.getCellData(0,2);
		String userName=excelread.getCellData(0,3)+GeneralUtilities.getTimeStamp();
		String password=excelread.getCellData(0,4);
		Assert.assertTrue(managedeliveryboypage.create_NewDeliveryBoy(name, email, phone, userName, password));
		
		
		
		
	}
	

}
