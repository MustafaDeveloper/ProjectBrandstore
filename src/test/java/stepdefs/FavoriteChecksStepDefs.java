package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.lAllButonu;
import static pages.Locators.lTumUrunlerButonu;
import static pages.PagesFavori_SonGrt.*;


public class FavoriteChecksStepDefs {

    List<String> productNameList = new ArrayList<>();

    @Given("user clicks on favorite products")
    public void userClicksOnFavoriteProducts() {
        selectWunschList();

    }

    @When("user clicks on favorite button")
    public void userClicksOnFavoriteButton() {
        clickTo(lTumUrunlerButonu);
        clickTo(lAllButonu);
        clickonWunschButton();

    }

    @And("user gets products from favorite site")
    public void userGetsProductsFromFavoriteSite() {
        productNameList = getFavoriteList();
    }

    @Then("user checks selected favorite products")
    public void userChecksSelectedFavoriteProducts() {
        System.out.println("favorite = " + favorite);
        Assert.assertTrue(productNameList.contains(favorite));
    }

    @Given("User selects product")
    public void userSelectsProduct() {
        clickTo(lTumUrunlerButonu);
        clickTo(lAllButonu);
        selectProduct();

    }

    @Then("User validates the selected product in the last viewers")
    public void userValidatesTheSelectedProductInTheLastViewers() {
        sonGoruntulenenList();
        Assert.assertTrue(sonGrountulenenler.contains(goruntulenen));


    }
}
