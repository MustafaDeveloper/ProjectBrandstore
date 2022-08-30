package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

import static pages.Locators.*;

public class AnaSayfaLoginOlma extends ParentClass {


    @Given("User goes to page {string}")
    public void userGoesToPage(String url) {
        gotoSite(url);
        // clickTo(lcookies);

    }

    @When("User sees that the Products are defined")
    public void userSeesThatTheProductsAreDefined() {

        List<WebElement> list = driver.findElements(lHomeImg);

        for (WebElement element : list) {
            Assert.assertTrue(!element.getAttribute("src").isEmpty());

        }

    }


    @When("User presses on button Login")
    public void userPressesOnButtonLogin() {
        clickTo(lloginButton);

    }

    @And("User enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        sendKeysTo(lusurname, email);
        sendKeysTo(lpassword, password);
    }

    @And("User presses button Anmelden")
    public void userPressesButtonAnmelden() {
        clickTo(lsubmitButton);
    }

    @Then("User sees statement Mein Konto")
    public void userSeesStatementMeinKonto() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lMeinKonto));
        clickTo(element);
        Assert.assertTrue(element.getText().contains("Mein Konto"));
    }


}
