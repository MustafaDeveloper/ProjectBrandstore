package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ParentClass;

import static pages.Locators.*;
import static pages.PageLogin.assertMeinKonto;
import static pages.PageLogin.productsDefined;

public class _01_LoginStepdefs extends ParentClass {


    @Given("User goes to page {string}")
    public void userGoesToPage(String url) {
        gotoSite(url);
    }

    @When("User sees that the Products are defined")
    public void userSeesThatTheProductsAreDefined() {
        productsDefined();
    }


    @When("User clicks on button Login")
    public void userClicksOnButtonLogin() {
        clickTo(lloginButton);
    }

    @And("User enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        sendKeysTo(lusername, email);
        sendKeysTo(lpassword, password);
    }

    @And("User clicks on button Anmelden")
    public void userClicksOnButtonAnmelden() {
        clickTo(lsubmitButton);
    }

    @Then("User sees statement Mein Konto")
    public void userSeesStatementMeinKonto() {
        assertMeinKonto();
    }


}
