package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import utils.ParentClass.*;

public class Test extends ParentClass{

    @org.testng.annotations.Test
    public void test1 () {

//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins=*");
//
//        WebDriverManager.chromedriver().setup();
//      WebDriver  driver = new ChromeDriver(option);
       // ParentClass p = new ParentClass();
        gotoSite("https://google.com");



    }
}
