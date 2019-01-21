package org.flipkart.custmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PassArgsGotoPage {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\CustomMethodsFlipkart\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		// close the login popup
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		getMenuPassTwoArgs ("Women", "Ethnic Wear");
	}
	
	public static void getMenuPassTwoArgs (String parentCat, String subCat) {
		Actions ac = new Actions (driver);
		// Locate parent category
		String locatorParCat = "//span[text()='$$']";
		locatorParCat = locatorParCat.replace("$$", parentCat);
		WebElement parCatEle = driver.findElement(By.xpath(locatorParCat));
				
		// Locate sub category
		String locatorSubCat = "(//a[@title='#$'])[1]";
		locatorSubCat = locatorSubCat.replace("#$", subCat);
		WebElement subCatEle = driver.findElement(By.xpath(locatorSubCat));
		
		// Perform all hover actions
		ac.moveToElement(parCatEle).click().moveToElement(subCatEle).click().build().perform();
	}
}
