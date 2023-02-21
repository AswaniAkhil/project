package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagePaymentMethodsPage;
import com.supermarket.utilities.ExcelRead;

public class ManagePaymentMethodsTest extends Base {
	 ManagePaymentMethodsPage managepaymentmethodspage;
	 LoginPage loginpage;
		ExcelRead excelread;
		@Test(groups = "smoke")
		public void verify_PaymentUpdate()
		{
			excelread=new ExcelRead();
			managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.login();
			excelread.setExcelFile("Payment","Debit Card");
			String title=excelread.getCellData(0,0);
			String payment=excelread.getCellData(0,1);
			Assert.assertTrue(managepaymentmethodspage.update_PaymentMethodInformation(title, payment));;
		}

}
