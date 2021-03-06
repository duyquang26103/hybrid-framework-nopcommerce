package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_08_Register_Login_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getDriverBrowsers(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = RandomEmail();
		password = "123123";
	}

	@Test
	public void TC_01_Register_To_System() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGenderRadioButton();

		registerPage.inputFirstNameTextBox("Abner");

		registerPage.inputLastNameTextBox("Siba");

		registerPage.inputEmailTextBox(email);

		registerPage.inputPasswordTextBox(password);

		registerPage.inputConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		homePage = registerPage.clickToLogOutButton();

	}

	@Test
	public void TC_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(email);

		loginPage.inputPasswordTextBox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void TC_03_Dynamic_Locator() {
		homePage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;

}
