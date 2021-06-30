package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentReports extentUpdate = ExtentManager.getInstance();
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    public static synchronized void endTest() {
        extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }
    public static synchronized ExtentTest startTestClass(String className,String testName) {
        return startTest(className,testName, "");
    }
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    public static synchronized ExtentTest startTest(String className,String testName, String desc) {
        ExtentTest test = extentUpdate.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    //logging to report
    public static void log(String message, Logger logger) {
        Reporter.log(message + "<br>", false);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
        logger.info(message);
    }


}
