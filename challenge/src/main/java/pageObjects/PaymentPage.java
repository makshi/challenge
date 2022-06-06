package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

	public WebDriver driver;
	
	By contact = By.linkText("Contact Us");
	By getStart = By.xpath("//*[@id=\"main\"]/section[1]/div/div/article[1]/a/span");
	
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement contactClick()
	{
		
		return driver.findElement(contact);
	}
	
	public WebElement getStart()
	{
		return driver.findElement(getStart);
	}
	
	
}
