package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	//Intializing web driver 
	//global variable- driver
	
	private static final String TakesScreenshot = null;
	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException {
		
		
		prop=new Properties();
		//System.getProperty("user.dir")+"src\\main\\java\\resources\\data.properties";
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//This checks in maven commands
		//String browserName=System.getProperty("browser");
		
		//This checks in data properties file- prop.getProperty
		String browserName=prop.getProperty("browser");
		//When extracting value from the property you cannot
		//use == instead use equals
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\bharg\\eclipse_workspace\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
			
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
		}
		else if(browserName=="firefox")
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nsail\\SeleniumTraining\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName=="Edge"){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\nsail\\SeleniumTraining\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	public String getBaseURL() throws IOException {
		//Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\\\Users\\\\bharg\\\\eclipse_workspace\\\\SeleniumTraining\\\\E2EProject\\\\src\\\\main\\\\java\\\\resources\\\\data.properties");
		prop.load(fis);
		return prop.getProperty("URL");
	}
	
	public String getScreenShotPath(String failedTest,WebDriver driver) throws IOException, InterruptedException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		Thread.sleep(2000);
		File source=ts.getScreenshotAs(OutputType.FILE);
		String fileDestination=System.getProperty("user.dir")+"\\reports\\"+failedTest+".png";
		//System.out.println(fileDestination);
		FileUtils.copyFile(source,new File(fileDestination));
		return fileDestination;
	}

}
