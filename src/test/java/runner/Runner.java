package runner;


import io.cucumber.java.AfterAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/"},
        glue = {"stepdefs", "utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true


)
public class Runner extends AbstractTestNGCucumberTests {
    @AfterClass
    public void after() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Driver.quitDriver();

    }
}