package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;

import static pages.Locators.*;

public class PageFilter extends ParentClass {

    static ArrayList<Double> slipBarPrice = new ArrayList<>();

    public static void selectsPriceRange() {
        slideElement(lRightScroll, 50, 0);
        clickTo(lSlipBarPrice);
        slideElement(lLeftScroll, -40, 0);
        WebElement price = locatorToElement(lSlipBarPrice);
        slipBarPrice = getPrices(price.getText().split("—"));
    }

    public static void priceSelectedRange() {
        ArrayList<Double> listProductPrice = getPrices(lOrderedProductsPrice, "F", "0", 2);
        for (int i = 0; i < listProductPrice.size(); i++) {
            Assert.assertTrue(listProductPrice.get(i) >= slipBarPrice.get(0));
            Assert.assertTrue(listProductPrice.get(i) <= slipBarPrice.get(1));
        }
    }


}
