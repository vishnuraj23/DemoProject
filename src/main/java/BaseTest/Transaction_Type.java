package BaseTest;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Transaction_Type {

	public List<Object> Trans_Type(WebDriver driver) 
	{
		
		String TransType = null;
		
		TransType = driver.findElement(By.cssSelector("label#CoPolicySelectPg_PolicyGrid_lblTransactionType")).getText();
		
		return Arrays.asList(TransType);
	}
	
}
