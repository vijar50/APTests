package resources;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class builderClass {
	//This file will create the driver object and we will call it before test execution
	public static WebDriver driver;
	
	
	public WebDriver initDriver() {
		//This is where I have stored the chromedriver file on my machine
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajiv\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public String homeURL() {
		String homepage = "http://automationpractice.com/index.php";
		return homepage;
	}
	
	public String loginURL() {
		String cart = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		return cart;
	}
	
	
}
