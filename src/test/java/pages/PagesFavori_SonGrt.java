package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Driver;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class PagesFavori_SonGrt extends ParentClass {
    public static String favorite;
    public static WebElement goruntulenen;
    public static int numOfFavorite;
    public static WebElement favoriteElement;
    public static List<WebElement> favoriteProductSign;
    public static List<WebElement> sonGrountulenenler;

    public static void selectWunschList() {

        favoriteProductSign = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lFavoriUrunListSec));
        List<WebElement> favoriteProductName = driver.findElements(lFavoriUrunIsimList);
        numOfFavorite = getrandom(favoriteProductSign.size());
        favoriteElement = favoriteProductName.get(numOfFavorite);
        favorite = favoriteProductName.get(numOfFavorite).getText();
        System.out.println("favorite = " + favorite);
    }


    public static void clickonWunschButton() {
        clickTo(favoriteProductSign.get(numOfFavorite));
        clickTo(lFavoriButton);
    }

    public static List<String> getFavoriteList() {
        ArrayList<String> productNameList = new ArrayList<>();
        clickTo(lFavoriButton);
        List<WebElement> selectedFavoriteList = driver.findElements(lFavoriListesindekiUrunIsimleriList);
        selectedFavoriteList.forEach(s -> productNameList.add(s.getText()));

        System.out.println("selectedFavoriteList.get(0) = " + selectedFavoriteList.get(0));
        return productNameList;
    }

    public static void selectProduct() {

        selectWunschList();
        sleep(5000);
        clickTo(favoriteElement);
        Driver.getDriver().navigate().back();
        selectWunschList();
        clickTo(favoriteElement);

    }

    public static void sonGoruntulenenList() {
        sleep(5000);
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lSonGoruntulenenler);
         sonGrountulenenler = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lSonGoruntulenenler));
        goruntulenen=favoriteElement;
        System.out.println("-------------------  ");
        sonGrountulenenler.forEach(s-> System.out.println("sonGoruntulenenList = " + s.getText()));
        System.out.println("-------------------  ");
        System.out.println("g = " + goruntulenen.getText());

    }
}
