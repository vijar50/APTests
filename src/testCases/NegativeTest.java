package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.builderClass;

public class NegativeTest extends builderClass{

	@BeforeTest
	public void testSetup() throws IOException {
		//Before a test initialize this driver
		driver = initDriver();

	}
	
	@Test
	public void badLogin() throws InterruptedException {
		/*This test will try to submit a fake login*/
		driver.get(loginURL());
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testemail@bad.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("bAdPW125");
		driver.findElement(By.id("SubmitLogin")).click();
		String str = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(str, "Authentication failed.");
		System.out.println("Asserted");
	}

	@Test
	public void badSize() throws InterruptedException {
		/*This test will select the first item from the homepage and click it.
		 * After that it will try to edit the size to a valid size 
		 * and then an invalid size. It then tries to submit*/
		driver.get(homeURL());
		driver.findElement(By.xpath("//ul[@id='homefeatured']/li[1]")).click();
		Thread.sleep(2000);
		Select s = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		s.selectByVisibleText("L");
		s.selectByVisibleText("XL");
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		//null clears all the objects in driver out of memory
		driver = null;
	}
}
