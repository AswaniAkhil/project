package com.supermarket.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;
import com.supermarket.utilities.ExcelRead;

public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	ExcelRead excelread;
	@Test
	public void verify_NotificationSuccessfulAlert()
	{
		excelread=new ExcelRead();
		loginpage=new LoginPage(driver);
		pushnotificationpage=new PushNotificationsPage (driver);
		loginpage.login();
		pushnotificationpage.click_OnPushNotification();
		excelread.setExcelFile("PushNotifications","Notification");
		String title=excelread.getCellData(0,0);
		String description=excelread.getCellData(0,1);
		Assert.assertTrue(pushnotificationpage.send_Information(title,description));
	}
	
	
	 
}
