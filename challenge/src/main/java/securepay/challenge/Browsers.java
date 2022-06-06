package securepay.challenge;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Browsers {
	
	 public WebDriver driver;
	 String googleUrlpro ;
	 String searchpro;
	 String secureUrlPro;
	 String priceUrlPro;
	 String paymentUrlPro;
	 String signupUrlPro;
	 String salesUrlPro;
	 
	 public WebDriver initializeDriver() throws IOException
	 {
		 
		 String myPath =  System.getProperty("user.dir");
		 Properties pro = new Properties();
		 FileInputStream fis = new FileInputStream(myPath+"\\src\\main\\java\\securepay\\challenge\\data.properties");
		 pro.load(fis);
		 googleUrlpro = pro.getProperty("googleUrl");
		 searchpro = pro.getProperty("search");
		 secureUrlPro = pro.getProperty("mainUrl");
		 priceUrlPro = pro.getProperty("priceUrl");
		 paymentUrlPro = pro.getProperty("paymentUrl");
		 signupUrlPro = pro.getProperty("signupUrl");
		 salesUrlPro = pro.getProperty("salesUrl");
		 String browserName =  pro.getProperty("browser");
		 
		 if (browserName.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", myPath+ "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
		 }
		 else  if (browserName.equals("firefox"))
		 {
			 
		 }
		 else if (browserName.equals("edge"))
		 {
			System.setProperty("webdriver.edge.driver", myPath+ "\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			
			 
		 }
		
		
		 return driver;
		 
		 
	 }
	 
	 
	
	
}
