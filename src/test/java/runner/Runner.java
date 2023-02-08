package runner;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.java.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/Features"
        ,tags = "@Task"
        , glue = "stepDefinations"
        ,plugin = {"json:target/ExtendReport/cucumber.json","html:target/ExtendReport/cucumber-pretty/report.html"}
)
public class Runner extends AbstractTestNGCucumberTests  {
    public static  WebDriver Driver = null;
    public static SoftAssert softAssertion= new SoftAssert();




}
