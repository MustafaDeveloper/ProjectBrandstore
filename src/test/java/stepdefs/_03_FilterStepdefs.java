package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.ParentClass;

import java.util.LinkedList;
import java.util.List;

import static pages.Locators.*;
import static pages.PageFilter.priceSelectedRange;
import static pages.PageFilter.selectsPriceRange;

public class _03_FilterStepdefs extends ParentClass {


    @And("User clicks on button Produkte-Filter")
    public void userClicksOnButtonProduct_Filter() {
        clickTo(lProducteFilterButton);
    }


    @When("User selects price range")
    public void userSelectsPriceRange() {
        selectsPriceRange();
        clickTo(lFilternButton);
        clickTo(lAllButton);
    }

    @Then("User verifies the price of the products in the selected range")
    public void userVerifiesThePriceOfTheProductsInTheSelectedRange() {
        priceSelectedRange();
    }

    List<String> selectProductName = new LinkedList<>();

    @When("User selects color with Filter nach Farbe")
    public void useSelectColorWithFilterNachFarbe() {
        selectProductName.add(filterSelected(lFilterByColourInput, lSelectSelectOptions, lColourJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by color is working")
    public void userVerifiesThatFilteringByColorIsWorking() {
        selectAndClick(lOrderedProductsBySelected, lProductsInformation);
        String ürünrenkler = driver.findElement(lProductColourCheck).getText();
        Assert.assertTrue(ürünrenkler.contains(selectProductName.get(0)));

    }

    @When("User selects gender from Filtern-nach-Groesse")
    public void userSelectsGenderFromFiltern_nach_Groesse() {
        selectProductName.add(filterSelected(lFilterBySizeInput, lSelectSelectOptions, lSizeJetzFiltern).get(0));

    }

    @Then("User verifies that filtering by size is working")
    public void userVerifiesThatFilteringBySizeIsWorking() {
        selectAndClick(lOrderedProductsBySelected, lProductsInformation);
        String ürünbeden = driver.findElement(lProductSizeControl).getText();
        Assert.assertTrue(ürünbeden.contains(selectProductName.get(0)));
    }


    @When("User selects gender from Filtern-nach-Material")
    public void userSelectsGenderFromFiltern_nach_Material() {
        selectProductName.add(filterSelected(lFilterByMaterialInput, lSelectSelectOptions, lMaterialJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by material is working")
    public void userVerifiesThatFilteringByMaterialIsWorking() {
        selectAndClick(lOrderedProductsBySelected, lProductsInformation);
        String productMaterial = driver.findElement(lProductMaterialControl).getText();
        Assert.assertTrue(productMaterial.contains(selectProductName.get(0)));
    }

    @When("User selects gender from Filtern-nach-Gender")
    public void userSelectsGenderFromFiltern_nach_Gender() {
        selectProductName.add(filterSelected(lFilterByGenderInput, lSelectSelectOptions, lGenderJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by gender is working")
    public void userVerifiesThatFilteringByGenderIsWorking() {
        selectAndClick(lOrderedProductsBySelected, lProductsInformation);
        String ürüncinsiyet = driver.findElement(lProductGenderControl).getText();
        Assert.assertTrue(ürüncinsiyet.contains(selectProductName.get(0)));

    }

}
