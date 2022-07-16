package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email=By.id("email");
	By password=By.cssSelector("input[type='password']");
	By submit=By.xpath("//input[@name='commit']");
	By forgotPassword=By.cssSelector("a[href*='forgot']");
	
	
	public WebElement getEmail() {
		return driver.findElement(email);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
		
	}
	
	public WebElement getLogin() {
		return driver.findElement(submit);
		
	}
	//Redirecting directly to forgotpassword page
	public resetPasswordPage forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new resetPasswordPage(driver);

	}
}
