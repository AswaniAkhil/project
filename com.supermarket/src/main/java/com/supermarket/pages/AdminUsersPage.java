package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	private WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement updateUserName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement updatePassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement newUserType;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newUserAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchUser;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUserName;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchUserType;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement searchResult;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> adminUsersElements;
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean update_UserDetails(String name, String u, String p) {
		int i;
		adminUsersMoreInfo.click();
		generalutilities = new GeneralUtilities(driver);
		pageutility    = new PageUtility(driver);

		List<String> adminUsers = new ArrayList<String>();

		
		adminUsers=generalutilities.get_TextOfElements(adminUsersElements);
		for (i = 0; i < adminUsers.size(); i++) {
			if (name.equals(adminUsers.get(i))) {
				i++;
				break;
			}}
		
		WebElement editButton = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + i + "]//td[5]//a[2]"));
		pageutility.scrollAndClick(editButton);
		
		updateUserName.sendKeys(u);
		updatePassword.sendKeys(p);
		Select select = new Select(userType);
		select.selectByIndex(3);
		updateButton.click();
		waitutility = new WaitUtility(driver);
		waitutility.wait_ForElementToBeVisible(alert);
		return generalutilities.is_Displayed(alert);

	}

	public boolean create_NewUser(String userName, String password, String userType) {
		generalutilities = new GeneralUtilities(driver);
		adminUsersMoreInfo.click();
		Select select = new Select(newUserType);
		newButton.click();
		newUserName.sendKeys(userName);
		newPassword.sendKeys(password);
		select.selectByValue(userType);
		save.click();
		return generalutilities.is_Displayed(newUserAlert);

	}

	public String search_ForAUser(String userName, String UserType) {
		generalutilities = new GeneralUtilities(driver);
		waitutility = new WaitUtility(driver);
		adminUsersMoreInfo.click();
		searchUser.click();
		searchUserName.sendKeys(userName);
		Select select = new Select(searchUserType);
		select.selectByValue(UserType);
		searchButton.click();

		return generalutilities.get_TextOfElement(searchResult);

	}

}
