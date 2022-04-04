package com.auto4.tests;

import com.auto4.helpers.BaseTest;
import com.auto4.pages.InventoryPage;
import com.auto4.pages.LoginPage;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        //      Define credentials
        String username = loginPage.getFirstValue("login_credentials");
        String password = loginPage.getFirstValue("login_password");

        //        Login with according credentials
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.getLoginButton().click();

        //        Check that user log on
        Assert.assertTrue("User is not log on!", driver.getCurrentUrl().contains("inventory"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inventoryPage.title.isDisplayed(), "Title not found!");

        //        Logout
        inventoryPage.logout();
        softAssert.assertTrue(loginPage.getLoginButton().isDisplayed(),"User still log on!");
        softAssert.assertAll();

    }
}
