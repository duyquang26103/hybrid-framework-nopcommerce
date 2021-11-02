package com.nopcommerce.sortdata;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.ComputersPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class SortData_Nopcommerce extends BaseTest {
	WebDriver driver;
	String password_01, password_02, email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "automation12@gmail.com";
		password_01 = "123123";
		password_02 = "123456";
	}

	@Test
	public void TC_01_Sort_Name_A_Z() {
		homePage.moveToComputerLink();
		computersPage = homePage.clickToNoteBookLink();
		computersPage.selectSortBySelectBox("Name: A to Z");
		verifyTrue(computersPage.isDataSortByAToZDisplayed());
		
	}

	@Test
	public void TC_02_Sort_Name_Z_A() {
		computersPage.selectSortBySelectBox("Name: Z to A");
		Assert.assertTrue(computersPage.isDataSortByZToADisplayed());
	}

	@Test
	public void TC_03_Sort_Price_Low_To_High() {	
		computersPage.selectSortBySelectBox("Price: Low to High");
		verifyTrue(computersPage.isDataSortByLowToHighDisplayed());
	}

	@Test
	public void TC_04_Sort_Price_High_To_Low() {
		computersPage.selectSortBySelectBox("Price: High to Low");
		verifyTrue(computersPage.isDataSortByHighToLowDisplayed());
	}

	@Test
	public void TC_05_Display_3_Product() {
		computersPage.selectDisplaySelectBox("3");
		verifyTrue(computersPage.isNextPaginationDisplayed());
		verifyTrue(computersPage.isDisplay3ProductisDisplayed());
		computersPage.clickToPage2Pagination();
		verifyTrue(computersPage.isPreviousPaginationDisplayed());
	}

	@Test
	public void TC_06_Advanced_Sub_Categories() {
		computersPage.selectDisplaySelectBox("6");
		verifyTrue(computersPage.isDisplay6ProductisDisplayed());
		Assert.assertTrue(computersPage.isPaginationFieldUnDisplayed());
	}

	@Test
	public void TC_07_Advanced_Incorrect_Manufacturer() {
		computersPage.selectDisplaySelectBox("9");
		verifyTrue(computersPage.isDisplay9ProductisDisplayed());
		verifyTrue(computersPage.isPaginationFieldUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	ComputersPageObject computersPage;
	
}