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

public class FiltrelemeStepdefs extends ParentClass {


    @And("Kullanıcı Produkte-Filtere tıklar")
    public void kullanıcıProdukteFiltereTıklar() {
        clickTo(lProducteFilterButton);

    }

    ArrayList<Double> SlipBarFiyat = new ArrayList<>();

    @When("Kullanıcı seçtiği fiyat aralığı seçer")
    public void kullanıcıSeçtiğiFiyatAralığıSeçer() {

        slideElement(lSağaaKaydırma, 50, 0);
        clickTo(lSlipBarFiyat);
        slideElement(lSolaKaydırma, -40, 0);
        WebElement fiyat = locatorToElement(lSlipBarFiyat);
        SlipBarFiyat = getPrices(fiyat.getText().split("—"));
        sleepTo(2000);
        clickTo(lFilternButton);
        clickTo(lAllButonu);

    }

    @Then("Seçtiği fiyat aralığındaki ürünlerin fiyatını doğrular")
    public void sectigiFiyatAralıgındakiUrunlerinFiyatınıDogrular() {

        ArrayList<Double> ürünFiyatList = getPrices(lSıralananUrunFiyat, "F", "0", 2);
        for (int i = 0; i < ürünFiyatList.size(); i++) {
            Assert.assertTrue(ürünFiyatList.get(i) >= SlipBarFiyat.get(0));
            Assert.assertTrue(ürünFiyatList.get(i) <= SlipBarFiyat.get(1));
        }
    }

    List<String> selectUrunIsim = new LinkedList<>();

    @When("Filter nach Farbe kısmından renk seçer")
    public void filterNachFarbeKısmındanRenkSeçer() {
        selectUrunIsim.add(filtrelemeSecim(lRengeGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lRengeGoreJetzFiltern).get(0));
    }

    @Then("Seçtiği renge göre ürün filtrelemenin çalıştığını doğrular")
    public void seçtiğiRengeGöreÜrünFiltrelemeninÇalıştığınıDoğrular() {

        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünrenkler = driver.findElement(lUrunRenkKontrol).getText();
        Assert.assertTrue(ürünrenkler.contains(selectUrunIsim.get(0)));

    }

    @When("Filtern nach Grösse kısmından beden seçer")
    public void filternNachGrösseKısmındanBedenSeçer() {
        selectUrunIsim.add(filtrelemeSecim(lBedeneGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lBedeneGoreJetzFiltern).get(0));

    }

    @Then("Seçilen bedene göre ürün filtrelemesinin çalıştığını doğrular")
    public void seçilenBedeneGöreÜrünFiltrelemesininÇalıştığınıDoğrular() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünbeden = driver.findElement(lUrunBedenKontrol).getText();
        Assert.assertTrue(ürünbeden.contains(selectUrunIsim.get(0)));
    }


    @When("Filtern nach Material kısmından malzeme türünü seçer")
    public void filternNachMaterialKısmındanMalzemeTürünüSeçer() {
        selectUrunIsim.add(filtrelemeSecim(lMalzemeyeGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lMalzemeyeGoreJetzFiltern).get(0));
    }

    @Then("Seçilen malzemeye göre ürün filtrelemesinin çalıştığını doğrular")
    public void seçilenMalzemeyeGöreÜrünFiltrelemesininÇalıştığınıDoğrular() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürünMalzeme = driver.findElement(lUrunMalzemeKontrol).getText();
        Assert.assertTrue(ürünMalzeme.contains(selectUrunIsim.get(0)));
    }

    @When("Filtern nach Gender kısmından cinsiyet seçer")
    public void filternNachGenderKısmındanCinsiyetSeçer() {

        selectUrunIsim.add(filtrelemeSecim(lCinsiyeteGoreFiltrelemeInput, lSelectdekiFiltrelemeKıstasları, lCinsiyeteGoreJetzFiltern).get(0));
    }

    @Then("Seçtiği cinsiyete göre ürün filtrelemesinin çalıştığını doğrular")
    public void seçtiğiCinsiyeteGöreÜrünFiltrelemesininÇalıştığınıDoğrular() {
        urunSecipTıkla(lSecileneGoreSıralananUrunler, lUrunOzellikler);
        String ürüncinsiyet = driver.findElement(lUrunCinsiyetKontrol).getText();
        Assert.assertTrue(ürüncinsiyet.contains(selectUrunIsim.get(0)));

    }

}
