package Utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    private static ExtentReports extent;
    //Cada hilo de ejecución tendrá su propio ExtentTest
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    // Crear y configurar el reporte
    public static synchronized ExtentReports createReport() {
    	String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss"));
        String reportPath = System.getProperty("user.dir") + File.separator + "extent-reports" + File.separator + "ExtentReport_" + timeStamp + ".html";
        File reportDir = new File(System.getProperty("user.dir") + File.separator + "extent-reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Test Results");
        spark.config().setEncoding("utf-8");
        spark.config().setReportName("Automation Test Results");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Organization", "Name Company");
        extent.setSystemInfo("Project", "Name Project");
        extent.setSystemInfo("Tester", "Una tipa");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
        extent.setSystemInfo("Framework", "Selenium + Maven + TestNG + Extent Reports");
        return extent;
    }
    
    public static synchronized ExtentReports getReport() {
        if (extent == null) {
            createReport();
        }
        return extent;
    }
    
    //Crear un test y asignarlo al hilo actual
    public static synchronized void createTest(String testName, String description) {
        ExtentTest extentTest = getReport().createTest(testName, description);
        test.set(extentTest);
    }

    //Obtener el test del hilo actual
    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    // Limpiar el test del hilo al terminar
    public static synchronized void removeTest() {
        test.remove();
    }
}



