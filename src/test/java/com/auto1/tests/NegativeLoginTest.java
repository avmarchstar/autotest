package com.auto1.tests;

import com.auto1.helpers.BaseTest;
import com.auto1.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginButton().click();

//        Check error text
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getError().getText(), "Epic sadface: Username is required", "Wrong error message!");

//        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        softAssert.assertAll();

    }
}
