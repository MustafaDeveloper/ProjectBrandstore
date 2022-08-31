package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;
import static pages.PageFavorites.*;


public class _04_FavoriteChecksStepDefs {

    List<String> productNameList = new ArrayList<>();

    @Given("user clicks on favorite products")
    public void userClicksOnFavoriteProducts() {
        clickTo(lFavoriteButton);


    }


    @And("user gets products from favorite site")
    public void userGetsProductsFromFavoriteSite() {
        productNameList = getFavoriteList();
    }

    @Then("user checks selected favorite products")
    public void userChecksSelectedFavoriteProducts() {
        System.out.println("user checks selected favorite products --> favorite = " + favorite);
        Assert.assertTrue(productNameList.contains(favorite));
    }

    @Given("User selects product")
    public void userSelectsProduct() {
        clickTo(lAlleProdukteButton);
        clickTo(lAllButton);
        selectProduct();

    }

    @Then("User validates the selected product in the last viewers")
    public void userValidatesTheSelectedProductInTheLastViewers() {
        clickTo(lAlleProdukteButton);
        sonGoruntulenenList();
        System.out.println(favorite);
        System.out.println(lastViewedProductElements.get(0).getText());
        Assert.assertTrue(lastViewedProductNames.contains(favorite));


    }
}
