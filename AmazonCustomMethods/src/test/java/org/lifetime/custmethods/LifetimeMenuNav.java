package org.lifetime.custmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LifetimeMenuNav {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARCHANA\\ArchNewWorkspace\\AmazonCustomMethods\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lifetime.life/");
		WebDriverWait w = new WebDriverWait(driver, 80);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']")));
		getMenuPassTwoArgs ("Membership", "Offers");
	}
	
	public static void getMenuPassTwoArgs (String parentCat, String subCat) {
		Actions ac = new Actions (driver);
		// Locate parent category
		String locatorParCat = "//a[text()='$$']";
		locatorParCat = locatorParCat.replace("$$", parentCat);
		WebElement parCatEle = driver.findElement(By.xpath(locatorParCat));
		driver.switchTo().frame(parCatEle);
				
		// Locate sub category
		String locatorSubCat = "//a[contains(text(),'#$')]";
		locatorSubCat = locatorSubCat.replace("#$", subCat);
		WebElement subCatEle = driver.findElement(By.xpath(locatorSubCat));
		
		// Perform all hover actions
		ac.moveToElement(parCatEle).click().moveToElement(subCatEle).click().build().perform();
	}
}
