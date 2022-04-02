package com.auto1.pages;

import com.auto1.helpers.PageWithBurgerMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends PageWithBurgerMenu {

    public InventoryPage(WebDriver driver){
        super(driver);
    }

   public WebElement title = byClassName("title");
}
