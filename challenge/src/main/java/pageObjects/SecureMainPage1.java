package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureMainPage1 {

	public WebDriver driver;
	
	By pricing = By.xpath("//span[contains(@class,'c-mega__trigger null')]");
	By standPrice = By.linkText("Standard pricing");
	By learnMore =  By.linkText("Learn more");
	
	public SecureMainPage1(WebDriver driver) 
	{
		this.driver = driver;
	}


	public List<WebElement> clickPrice() 
	{
	       return  driver.findElements(pricing);
	}
	public WebElement clickStandardPrice()
	{
		
		return driver.findElement(standPrice);
	}
	public WebElement clickLearnMore()
	{
		return driver.findElement(learnMore);
	}
	public Set<String> windowHandles() 
	{
		return driver.getWindowHandles();
	}
	
}
