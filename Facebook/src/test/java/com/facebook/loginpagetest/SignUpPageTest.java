package com.facebook.loginpagetest;

import com.facebook.dataprovidertest.DataProviderTest;
import com.facebook.pages.SignUpPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class SignUpPageTest extends TestBase {
    private static final Logger logger = Logger.getLogger(com.facebook.loginpagetest.SignUpPageTest.class);
    private SignUpPage signUpPage;

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest")
    public void validateUserCanSignup(String firstName, String lastName , String mobileNumber , String newPassword, String month){
        signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        windowsFullPageScrollDown();
        signUpPage.clickOnSignUpLinks();
        signUpPage.enterFirstName(firstName);
        ExtentTestManager.log(firstName+" Enter in text field",logger);
        signUpPage.enterLastName(lastName);
        ExtentTestManager.log(lastName+" Enter in text field",logger);
        signUpPage.enterMobileNumber(mobileNumber);
        ExtentTestManager.log(mobileNumber+" Enter in text field",logger);
        signUpPage.enterNewPassword(newPassword);
        ExtentTestManager.log(newPassword+"password entered in text field",logger);
        signUpPage.selectMonthFromTheDropDown(month);
        ExtentTestManager.log("User change month",logger);
        signUpPage.selectDayFromTheDropDown();
        ExtentTestManager.log("User change day",logger);
        signUpPage.selectYearFromDropDown();
        ExtentTestManager.log("User change year",logger);
        signUpPage.genderSelectForFemale();
        ExtentTestManager.log("User change as female",logger);
        signUpPage.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.signUpButtonDisplay());
        Assert.assertTrue(signUpPage.createAccountText());
        String expectedTitle = signUpPage.signUpPageTitle();
        String actualTitle = "Sign Up for Facebook | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User got title as expected",logger);
        sleepFor(5);
    }

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest")
    public void createAccountPageforValidteUserTest(String firstName, String lastName , String mobileNumber , String newPassword, String month){
         signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        windowsFullPageScrollDown();
        signUpPage.clickOnSignUpLinks();
        signUpPage.enterFirstName(firstName);
        ExtentTestManager.log(firstName+" Enter in text field",logger);
        signUpPage.enterLastName(lastName);
        ExtentTestManager.log(lastName+" Enter in text field",logger);
        signUpPage.enterMobileNumber(mobileNumber);
        ExtentTestManager.log(mobileNumber+" Enter in text field",logger);
        signUpPage.enterNewPassword(newPassword);
        ExtentTestManager.log(newPassword+" Enter in text field",logger);
        signUpPage.selectMonthFromTheDropDown(month);
        ExtentTestManager.log("User change month",logger);
        signUpPage.selectDayFromTheDropDown();
        ExtentTestManager.log("User change day",logger);
        signUpPage.selectYearFromDropDown();
        ExtentTestManager.log("User change year",logger);
        signUpPage.genderSelectForMale();
        ExtentTestManager.log("User change as male",logger);
        signUpPage.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.signUpButtonDisplay());
        Assert.assertTrue(signUpPage.createAccountText());
        String expectedTitle = signUpPage.signUpPageTitle();
        String actualTitle = "Sign Up for Facebook | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User got title as expected",logger);
        sleepFor(5);
    }

}
