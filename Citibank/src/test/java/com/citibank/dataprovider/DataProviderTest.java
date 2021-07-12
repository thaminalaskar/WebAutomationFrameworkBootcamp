package com.citibank.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    //cityBank data
    @DataProvider(name ="getDataForCitibankCredential")
    public static Object [][] CitibankPlanData(){
        return new Object[][]{
                {"18745","Tom12354"},
        };
    }




















}
