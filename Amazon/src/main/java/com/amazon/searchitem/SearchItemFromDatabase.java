package com.amazon.searchitem;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemFromDatabase extends TestBase {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton ;

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
