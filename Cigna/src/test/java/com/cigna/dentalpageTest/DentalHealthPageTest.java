package com.cigna.dentalpageTest;

import com.cigna.dataprovidertest.DataProviderTest;
import com.cigna.dentalHealthPage.DentalHealthPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class DentalHealthPageTest extends TestBase {

    private static final Logger logger = Logger.getLogger(DentalHealthPageTest.class);
    DentalHealthPage dentalHealthPage;


    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForCignaPlan")
    public void dentalPageTest(String zip,String firstName, String lastName,String email){
        dentalHealthPage = PageFactory.initElements(driver,DentalHealthPage.class);
        dentalHealthPage.dentalHealthPage(zip,firstName,lastName,email);
        sleepFor(1);
        ExtentTestManager.log("User fillup from successfully",logger);
        String expectedTitle = dentalHealthPage.titleOfDentalHealthPage();
        String actualTitle ="Quote and Apply - Online Quoting & Enrollment System";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");

    }






}
