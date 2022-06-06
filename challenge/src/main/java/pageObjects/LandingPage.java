package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By googleTab = By.name("q");
	By searchWebsite   = By.linkText("Website");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterValueOnGoogleTab()
	{
		return driver.findElement(googleTab);
		
	}
	
	public WebElement clickWebsite()
	{
		return driver.findElement(searchWebsite);
		
	}

}
