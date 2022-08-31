package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class ProductsStepdefs extends ParentClass {

    @And("User clicks on button Alle Produkte")
    public void userClicksOnButtonAlleProdukte() {
        clickTo(lTumUrunlerButonu);

    }

    @When("User clicks on button All")
    public void userClicksOnButtonAll() {
        //clickTo(lJetztShoppenButton);
        clickTo(lAllButonu);

    }


    @Then("User verifies the existence of images of all products")
    public void userVerifiesTheExistenceOfImagesOfAllProducts() {
        List<WebElement> tümUrünlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lTümürünler));
        for (int i = 0; i < tümUrünlist.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(tümUrünlist.get(i).findElement(lTümürünlerResim)));
            //ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(tümUrünlist.get(i).findElement(lTümÜrünisim).getText(), "ürün isim", ExcelUtility.getCurrentTime())));

        }


    }


    @And("User verifies the existence of prices of all products")
    public void userVerifiesTheExistenceOfPricesOfAllProducts() {
        List<WebElement> tümUrünlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lTümürünler));

        for (int i = 0; i < tümUrünlist.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(tümUrünlist.get(i).findElement(lTümÜrünlerFiyat)));
            // ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(tümUrünlist.get(i).findElement(lTümÜrünlerFiyat).getText().replaceAll("[^0-9]",""),"ürün fiyat kontrol",ExcelUtility.getCurrentTime())));

        }


    }

    List<Integer> KategoriSayıList = new ArrayList<>();

    @When("User selects menu from Kategorien-Dropdown")
    public void userSelectsMenuFromKategorien_Dropdown() {
        WebElement eKategori = driver.findElement(lKategorilerDropdown);
        Select select = new Select(eKategori);
        List<WebElement> kategorilist = select.getOptions();
        kategorilist.remove(0); //selecteki ilk indeksteki kategori seçeneği değil o yüzden sildim
        int random = getrandom(kategorilist.size());
        String selectkategoriSayi = kategorilist.get(random).getText().replaceAll("[^0-9]", "");
        int selectekisayi = Integer.parseInt(selectkategoriSayi);
        KategoriSayıList.add(selectekisayi);
        kategorilist.get(random).click();

    }

    @Then("User validates the number of products specified in the menu")
    public void userValidatesTheNumberOfProductsSpecifiedInTheMenu() {

        clickTo(lAllButonu);
        List<WebElement> ürünlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lSecileneGoreSıralananUrunler));
        int kategoriürünSayi=KategoriSayıList.get(0);
        Assert.assertTrue(ürünlist.size()==kategoriürünSayi);

    }

    static List<WebElement> ürünlist = new ArrayList<>();
    static List<String> ürünlistString = new ArrayList<>();
    static List<Double> ürünFiyatList = new ArrayList<>();


    @When("Kullanıcı sıralama işlemi için menü seçer")
    public void kullanıcıSıralamaIşlemiIçinMenüSeçer() {
        Select select = new Select(locatorToElement(lSıralamaSelect));
        select.selectByIndex(3);
        sleepTo(1000);
        clickTo(lAllButonu);

        ürünlist = driver.findElements(lSıralananUrunFiyat);
        for (int i = 0; i < ürünlist.size(); i++) {
            String gettext1 = ürünlist.get(i).getText();
            ürünlistString.add(gettext1);
            String yeni = ürünlistString.get(i).substring(gettext1.lastIndexOf("F") + 2, gettext1.lastIndexOf("0") - 2);
            double fiyat = Double.parseDouble(yeni);
            ürünFiyatList.add(fiyat);
        }


    }

    @Then("Kullanıcı sıralamanın doğru çalıştığını doğrular")
    public void kullanıcıSıralamanınDoğruÇalıştığınıDoğrular() {
        for (int i = 0; i < ürünFiyatList.size(); i++) {
            if (i == ürünlistString.size() - 1) break;
            Assert.assertTrue(ürünFiyatList.get(i) <= ürünFiyatList.get(i + 1));
        }

    }
}
