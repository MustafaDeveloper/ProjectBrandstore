package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class PageFavorites extends ParentClass {
    public static String favorite;
    public static WebElement goruntulenen;
    public static int numOfFavorite;
    public static WebElement favoriteElement;
    public static List<WebElement> favoriteProducts;
    public static List<WebElement> favoriteProductSign;
    public static List<WebElement> lastViewedProductElements;
    public static List<String> lastViewedProductNames=new ArrayList<>();
    public static ArrayList<String> productNameList;

    public static void selectWunschList() {
        clickTo(lFavoriteButton);
        productNameList = new ArrayList<>();
        favoriteProducts = driver.findElements(lWunschListeProductNameList);
        int i = 1;
        if (favoriteProducts.size() != 0) {
            System.out.println("************* Selected product list **************");
            for (WebElement element : favoriteProducts) {
                System.out.println("element - " + i + " >" + element.getText());
                productNameList.add(element.getText());
            }
            System.out.println("***********************************************");
            numOfFavorite = getrandom(favoriteProducts.size());
            favoriteElement = favoriteProducts.get(numOfFavorite);
            favorite = favoriteElement.getText();
            System.out.println("favorite = " + favorite);
        } else {
            System.out.println("Wunsch List is empty, selecting a product");
            clickTo(lAlleProdukteButton);
            favoriteProductSign = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lSelectFavoriteProductList));
            List<WebElement> favoriteProductName = driver.findElements(lFavoriteProductNameList);
            numOfFavorite = getrandom(favoriteProductSign.size());
            favoriteElement = favoriteProductName.get(numOfFavorite);
            favorite = favoriteProductName.get(numOfFavorite).getText();
            System.out.println("favorite = " + favorite);
            clickTo(favoriteProductSign.get(numOfFavorite));
            clickTo(lFavoriteButton);
            favoriteProducts = driver.findElements(lWunschListeProductNameList);
            for (WebElement element : favoriteProducts) {
                System.out.println("element - " + i + " >" + element.getText());
                productNameList.add(element.getText());
            }
        }
    }


    public static List<String> getFavoriteList() {
        selectWunschList();
        return productNameList;
    }

    public static void selectProduct() {
        selectWunschList();
        clickTo(favoriteElement);
    }

    public static void sonGoruntulenenList() {

        lastViewedProductElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lNeulichAngesehen));

        System.out.println("-------------------  ");
        lastViewedProductElements.forEach(s -> System.out.println("List last viewed = " + s.getText()));
        lastViewedProductElements.forEach(s -> lastViewedProductNames.add(s.getText()));

        System.out.println("-------------------  ");
           }
}
