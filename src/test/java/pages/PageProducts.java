package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class PageProducts extends ParentClass {

    public static void imagesVerification(){
        List<WebElement> allProductsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lAllProducts));
        for (int i = 0; i < allProductsList.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(allProductsList.get(i).findElement(lAllProductsImages)));
        }
    }

    public static void pricesVerification(){
        List<WebElement> allProductsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lAllProducts));
        for (int i = 0; i < allProductsList.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(allProductsList.get(i).findElement(lAllProductsPrices)));
        }
    }
    static List<Integer> numberOfCategoriList;
    public static void selectMenu(){
       numberOfCategoriList = new ArrayList<>();
        WebElement eCategorie = driver.findElement(lCategoriesDropdown);
        Select select = new Select(eCategorie);
        List<WebElement> categorielist = select.getOptions();
        categorielist.remove(0);
        int random = getrandom(categorielist.size());
        String selectNumOfCategorie = categorielist.get(random).getText().replaceAll("[^0-9]", "");
        int selectNumber = Integer.parseInt(selectNumOfCategorie);
        numberOfCategoriList.add(selectNumber);
        categorielist.get(random).click();
    }

    public static void specifiedProductsInMenu(){
        clickTo(lAllButton);
        List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lOrderedProductsBySelected));
        int numOfCategorieProduct = numberOfCategoriList.get(0);
        Assert.assertTrue(productList.size() == numOfCategorieProduct);
    }

    static List<WebElement> listProducts = new ArrayList<>();
    static List<String> stringListProducts = new ArrayList<>();
    static List<Double> listProductPrice = new ArrayList<>();

    public static void menuForRanking() {
        Select select = new Select(locatorToElement(lOrderSelect));
        select.selectByIndex(3);
        clickTo(lAllButton);

        listProducts = driver.findElements(lOrderedProductsPrice);
        for (int i = 0; i < listProducts.size(); i++) {
            String gettext1 = listProducts.get(i).getText();
            stringListProducts.add(gettext1);
            String newProduct = stringListProducts.get(i).substring(gettext1.lastIndexOf("F") + 2, gettext1.lastIndexOf("0") - 2);
            double price = Double.parseDouble(newProduct);
            listProductPrice.add(price);
        }
    }

    public static void rankingIsWorkingCorrectly() {
        for (int i = 0; i < listProductPrice.size(); i++) {
            if (i == stringListProducts.size() - 1) break;
            Assert.assertTrue(listProductPrice.get(i) <= listProductPrice.get(i + 1));
        }
    }
}
