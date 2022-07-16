package stepDefinitions;




import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

//Implementation of inheritance
public class StepDefinition extends base {
	
	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
	    
		driver=intializeDriver();
		
	}
	@Given("Navigate to {string}")
	public void navigate_to(String string) throws IOException {
	   
		driver.get(getBaseURL());
	}
	@Given("Click on login link in home page to land on secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
		LandingPage lP=new LandingPage(driver);
		if(lP.getPopUpsize().size()>0) {
			lP.getPopUp().click();
		}
		lP.getLogin().click();
	}
	@When("User enters {string} and {string} and log in")
	public void user_enters_and_and_log_in(String arg1, String arg2) {
		LoginPage l=new LoginPage(driver);
		l.getEmail().sendKeys(arg1);
		l.getPassword().sendKeys(arg2);
		l.getLogin().click();
	}
	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		PortalHomePage p= new PortalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed()); ;
	}

}
