package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LikeAnyPost {
    @FindBy(xpath = "(//div[@class='tvfksri0 ozuftl9m']/div/div)[1]")
    private WebElement likeButton;


    @FindBy(xpath = "(//span[@class='gpro0wi8 cwj9ozl2 bzsjyuwj ja2t1vim']/span)[1]")
    WebElement totalLike;


  public boolean likeOnPost(){
      likeButton.click();
      return totalLike.isDisplayed();

  }


}
