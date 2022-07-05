package TestingAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.resetPasswordPage;
import resources.base;

public class HomePage extends base{
//This initially throws NullPointerException
	private static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeMethod
public void initialize() throws IOException {
	driver=intializeDriver();
	driver.get(getBaseURL());
}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String email,String password, String access) throws IOException  {
		
		//driver=intializeDriver();
		//driver.get(prop.getProperty("URL"));
		LandingPage lP=new LandingPage(driver);
		lP.getLogin().click();
		LoginPage l=new LoginPage(driver);
		//LoginPage l = lP.getLogin();
		l.getEmail().sendKeys(email);
		l.getPassword().sendKeys(password);
		l.getLogin().click();
	    resetPasswordPage fp=l.forgotPassword();
	    fp.resetEmail().sendKeys("abc@gmam");
	    fp.clickNext().click();
		//System.out.println(access);
		//log.info("validated User");
	}
	
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many diffferent data types test should run
		//column stands for how many values per each test
		Object[][] data=new Object[2][3];
		data[0][0]="firstname@gmail.com";
		data[0][1]="12345";	
		data[0][2]="restrictedUser";
		
		data[1][0]="secondname@gmail.com";
		data[1][1]="123";
		data[1][2]="NonrestrictedUser";
		
		return data;
		
	}
@AfterMethod
public void teardown() {
	driver.quit();
}
	

}
