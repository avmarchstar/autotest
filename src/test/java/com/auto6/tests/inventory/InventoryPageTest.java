package com.auto6.tests.inventory;

import com.auto6.helpers.BaseTest;
import com.auto6.pages.InventoryPage;
import com.auto6.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    InventoryPage inventoryPage;

    @Test (dependsOnMethods = "com.auto6.tests.login.PositiveLoginTest.positiveLoginTest")
    public void inventoryTest(){
        LoginPage loginPage = new LoginPage(driver);

        inventoryPage = loginPage.login(
                loginPage.getFirstValue(LoginPage.LOGIN),
                loginPage.getFirstValue(LoginPage.PASSWORD));

//        the Third item on inventory page
        WebElement item = getItem(2);
        inventoryPage.selecItem(item);
        System.out.println(item.getText());
        inventoryPage.getSelect().selectByValue("za");
        item = getItem(2);
        inventoryPage.selecItem(item);
        System.out.println(item.getText());
    }

    private WebElement getItem(int itemIndex){

        if(inventoryPage.items.size()>itemIndex){
            return inventoryPage.items.get(itemIndex);
        }else Assert.fail("Index of element bigger than bound of array");

        return null;
    }

}
