package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By.ByCssSelector("a.theme-btn.register-btn");
	//use linktext too
	//Good practice to have a access specifier as private
	private By login=By.cssSelector("a[href*='sign_in']");
	private By header=By.xpath("//h2[text()='Featured Courses']");
	private By navigator=By.xpath("(//div[@class='clearfix'])[3]");
	private By popUp=By.xpath("//button[text()='NO THANKS']");
	public WebElement getLogin() {
		return driver.findElement(login);
		//LoginPage l=new LoginPage(driver);
		//return l;
	}	
	
	public WebElement getHeader() {
		return driver.findElement(header);
		
	}	
	
	public WebElement getNavigator() {
		return driver.findElement(navigator);
		
	}	
	
	public List<WebElement> getPopUpsize() {
		return driver.findElements(popUp);
		
	}	
	public WebElement getPopUp() {
		return driver.findElement(popUp);
		
	}	
}
