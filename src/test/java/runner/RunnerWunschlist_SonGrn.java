package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/Favori_SonGoruntulenenler.feature"},
        glue = {"stepdefs","utils"},
        tags ="@SonGrt",
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true


)
public class RunnerWunschlist_SonGrn extends AbstractTestNGCucumberTests {
    @AfterClass
    public void after(){
        Driver.quitDriver();
    }
}
