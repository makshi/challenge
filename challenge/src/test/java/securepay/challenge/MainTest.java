package securepay.challenge;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
//import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GenerateRandonData;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;
import pageObjects.SecureMainPage1;
import pageObjects.SignUpPage;

public class MainTest extends Browsers{
	
	GenerateRandonData genData;
	LandingPage load;
	SecureMainPage1 securemain;
	PaymentPage pp;
	SignUpPage sign;
	JavascriptExecutor j;
	 WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
         driver = initializeDriver();
		
		driver.get(googleUrlpro);
		driver.manage().window().maximize();
	    j = (JavascriptExecutor) driver;
	    wait  = new WebDriverWait(driver,Duration.ofSeconds(5, 0));
		
	}
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		// LandingToSecurePayPage-Through-GoogleTab
	    load = new LandingPage(driver);
	    load.enterValueOnGoogleTab().sendKeys(searchpro);
	    load.enterValueOnGoogleTab().sendKeys(Keys.ENTER);
	    load.clickWebsite().click();  
	    
	    // Verifying the Current  URL
	    
	    wait.until(ExpectedConditions.urlContains(secureUrlPro));
	    Assert.assertEquals(driver.getCurrentUrl(),secureUrlPro);	 
	    
	    // Select pricing and click standard pricing & verifying page load
	      securemain = new SecureMainPage1(driver);
	      List<WebElement> S =   securemain.clickPrice();
	      S.get(1).click();
	      securemain.clickStandardPrice().click();    
	      j.executeScript("return document.readyState")
	      .toString().equals("complete");
	      wait.until(ExpectedConditions.urlContains(priceUrlPro));
	      Assert.assertEquals(driver.getCurrentUrl(),priceUrlPro);
	      
	    // scrolldown to click learnMore  
	      j.executeScript("window.scrollBy(0,800)", "");
	      securemain.clickLearnMore().click();
	    // Checking the PaymentWindow is loaded in new window //  
	      Set<String> handles= securemain.windowHandles();
	      Iterator<String> it = handles.iterator();
			String HandleParent = it.next();
			String HandleChild = it.next();
			driver.switchTo().window(HandleChild);
			Assert.assertEquals(driver.getCurrentUrl(),paymentUrlPro);
			
		// Click on contact us
		    pp = new PaymentPage(driver);
			pp.contactClick().click();
			 j.executeScript("window.scrollBy(0,350)", "");
			 // Click on Get Started and verify the SignUpURL 
			 pp.getStart().click();
			 wait.until(ExpectedConditions.urlContains(signupUrlPro));
			 Assert.assertEquals(driver.getCurrentUrl(),signupUrlPro);
			 
         // Navigate to Sell and make a sales enquiry
			 sign = new SignUpPage(driver);
			 Actions ac = new Actions(driver);		    
			 ac.moveToElement(sign.sell()).build().perform();
			 sign.makeEnquiry().click();
			 wait.until(ExpectedConditions.urlContains(salesUrlPro));
			 Assert.assertEquals(driver.getCurrentUrl(),salesUrlPro);
	    // for random data
			// driver.findElement(By.id("l_name")).sendKeys(genData.generateRandomString(20));
			 
			
			 
			
			 
			
	}
	
@AfterMethod
public void tearDown()
{
	driver.quit();
}

	
}
