package ReusableFunction;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseTest.BaseTest;


public class ReusableFuncations extends BaseTest {

	public static void Javascriptclick(WebDriver driver, WebElement element2) {
		 WebElement element = driver.findElement(By.xpath(element2.toString()));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(element).perform();
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element);
	 }
	
	
	}
