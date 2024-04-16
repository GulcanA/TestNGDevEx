package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;
   protected WebDriverWait wait;

    protected ExtentReports report;

    protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;

    @BeforeTest
    public void setupTest() {
        // initialize the class
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        // initialize the html report to the report object
        htmlReporter = new ExtentHtmlReporter(path);

        // attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Eurotech Smoke Test");

        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Zeynep");
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {

        // if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            // record the name of failed test case
            extentLogger.fail(result.getName());

            // take screenshot and return location of the screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());

            // add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            // capture the exception and put it inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest() {
        // this is when the report is actually created
        report.flush();
    }
}
