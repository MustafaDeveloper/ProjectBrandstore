import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static pages.Locators.*;

public class Main extends ParentClass {
    @Test
    public void login1(){
        List<Integer> sayılar=new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
        for (int i = 0; i < 10; i++) {
            System.out.print(getrandom(sayılar.size()) );

        }

    }

   @Test
    public void Fiyat(){

       gotoSite("https://brandstore.e-shopland.ch/");
       clickTo(lcookies);

       clickTo(lTumUrunlerButonu);
       clickTo(lProducteFilterButton);
       Actions actions=new Actions(driver);
       WebElement slidersağa=wait.until(ExpectedConditions.visibilityOfElementLocated(lSağaaKaydırma));
       Action sağakaydırma=actions.dragAndDropBy(slidersağa,50,0).build();
       sağakaydırma.perform();
       sleepTo(1000);
       WebElement slidersola=wait.until(ExpectedConditions.visibilityOfElementLocated(lSağaaKaydırma));

       Action solakaydırma=actions.dragAndDropBy(slidersola,-60,0).build();
       solakaydırma.perform();


       WebElement fiyat=locatorToElement(lSlipBarFiyat);

      String[] array= fiyat.getText().split("—");
      ArrayList<Double> SlipBarFiyat=new ArrayList<>();


       for (int i = 0; i < array.length; i++) {
           System.out.println(array[i].replaceAll("[^0-9]",""));
           String fiyatstr=array[i].replaceAll("[^0-9]","");
           SlipBarFiyat.add(Double.parseDouble(fiyatstr));
       }
       System.out.println(SlipBarFiyat);

   }
}
