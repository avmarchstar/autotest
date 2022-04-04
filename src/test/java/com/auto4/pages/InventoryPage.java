package com.auto4.pages;

import com.auto4.helpers.PageWithBurgerMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends PageWithBurgerMenu {

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "title")
   public WebElement title;
}