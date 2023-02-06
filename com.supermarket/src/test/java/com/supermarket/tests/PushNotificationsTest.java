package com.supermarket.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;

public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	@Test
	public void verify_PushNotificationAlert()
	{
		loginpage=new LoginPage(driver);
		pushnotificationpage=new PushNotificationsPage (driver);
		loginpage.login();
		pushnotificationpage.click_OnPushNotification();
		Assert.assertTrue(pushnotificationpage.send_Information("Delivery","At 4 pm"));
	}
	
	 
}
