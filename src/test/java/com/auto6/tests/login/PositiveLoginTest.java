package com.auto6.tests.login;

import com.auto6.helpers.BaseTest;
import com.auto6.helpers.retry.Retry;
import com.auto6.pages.InventoryPage;
import com.auto6.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveLoginTest extends BaseTest {

    @Step("Positive")
//    @Test(retryAnalyzer = Retry.class) -  realized through listener
    @Test
    public void positiveLoginTest() {
//        Assert.fail("failure test");
        LoginPage loginPage = new LoginPage(driver);

        //      Define credentials
        String username = loginPage.getFirstValue(LoginPage.LOGIN);
        String password = loginPage.getFirstValue(LoginPage.PASSWORD);

        //        Login with according credentials
        InventoryPage inventoryPage = loginPage.login(username, password);

        //        Check that user log on
        Assert.assertTrue( driver.getCurrentUrl().contains("inventory"), "User is not log on!");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(inventoryPage.title.isDisplayed(), "Title not found!");

        //        Logout
        inventoryPage.logout();
        softAssert.assertTrue(loginPage.getLoginButton().isDisplayed(),"User still log on!");
        softAssert.assertAll();

    }
}
