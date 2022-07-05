package TestingAcademy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import resources.base;
//Adding logs
//generating html reports
//SS on failure
//Jenkins integration


public class ValidateNavigator extends base {
//This initially throws NullPointerException
	private static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();
		driver.get(getBaseURL());
	}

	@Test
	public void validateNavBar() {

		LandingPage lP = new LandingPage(driver);
		Assert.assertTrue(lP.getNavigator().isDisplayed());
		log.info("Navigation bar is displayed");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}