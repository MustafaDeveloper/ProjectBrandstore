package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

import static pages.Locators.lHomeImg;
import static pages.Locators.lMeinKonto;

public class PageLogin extends ParentClass {


    public static void productsDefined() {
        List<WebElement> list = driver.findElements(lHomeImg);

        for (WebElement element : list) {
            Assert.assertTrue(!element.getAttribute("src").isEmpty());
        }
    }

    public static void assertMeinKonto() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lMeinKonto));
        clickTo(element);
        Assert.assertTrue(element.getText().contains("Mein Konto"));
    }
}
