package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import databases.ConnectDB;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static String sauceUserName = "";
    public static String sauceKey = "";
    public static String browserStackUserName = "";
    public static String browserStackKey = "";
    //http:// + username + : + key + specific url for cloud
    public static String SAUCE_URL = "http://" + sauceUserName + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub";
    public static String BROWERSTACK_URL = "https://" + browserStackUserName + ":" + browserStackKey + "@hub-cloud.browserstack.com/wd/hub";
    private static Logger LOGGER = Logger.getLogger(TestBase.class);

    /**
     * @param platform       -
     * @param url            -
     * @param browser        -
     * @param cloud          -
     * @param browserVersion -
     * @param envName        -2
     * @return
     * @throws MalformedURLException
     * @Parameters - values are coming from the runner.xml file of the project modules
     */
    @Parameters({"platform", "url", "browser", "cloud", "browserVersion", "envName"})
    // value from the params will be coming from individual module's xml files
    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, String browser,
                                        boolean cloud, String browserVersion, String envName) throws MalformedURLException {
        if (cloud) {
            driver = getCloudDriver(browser, browserVersion, platform, envName);
        } else {
            driver = getLocalDriver(browser, platform);
        }
        driver.get(url);
        return driver;
    }

    /**
     * This method will create WebDriver Objet based on the browser and platform provided
     *
     * @param browser  the browser you want to execute your test case
     * @param platform in the operating system you want to execute your test case
     * @return WebDriver Object
     */
    public static WebDriver getLocalDriver(String browser, String platform) {
        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * @param browser
     * @param browserVersion
     * @param platform
     * @param envName
     * @return
     * @throws MalformedURLException
     */
    public static WebDriver getCloudDriver(String browser, String browserVersion, String platform,
                                           String envName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("os_version", "Catalina");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        desiredCapabilities.setCapability("browser", browser);
        desiredCapabilities.setCapability("browser_version", browserVersion);
        desiredCapabilities.setCapability("os", platform);
        desiredCapabilities.setCapability("name", "Sample Test");
        if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);
        } else if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL(BROWERSTACK_URL), desiredCapabilities);
        }
        return driver;
    }

    /**
     * This method will navigate the browser to provided URL
     *
     * @param url
     */
    public static void navigateToURL(String url) {
        driver.get(url);
        LOGGER.info("navigated to the url : " + url);
    }

    /**
     * This method will wait for X seconds based on the param provided
     *
     * @param seconds
     */
    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will navigate back from the current page to previous page
     */
    public static void navigateBack() {
        driver.navigate().back();
    }

    //screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
        Date date = new Date();
        // --> dateFormat.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + dateFormat.format(date) + ".jpg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public static void clickOnId(String id) {
        driver.findElement(By.id(id)).click();
    }

    /**
     * @param expectedUrl
     */
    public void validateUrlWithExpected(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't match");
        LOGGER.info(expectedUrl + " : url has been validated");
    }

    //reporting starts
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }

    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    //reporting finish

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
        LOGGER.info("driver closed");
    }

    public void typeOnXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }


    /*
    This is drop down Util
     */
    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    public static void selectByIndex(WebElement element, int indexNumber) {
        Select select = new Select(element);
        select.selectByIndex(indexNumber);
    }

    public static List<String> allOptionFromSelectDropDown(WebElement element) {
        Select select = new Select(element);
        List<WebElement> listAllOption = select.getOptions();

        List<String> optionValueList = new ArrayList<String>();

        for (WebElement webElement : listAllOption) {
            String options = webElement.getText();
            optionValueList.add(options);
        }
        return optionValueList;

    }


    public static void selectValueFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> listAllOption = select.getOptions();

        List<String> optionValueList = new ArrayList<String>();

        for (WebElement allOptions : listAllOption) {
            String options = allOptions.getText();
            if (options.equals(text)) {
                allOptions.click();
                break;
            }
        }
    }


    public static boolean multiSelectionDropDown(WebElement locator) {
        Select select = new Select(locator);
        boolean multiSelectionDrop = select.isMultiple();
        return multiSelectionDrop;
    }





    /*
     ***********************************Java Script*********

     */

    public JavascriptExecutor jscript;

    public void windowsFullPageScrollDown() {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void windowsFullPageScrollUp() {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public void windowsFullPageScrollSideBar(WebElement element) {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void windowsPageScrollToLocator(WebElement element) {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void windowTwoThirdPageScroll() {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,950)", "");
    }

    public void windowHalfPageScroll() {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,350)", "");

    }

    public void windowHalfPageScrollUp() {
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,-350)", "");
    }


    //Database
    public ArrayList connectToDataBaseAndGetData(String query, String columnName) throws SQLException {

        Statement statement = ConnectDB.connection.createStatement();
        ResultSet table = statement.executeQuery(query);
        ArrayList<String> dataList = new ArrayList<>();

        String data = "";
        while (table.next()) {
            data = table.getString(columnName);
            dataList.add(data);
        }
        return dataList;
    }


    public String getTitle(){
        return driver.getTitle();
    }

//**************************** Wait Utils ***************************************//

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeLocated(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private WebElement waitForElementToBeVisible(By locator, int timeOut){
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String waitForPageTitlePresent(String titleValue, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleContains(titleValue));
        return driver.getTitle();
    }

    public Alert waitForAlertToBePresent(int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean waitForUrl(String url, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public void clickWhenReady(By locator, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    //**********************Switch to window*******************************
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        driver1.manage().window().maximize();
        return driver1;
    }

    public void closeTheOldWindow() {
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
        driver.close();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }


    public void hoverAndClick(WebDriver driver1, WebElement elementHover, WebElement elementClick) {
        Actions selecrMenu = new Actions(driver1);
        selecrMenu.moveToElement(elementHover).click(elementClick).build().perform();
    }


    public void quiteWindow(){
        driver.quit();
    }

    public static Properties prop ;
    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip =new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void keyBoardEnter(){
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }


}

