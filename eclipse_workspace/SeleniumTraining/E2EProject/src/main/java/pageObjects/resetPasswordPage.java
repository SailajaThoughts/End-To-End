package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resetPasswordPage {
	
	WebDriver driver;

	public resetPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email=By.id("email");
	By next=By.xpath("//input[@name='commit']");
	
	public WebElement resetEmail() {
		return driver.findElement(email);
		
	}
	
	public WebElement clickNext() {
		return driver.findElement(next);
		
	}

}
