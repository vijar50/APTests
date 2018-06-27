package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.builderClass;

public class PositiveTest extends builderClass{

	@BeforeTest
	public void testSetup() throws IOException {
		//Before a test initialize this driver
		driver = initDriver();
	}
	
	@Test
	public void buyItem() throws InterruptedException {
		/*This test will select the first item from the homepage and click it.
		 * After that it will add the item to cart, wait for pop-up and proceed to checkout
		 * Here we will check the cart displays the right product quantity*/
		driver.get(homeURL());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@id='homefeatured']/li[1]")).isDisplayed());
		driver.findElement(By.xpath("//ul[@id='homefeatured']/li[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@name='Submit']")).isDisplayed());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a")).click();
		String str = driver.findElement(By.xpath("//div[@id='center_column']/h1/span/span")).getText();
		Assert.assertEquals(str, "1 Product");
	}
	
	@Test
	public void searchItem() throws InterruptedException {
		/*This test will perform a search for the  term 'summer'. 
		 * It will then check the results page to confirm the right term was searched for.*/
		driver.get(homeURL());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search_query_top']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Summer");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(2000);
		String str = driver.findElement(By.xpath("//div[@id='center_column']/h1/span[1]")).getText();
		Assert.assertEquals(str, "\"SUMMER\"");
		System.out.println("Assertion completed");
	}
	
	@Test
	public void filtersTest() throws InterruptedException {
		/*This will check the filter functionality and try to find a specific product*/
		driver.get(homeURL());
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='layered_category_4']")).click();
		driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_3']")).click();
		driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_14']")).click();
		String str = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]/div/div[2]/h5/a")).getText();
		Assert.assertEquals(str, "Faded Short Sleeve T-shirts");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		//null clears all the objects in driver out of memory
		driver = null;
	}
}
