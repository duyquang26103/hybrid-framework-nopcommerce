package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.bankGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountButton() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_FOOTER);
		
	}

	

}
