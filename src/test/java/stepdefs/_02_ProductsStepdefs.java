package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ParentClass;

import static pages.Locators.lAllButton;
import static pages.Locators.lAlleProdukteButton;
import static pages.PageProducts.*;

public class _02_ProductsStepdefs extends ParentClass {

    @And("User clicks on button Alle Produkte")
    public void userClicksOnButtonAlleProdukte() {
        clickTo(lAlleProdukteButton);
    }

    @When("User clicks on button All")
    public void userClicksOnButtonAll() {
        clickTo(lAllButton);
    }


    @Then("User verifies the existence of images of all products")
    public void userVerifiesTheExistenceOfImagesOfAllProducts() {
        imagesVerification();
    }


    @And("User verifies the existence of prices of all products")
    public void userVerifiesTheExistenceOfPricesOfAllProducts() {
        pricesVerification();
    }


    @When("User selects menu from Kategorien-Dropdown")
    public void userSelectsMenuFromKategorien_Dropdown() {
        selectMenu();
    }

    @Then("User validates the number of products specified in the menu")
    public void userValidatesTheNumberOfProductsSpecifiedInTheMenu() {
        specifiedProductsInMenu();
    }

    @When("User selects menu for ranking")
    public void userSelectsMenuForRanking() {
        menuForRanking();
    }

    @Then("User verifies that ranking is working correctly")
    public void userVerifiesThatRankingIsWorkingCorrectly() {
        rankingIsWorkingCorrectly();

    }
}
