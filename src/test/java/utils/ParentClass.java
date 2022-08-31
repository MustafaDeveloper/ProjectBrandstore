package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class ParentClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public ParentClass(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    public void gotoSite(String url){
        driver.get(url);
    }
    public static void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendKeysTo(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public void sendKeysTo(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollIntoView(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",locatorToElement(by));
    }
    public static void sleepTo(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void quitDriver() throws InterruptedException {
        sleepTo(1000);
        driver.quit();
    }
    public void hover(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public List <WebElement> WebElementlist(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> productL=wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return productL;

    }
    public static int getrandom(int size){

        return (int) (Math.random() * size);
    }
    public static int getrandom(int max, int min){

        return (int) (Math.random() * (max-min)+min);
    }
    public static WebElement locatorToElement(By locator){
        return driver.findElement(locator);
    }


    public void login(){
        driver.get("https://brandstore.e-shopland.ch/");
        clickTo(lcookies);
        clickTo(lloginButton);
        sendKeysTo(lusername,"kursjava@gmail.com");
        sendKeysTo(lpassword,"kurs.java.123");
        clickTo(lsubmitButton);

    }

    public static void slideElement(By by, int xValue, int yValue) {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Action actionElement = actions.dragAndDropBy(element, xValue, yValue).build();
        actionElement.perform();
        sleepTo(500);

    }

    public static ArrayList<Double> getPrices(String[] strArray) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            arrayList.add(getPrice(strArray[i]));
        }
        return arrayList;
    }

    public static ArrayList<Double> getPrices(By by, String str1, String str2, int indexFirstLast) {
        List<WebElement> ürünlist = driver.findElements(by);
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < ürünlist.size(); i++) {
            String string = ürünlist.get(i).getText();
            string = string.substring(string.lastIndexOf(str1) + 2, string.lastIndexOf(str2) - 2);
            arrayList.add(Double.parseDouble(string));
        }
        return arrayList;
    }

    public static double getPrice(String str) {
        String fiyatstr = str.replaceAll("[^0-9]", "");
        return Double.parseDouble(fiyatstr);
    }
    public void selectAndClick(By listlocator, By clicklocator){
        List<WebElement> ürünlist = driver.findElements(listlocator) ;
        int random = getrandom(ürünlist.size());
        scrollIntoView(ürünlist.get(random));
        sleepTo(1000);
        ürünlist.get(random).click();
        clickTo(clicklocator);
    }

    public List<String> filterSelected(By filtrelemeinput, By ürünlist, By clickJetzFiltern){
        clickTo(filtrelemeinput);
        sleepTo(1000);
        List<WebElement> getOptions = driver.findElements(ürünlist);
        List<String> selectUrunIsim = new ArrayList<>();
        int random = getrandom(getOptions.size());
        String gettext = getOptions.get(random).getText();
        selectUrunIsim.add(gettext);
        getOptions.get(random).click();
        clickTo(clickJetzFiltern);
        clickTo(lAllButton);
        sleepTo(500);
        return selectUrunIsim;
    }


public static void sleep(long ms){
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


}
