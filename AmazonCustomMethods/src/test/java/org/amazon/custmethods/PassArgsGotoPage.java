package org.amazon.custmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PassArgsGotoPage {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\AmazonCustomMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		getMenuPassTwoArgs ("Echo & Alexa", "Amazon Echo");
	}
	
	public static void getMenuPassTwoArgs (String parentCat, String subCat) {
		// Hover on ShopByCategory to see menu list
		WebElement shopByCategoryEle = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[2]"));
		Actions ac = new Actions (driver);
	
		// Find locator of parentCategory
		String locatorParCat = "//span[@aria-label='$$']";
		locatorParCat = locatorParCat.replace("$$", parentCat);
		WebElement parentCatEle = driver.findElement(By.xpath(locatorParCat));

		// Find locator of subCategory
		String locatorSubCat = "//span[text()='#$']";
		locatorSubCat = locatorSubCat.replace("#$", subCat);
		WebElement subCatEle = driver.findElement(By.xpath(locatorSubCat));
		
		// Perform all hover actions & goto subCategory's page
		ac.moveToElement(shopByCategoryEle).moveToElement(parentCatEle).moveToElement(subCatEle).click().build().perform();
	}

}
