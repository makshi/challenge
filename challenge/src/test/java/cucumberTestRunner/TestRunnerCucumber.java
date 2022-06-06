package cucumberTestRunner;

//import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(   
        features = "src/test/java/featureCucumber",
        glue = {"stepDefination"}
        )
public class TestRunnerCucumber extends AbstractTestNGCucumberTests{

}
