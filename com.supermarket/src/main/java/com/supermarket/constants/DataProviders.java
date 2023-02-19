package com.supermarket.constants;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.ExcelRead;

public class DataProviders

{
	ExcelRead excelread=new ExcelRead();
	@DataProvider (name="usersCredentials")
	public Object[][] credentialsProvider()
	{
		return new Object [][] {{"userName1","password1","staff"},{"aswani","abcd","staff"},{"john","xyz","staff"}};

	}
	@DataProvider(name="invalidLoginCredentials")
	public Object[][] invalidLoginCredentials()
	{
		excelread.setExcelFile("InvalidLogin","SetOfInvalidLoginData");
		Object data[][]=excelread.get_MultiDimensionalData(3, 2);
		return data;
	}
}
