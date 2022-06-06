package pageObjects;
import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandonData {
	
	//driver.findElement(By.id("l_name"))
	
	public String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		 }

}
