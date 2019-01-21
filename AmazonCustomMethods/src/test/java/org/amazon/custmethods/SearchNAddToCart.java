package org.amazon.custmethods;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchNAddToCart {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\AmazonCustomMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		searchAndAdd(6);
	}
	
	public static void searchAndAdd (int itemNumToAdd) {
		WebElement searchEle = driver.findElement(By.id("twotabsearchtextbox"));
		searchEle.sendKeys("mobiles");
		searchEle.sendKeys(Keys.ENTER);
		// converting item number to string
		String itemStringToAdd = String.valueOf(itemNumToAdd);
		// click on Nth item in search results
		String itemLocator = "(//li[@id='result_#$']//following::div/a)[3]";
		itemLocator = itemLocator.replace("#$", itemStringToAdd);
		driver.findElement(By.xpath(itemLocator)).click();
		// switch to new window
		String pWind = driver.getWindowHandle();
		Set<String> allWinds = driver.getWindowHandles();
		for (String child : allWinds) {
			if (!pWind.equals(child)) 
				driver.switchTo().window(child);
		}
		// add to cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		// verify if its added to cart
		String actualCartItemsCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
		Assert.assertEquals("1", actualCartItemsCount);
	}
}
