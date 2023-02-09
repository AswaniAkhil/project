package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageContentPage;
import com.supermarket.utilities.GeneralUtilities;

public class ManageContentTest extends Base{
	ManageContentPage managecontentpage;
	LoginPage loginpage;
	@Test
	public void verify_AlertText()
	{
		String contentTitle="Make A Trip"+GeneralUtilities.getTimeStamp();
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		managecontentpage=new ManageContentPage(driver);
		managecontentpage.click_OnManageContent();
		
		Assert.assertTrue(managecontentpage.create_NewContent(contentTitle, "Best Travel partner"+GeneralUtilities.getTimeStamp(),"Travel"));
		
		
	}
	

}
