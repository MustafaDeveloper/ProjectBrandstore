package utils;

import io.cucumber.java.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Hook1 {

    public static String path = "src/test/java/Logs/log1.xlsx";
    public static String sheetName = "logSayfasi1";

    @Before
    public void beforeHook(Scenario scenario) {
        Driver.getDriver();
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "begin", ExcelUtility.getCurrentTime())));
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(),Driver.browserNames.get()+" begin", ExcelUtility.getCurrentTime())));


    }

 //@AfterStep
 //public void step(Scenario scenario) {
 //    ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "step", ExcelUtility.getCurrentTime())));

 //}

    @After
    public void afterHook(Scenario scenario) {


        if (scenario.isFailed()) {
            System.out.println("scenario fail!");
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "fail!", ExcelUtility.getCurrentTime())));
        } else {
            ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "work!", ExcelUtility.getCurrentTime())));
            System.out.println("scenario is successfully!");
        }
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList(scenario.getName(), "work done!", ExcelUtility.getCurrentTime())));

        System.out.println("after hook");
       // Driver.quitDriver();
    }

    @BeforeAll
    public static void beforeAll() {
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("Scenario name", "Status", "Date")));

    }

    @AfterAll
    public static void afterAll() {
        Driver.getDriver().close();
        ExcelUtility.writeToExcel(new ArrayList<>(Arrays.asList("Test done", "End Date Time", ExcelUtility.getCurrentTime())));

    }

}
