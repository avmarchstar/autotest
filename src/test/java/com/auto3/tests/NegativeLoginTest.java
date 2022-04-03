package com.auto3.tests;

import com.auto3.helpers.BaseTest;
import com.auto3.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeLoginTest() {

        String [][] credentials =new String[3][2];
        credentials[0][0] = "locked_out_user";
        credentials[0][1] = "secret_sauce";

        credentials[1][0] = "standard_user";
        credentials[1][1] = "";

        credentials[2][0] = "incorrect";
        credentials[2][1] = "incorrect";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginButton().click();

        //        Check error text
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Wrong error message!");

        loginPage.fillUserName(credentials[0][0]);
        loginPage.fillPassword(credentials[0][1]);
        loginPage.getLoginButton().click();
        softAssert.assertEquals(loginPage.getErrorText(),"Epic sadface: Sorry, this user has been locked out.", "Wrong error message!");


        //        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        loginPage.fillUserName(credentials[1][0]);
        loginPage.fillPassword(credentials[1][1]);
        loginPage.getLoginButton().click();
        softAssert.assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required", "Wrong message for empty password");

        //        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        loginPage.fillUserName(credentials[2][0]);
        loginPage.fillPassword(credentials[2][1]);
        loginPage.getLoginButton().click();
        softAssert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service", "Wrong message for incorrect credentials");

        //        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        softAssert.assertAll();

    }
}
