package com.amazon.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    //For searchBox test data
    @DataProvider(name ="getDataForSearchTest")
    public static Object [][] getSearchData(){
        return new Object[][]{
                {"Laptop"}
        };
    }

    //For searchBox test data
    @DataProvider(name ="getDataForSearchTestAndAddToCart")
    public static Object [][] getSearchDataAndAddToCart(){
        return new Object[][]{
                {"Laptop"},
        };
    }


    //For valid user registration Page test data
    @DataProvider(name ="getDataForRegistrationTest")
    public static Object [][] getRegistrationData(){
        return new Object[][]{
                {"tom","Tom@gmail.com","123456","123456"},
                {"Jerry","Jerry@gmail.com","123456","123456"}
        };
    }

    //For registration Page invalidate test data
    @DataProvider(name ="getInvalidateDataForRegistrationTest")
    public static Object [][] getRegistrationInvalidateData(){
        return new Object[][]{
                {"123","520","qamai","*****"}
        };
    }
}
