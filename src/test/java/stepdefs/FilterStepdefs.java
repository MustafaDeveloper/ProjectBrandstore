package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static pages.Locators.*;

public class FilterStepdefs extends ParentClass {


    @And("User clicks on button Produkte-Filter")
    public void userClicksOnButtonProduct_Filter() {
        clickTo(lProducteFilterButton);

    }

    ArrayList<Double> SlipBarFiyat = new ArrayList<>();

    @When("User selects price range")
    public void userSelectsPriceRange() {

        slideElement(lSağaaKaydırma, 50, 0);
        clickTo(lSlipBarFiyat);
        slideElement(lSolaKaydırma, -40, 0);
        WebElement fiyat = locatorToElement(lSlipBarFiyat);
        SlipBarFiyat = getPrices(fiyat.getText().split("—"));
        sleepTo(2000);
        clickTo(lFilternButton);
        clickTo(lAllButonu);

    }

    @Then("User verifies the price of the products in the selected range")
    public void userVerifiesThePriceOfTheProductsInTheSelectedRange() {

        ArrayList<Double> ürünFiyatList = getPrices(lSıralananUrunFiyat, "F", "0", 2);
        for (int i = 0; i < ürünFiyatList.size(); i++) {
            Assert.assertTrue(ürünFiyatList.get(i) >= SlipBarFiyat.get(0));
            Assert.assertTrue(ürünFiyatList.get(i) <= SlipBarFiyat.get(1));
        }
    }

    List<String> selectUrunIsim = new LinkedList<>();

    @When("User selects color with Filter nach Farbe")
    public void useSelectColorWithFilterNachFarbe() {
        selectUrunIsim.add(filtrelemeSecim(lRengeGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lRengeGoreJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by color is working")
    public void userVerifiesThatFilteringByColorIsWorking() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünrenkler = driver.findElement(lUrunRenkKontrol).getText();
        Assert.assertTrue(ürünrenkler.contains(selectUrunIsim.get(0)));

    }

    @When("User selects gender from Filtern-nach-Groesse")
    public void userSelectsGenderFromFiltern_nach_Groesse() {
        selectUrunIsim.add(filtrelemeSecim(lBedeneGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lBedeneGoreJetzFiltern).get(0));

    }

    @Then("User verifies that filtering by size is working")
    public void userVerifiesThatFilteringBySizeIsWorking() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünbeden = driver.findElement(lUrunBedenKontrol).getText();
        Assert.assertTrue(ürünbeden.contains(selectUrunIsim.get(0)));
    }


    @When("User selects gender from Filtern-nach-Material")
    public void userSelectsGenderFromFiltern_nach_Material() {
        selectUrunIsim.add(filtrelemeSecim(lMalzemeyeGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lMalzemeyeGoreJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by material is working")
    public void userVerifiesThatFilteringByMaterialIsWorking() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünMalzeme = driver.findElement(lUrunMalzemeKontrol).getText();
        Assert.assertTrue(ürünMalzeme.contains(selectUrunIsim.get(0)));
    }

    @When("User selects gender from Filtern-nach-Gender")
    public void userSelectsGenderFromFiltern_nach_Gender() {

        selectUrunIsim.add(filtrelemeSecim(lCinsiyeteGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lCinsiyeteGoreJetzFiltern).get(0));
    }

    @Then("User verifies that filtering by gender is working")
    public void userVerifiesThatFilteringByGenderIsWorking() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürüncinsiyet = driver.findElement(lUrunCinsiyetKontrol).getText();
        Assert.assertTrue(ürüncinsiyet.contains(selectUrunIsim.get(0)));

    }

}
