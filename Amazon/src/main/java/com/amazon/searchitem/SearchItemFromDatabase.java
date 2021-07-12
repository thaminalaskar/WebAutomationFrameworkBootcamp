package com.amazon.searchitem;

import common.TestBase;
import databases.ConnectDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchItemFromDatabase extends TestBase {

    private Connection connection = ConnectDB.getConnection("root", "root1234", "peoplentech");
    private ArrayList<Object> listOfNewsItems = ConnectDB.connectToDbAndGetData("select * from searchtest;", "newsSearch");

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton ;

    public SearchItemFromDatabase() throws SQLException {
    }

    public void typeOnSearchBar(String text){
        searchTextBox.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public String searchPageTitle(){
        return  getTitle();
    }
}
