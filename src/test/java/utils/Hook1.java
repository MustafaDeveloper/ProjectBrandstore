package utils;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;

import java.util.ArrayList;
import java.util.Arrays;

public class Hook1 {
    public static String path = "src/test/java/excel/log1.xlsx";
    public static String sheetName = "logSayfasi1";

    @Before
    public void beforeHook(Scenario scenario) {
        Driver.getDriver();
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "Başladı", ExcelUtility.getCurrentTime())));
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),Driver.browserNames.get()+" başladı", ExcelUtility.getCurrentTime())));


    }

 //@AfterStep
 //public void step(Scenario scenario) {
 //    ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "step", ExcelUtility.getCurrentTime())));

 //}

    @After
    public void afterHook(Scenario scenario) {


        if (scenario.isFailed()) {
            System.out.println("senaryo başarısız  oldu");
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "Başarısız", ExcelUtility.getCurrentTime())));
        } else {
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "Başarılı", ExcelUtility.getCurrentTime())));
            System.out.println("senaryo başarılı");
        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "Bitti", ExcelUtility.getCurrentTime())));

        System.out.println("after hook");
       // Driver.quitDriver();
    }

    @BeforeAll
    public static void beforeAll() {
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("Senaryo Adı", "Durumu", "Tarih")));

    }

    @AfterAll
    public static void afterAll() {
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("Test Bitti", "Bitiş Tarih Saati", ExcelUtility.getCurrentTime())));

    }

}
