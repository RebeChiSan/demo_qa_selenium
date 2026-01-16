package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import Utilities.DriverFactory;
import Utilities.ExtentManager;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://demoqa.com/";

    private String takeScreenshot(String testName) {
        if (driver == null) {
            ExtentManager.getTest().warning("Cannot take screenshot: driver is null");
            return null;
        }
        try {
            String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String screenshotPath = screenshotDir + File.separator + testName + "_" + System.currentTimeMillis() + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            ExtentManager.getTest().warning("No se pudo guardar la captura: " + e.getMessage());
            return null;
        }
    }

    @BeforeSuite
    public void setUpSuite() {
        ExtentManager.getReport();
        System.out.println("=== Test Suite Started ===");
    }

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(Method method, @Optional("chrome") String browser, @Optional("true") boolean headless) {
        Test testAnno = method.getAnnotation(Test.class);
        String description = testAnno.description();
        ExtentManager.createTest(method.getName(), description);
        try {
            driver = DriverFactory.createDriver(browser, headless);
            ExtentManager.getTest().info("WebDriver initialized: " + browser);
        } catch (Exception e) {
            ExtentManager.getTest().fail("Error initializing WebDriver: " + e.getMessage());
            throw e;
        }
        driver.get(baseUrl);
        ExtentManager.getTest().info("Navigating to: " + baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = takeScreenshot(result.getName());
                ExtentManager.getTest().fail("Failed test case: " + result.getName());
                if (screenshotPath != null) {
                    ExtentManager.getTest().fail("Cause of failure: " + result.getThrowable())
                            .addScreenCaptureFromPath(screenshotPath);
                } else {
                    ExtentManager.getTest().fail("Cause: " + result.getThrowable());
                }
            } else if (result.getStatus() == ITestResult.SKIP) {
                ExtentManager.getTest().info("Test case omitted: " + result.getName());
            } else {
                ExtentManager.getTest().pass("Successful Test case: " + result.getName());
            }
        } catch (Exception e) {
            System.err.println("Error en la lógica de reportes: " + e.getMessage());
        } finally {
            ExtentManager.removeTest();
            if (driver != null) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    System.err.println("Error closing driver: " + e.getMessage());
                }finally {
                    driver = null;
                }
            }
        }
    }


    @AfterSuite
    public void tearDownSuite() {
        try {
            if (ExtentManager.getReport() != null) {
                ExtentManager.getReport().flush();
                String reportPath = System.getProperty("user.dir") + File.separator
                        + "reports" + File.separator + "ExtentReport.html";
                System.out.println("=== Test Suite Completed ===");
                System.out.println("Report generated at: " + reportPath);
            }
        } catch (Exception e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
}