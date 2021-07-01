package com.cigna.dataprovidertest;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    //For valid user registration Page test data
    @DataProvider(name ="getDataForRegistrationTest")
    public static Object [][] getRegistrationData(){
        return new Object[][]{
                {"Tom@gmail.com","123456"},
                {"Jerry@gmail.com","123456"}
        };
    }

    //For valid user registration Page test data
    @DataProvider(name ="getDataForRegistrationDataForInvalidteUserTest")
    public static Object [][] getRegistrationDataForInvalidteUser(){
        return new Object[][]{
                {"",""},
        };
    }


    //cigna plan data
    @DataProvider(name ="getDataForCignaPlan")
    public static Object [][] cignaPlanData(){
        return new Object[][]{
                {"11779","Tom","Jerry","Tom@gmail.com"},
        };
    }




















}
