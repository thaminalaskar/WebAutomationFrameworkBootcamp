package com.facebook.dataprovidertest;

import org.testng.annotations.DataProvider;

public class DataProviderTest {


    //For valid user registration Page test data
    @DataProvider(name ="getDataForRegistrationTest")
    public static Object [][] getRegistrationData(){
        return new Object[][]{
                {"tom","khan","123456","123456"},
                {"Jerry","Jerry@gmail.com","123456","123456"}
        };
    }


}
