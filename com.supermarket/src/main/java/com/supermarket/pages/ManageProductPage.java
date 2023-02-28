package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtilities generalutilities;
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	private WebElement manageProduct;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]")
	private WebElement productImage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement productDeletedAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> listOfProduct;
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_OnManageProduct()
	{
		manageProduct.click();
		
		
	}
	public boolean is_ImagePresent()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.is_Displayed(productImage);
	}
	public boolean delete_AProduct(String usersName)
	{
		manageProduct.click();
		generalutilities=new GeneralUtilities(driver);
		pageutility=new PageUtility(driver);
		 
		 int i=0;
		 List<String>listOfProducts=new ArrayList<String>();
		 
		 listOfProducts =generalutilities.get_TextOfElements(listOfProduct);
		 for(i=0;i<listOfProducts.size();i++)
		 {
			 if(usersName.equals(listOfProducts.get(i)))
			 {
				 i++;
				 break;
			 }
		 }
		
		 WebElement deleteButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+i+"]//td[9]/a[2]"));
		 pageutility.scrollAndClick(deleteButton);
		 pageutility.accept_Alert();
		 return generalutilities.is_Displayed(productDeletedAlert);
	}

}
