package com.amazon.registrationtest;


import com.amazon.dataprovidertest.DataProviderTest;
import com.amazon.registrationpage.RegistrationPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class RegistrationTest extends TestBase {
    private static final Logger logger = Logger.getLogger(RegistrationTest.class);
    RegistrationPage registrationPage;


    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest",enabled = true,priority = 1)
    public void validateUserCanRegisterAccountTest(String name , String email , String password , String reEnterPass){
        registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.clickOnSignInButton();
        registrationPage.clickOnAmazonAccountlink();
        registrationPage.UserName(name);
        ExtentTestManager.log(name+" Enter successfully",logger);
        registrationPage.UserEmail(email);
        ExtentTestManager.log(email+" Enter successfully",logger);
        registrationPage.UserPass(password);
        ExtentTestManager.log(password+" Enter successfully",logger);
        registrationPage.UserReEnterPass(reEnterPass);
        ExtentTestManager.log(reEnterPass+" Enter successfully",logger);
        registrationPage.clickOnAccountButton();
        ExtentTestManager.log("User successfully create account",logger);
        sleepFor(5);
    }

    @Test(enabled = false,priority = 2)
    public void validateCreateAccountText(){
         registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.clickOnAccountButton();
        registrationPage.clickOnAmazonAccountlink();
        String expectedText = registrationPage.createAccountText();
        String actualText = "Create account";
        Assert.assertEquals(expectedText,actualText,"Text did not match");
        ExtentTestManager.log("Create account Page text find properly",logger);
    }

    @Test(enabled = false,priority = 3)
    public void validateCreateAccountPageWithProperErrorMessageTest(){
        registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.clickOnSignInButton();
        registrationPage.clickOnAmazonAccountlink();
        String expectedText = registrationPage.createAccountText();
        registrationPage.clickOnAccountButton();

        sleepFor(1);
        String errorMessageForName ="Enter your name";
        String actualTextForName = registrationPage.errorMessageForName();
        Assert.assertEquals(errorMessageForName,actualTextForName,"Text did not appear");
        ExtentTestManager.log("User find error message for name field",logger);

        String errorMessageForEmail ="Enter your email";
        String actualTextForEmail = registrationPage.errorMessageForEmail();
        Assert.assertEquals(errorMessageForName,actualTextForName,"Text did not appear");
        ExtentTestManager.log("User find error message for email field",logger);

        String errorMessageForPassword ="Enter your password";
        String actualTextForPassword = registrationPage.errorMessageForPassword();
        Assert.assertEquals(errorMessageForName,actualTextForName,"Text did not appear");
        ExtentTestManager.log("User find error message for name password",logger);

    }

    //Negative Test Case
    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getInvalidateDataForRegistrationTest",enabled = false,priority = 4)
    public void UserWriteWrongDataInCreateAccountPageTest(String name , String email , String password , String reEnterPass){
        registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
        registrationPage.clickOnSignInButton();
        registrationPage.clickOnAmazonAccountlink();
        registrationPage.UserName(name);
        ExtentTestManager.log(name+" Enter successfully",logger);
        registrationPage.UserEmail(email);
        ExtentTestManager.log(email+" Enter successfully",logger);
        registrationPage.UserPass(password);
        ExtentTestManager.log(password+" Enter successfully",logger);
        registrationPage.UserReEnterPass(reEnterPass);
        ExtentTestManager.log(reEnterPass+" Enter successfully",logger);
        registrationPage.clickOnSignInButton();
        ExtentTestManager.log("User can not create account to provide wrong data",logger);
        sleepFor(5);
    }





}
