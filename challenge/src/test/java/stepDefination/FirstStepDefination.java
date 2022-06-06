package stepDefination;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;
import pageObjects.SecureMainPage1;
import pageObjects.SignUpPage;
import securepay.challenge.Browsers;
@RunWith(Cucumber.class)
public class FirstStepDefination extends Browsers{
	 JavascriptExecutor j;
	 WebDriverWait wait;	
	 LandingPage load;
	 SecureMainPage1 securemain;
	 SignUpPage sign;
	 PaymentPage pp;
	 
	@Given("^User is on \"([^\"]*)\" page$")
    public void user_is_on_something_page(String strArg1) throws Throwable {
        driver = initializeDriver();
		
		driver.get(strArg1);
		driver.manage().window().maximize();
	    j = (JavascriptExecutor) driver;
	    wait  = new WebDriverWait(driver,Duration.ofSeconds(5, 0));
    }

    @When("^enter \"([^\"]*)\" in google tab$")
    public void enter_something_in_google_tab(String strArg1) throws Throwable {
    	load = new LandingPage(driver);
	    load.enterValueOnGoogleTab().sendKeys(strArg1);
    }

    @When("^select pricing and click standard pricing$")
    public void select_pricing_and_click_standard_pricing() throws Throwable {
    	securemain = new SecureMainPage1(driver);
	      List<WebElement> S =   securemain.clickPrice();
	      S.get(1).click();
	      securemain.clickStandardPrice().click();
	     
    }

    @Then("^validate url \"([^\"]*)\"$")
    public void validate_url_something(String strArg1) throws Throwable {
    	wait.until(ExpectedConditions.urlContains(strArg1));
	    Assert.assertEquals(driver.getCurrentUrl(),strArg1);
    }

    @Then("^verifying page load and \"([^\"]*)\"$")
    public void verifying_page_load_and_something(String strArg1) throws Throwable {
    	j.executeScript("return document.readyState")
	      .toString().equals("complete");
	      wait.until(ExpectedConditions.urlContains(strArg1));
	      Assert.assertEquals(driver.getCurrentUrl(),strArg1);
    }

    @And("^press enter$")
    public void press_enter() throws Throwable {
    	load.enterValueOnGoogleTab().sendKeys(Keys.ENTER);  
    }

    @And("^click website$")
    public void click_website() throws Throwable {
    	load.clickWebsite().click();  
    }
    
    @When("^scrolldown to click LearnMore$")
    public void scrolldown_to_click_learnmore() throws Throwable {
    	j.executeScript("window.scrollBy(0,800)", "");
	      securemain.clickLearnMore().click();
    }

    @When("^clicking contact us & get started$")
    public void clicking_contact_us_get_started() throws Throwable {
    	pp = new PaymentPage(driver);
		pp.contactClick().click();
		 j.executeScript("window.scrollBy(0,350)", ""); 
		 pp.getStart().click();
		 
    }

    @Then("^checking the payment window is loaded and \"([^\"]*)\"$")
    public void checking_the_payment_window_is_loaded_and_something(String strArg1) throws Throwable {
    	Set<String> handles= securemain.windowHandles();
	      Iterator<String> it = handles.iterator();
			String HandleParent = it.next();
			String HandleChild = it.next();
			driver.switchTo().window(HandleChild);
			Assert.assertEquals(driver.getCurrentUrl(),strArg1);
    }

    @Then("^Signupage must be loaded & verifying \"([^\"]*)\"$")
    public void signupage_must_be_loaded_verifying_something(String strArg1) throws Throwable {
    	wait.until(ExpectedConditions.urlContains(strArg1));
		 Assert.assertEquals(driver.getCurrentUrl(),strArg1);
    }
    
    @When("^Navigate to sell and make a sales enquiry & verifying the sales \"([^\"]*)\"$")
    public void navigate_to_sell_and_make_a_sales_enquiry_verifying_the_sales_something(String strArg1) throws Throwable {
    	sign = new SignUpPage(driver);
		 Actions ac = new Actions(driver);		    
		 ac.moveToElement(sign.sell()).build().perform();
		 sign.makeEnquiry().click();
		 wait.until(ExpectedConditions.urlContains(strArg1));
		 Assert.assertEquals(driver.getCurrentUrl(),strArg1);
    }
    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

    }



