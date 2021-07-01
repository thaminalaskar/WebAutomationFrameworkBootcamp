package com.citybank.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    //cityBank data
    @DataProvider(name ="getDataForCitybankCredential")
    public static Object [][] cignaPlanData(){
        return new Object[][]{
                {"18745","Tom12354"},
        };
    }




















}
