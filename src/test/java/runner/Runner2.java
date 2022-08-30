package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/Filtreleme.feature"},
        glue = {"stepdefs","utils"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true


)
public class Runner2 extends AbstractTestNGCucumberTests {
    @AfterClass
    public void after(){
        Driver.quitDriver();
    }
}
