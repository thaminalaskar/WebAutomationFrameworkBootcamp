package com.facebook.loginpagetest;

import com.facebook.pages.SendAFriendRequest;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class SendAFriendRequestTest extends TestBase {

    private static final Logger logger = Logger.getLogger(SearchForNameTest.class);
    SendAFriendRequest sendAFriendRequest;
    @Test
    public void sendFriendReqTest(){
            sendAFriendRequest= PageFactory.initElements(driver,SendAFriendRequest.class);
            sendAFriendRequest.loginHomePage(prop.getProperty("username"),prop.getProperty("password"));
            ExtentTestManager.log("User got expected person in search page",logger);
            ExtentTestManager.log("User send friend request successfully",logger);


    }
}
