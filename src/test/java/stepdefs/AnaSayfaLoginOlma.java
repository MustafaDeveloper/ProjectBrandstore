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


    @Given("kullanıcı siteye gider {string}")
    public void kullanıcıSiteyeGider(String url) {
        gotoSite(url);
        // clickTo(lcookies);

    }

    @When("Ürünlerin tanımlı olduğunu görür")
    public void ürünlerinTanımlıOlduğunuGörür() {

        List<WebElement> list = driver.findElements(lHomeImg);

        for (WebElement element : list) {
            Assert.assertTrue(!element.getAttribute("src").isEmpty());

        }

    }


    @When("Login butonuna basar")
    public void loginButonunaBasar() {
        clickTo(lloginButton);

    }

    @And("kullanıcı  email {string} ve password {string} girer")
    public void kullanıcıEmailVePasswordGirer(String email, String password) {
        sendKeysTo(lusurname, email);
        sendKeysTo(lpassword, password);
    }

    @And("Kullanıcı Anmelden butonuna basar")
    public void kullanıcıAnmeldenButonunaBasar() {
        clickTo(lsubmitButton);
    }

    @Then("Mein Konto ifadesini görür")
    public void meinKontoIfadesiniGörür() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lMeinKonto));
        clickTo(element);
        Assert.assertTrue(element.getText().contains("Mein Konto"));
    }


}
