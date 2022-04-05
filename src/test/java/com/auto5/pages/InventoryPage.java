package com.auto5.pages;

import com.auto5.helpers.PageWithBurgerMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends PageWithBurgerMenu {

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(className = "inventory_item")
    public List<WebElement> items;

    @FindBy(className = "product_sort_container")
    private WebElement selector;

    public void selecItem (WebElement item){
    item.findElement(By.tagName("button")).click();
    }

    public String getPrice(WebElement item){
        return item.findElement(By.className("inventory_item_price")).getText().replace("$","");
    }

    public Select getSelect(){
        return new Select(selector);
    }
}
