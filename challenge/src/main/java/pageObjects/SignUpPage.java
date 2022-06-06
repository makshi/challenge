package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	
	public WebDriver driver;
	By signUp = By.linkText("Sell");
	By enquiry = By.linkText("Make a sales enquiry");
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement sell()
	{
		return driver.findElement(signUp);
	}
	public WebElement makeEnquiry()
	{
		return driver.findElement(enquiry);
	}

}
