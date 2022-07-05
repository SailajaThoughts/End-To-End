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

public class ValidateHeader extends base {
//This initially throws NullPointerException
	public WebDriver driver;
	LandingPage lP;
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver is intialized");
		driver.get(getBaseURL());
		log.info("Navigated to HeaderValidation");
	}

	@Test
	public void validateHeadertext() {
		
		lP = new LandingPage(driver);
		Assert.assertEquals(lP.getHeader().getText(), "Featured Courses56");
		log.info("Successfully validated header");
	}


	
	

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}