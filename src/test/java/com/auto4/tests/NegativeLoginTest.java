package com.auto4.tests;

import com.auto4.helpers.BaseTest;
import com.auto4.helpers.DP;
import com.auto4.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLoginTest extends BaseTest {


    @Test(dataProvider = "p_credentials", dataProviderClass = DP.class)
    public void negativeLoginTest(String username, String password, String expectedError) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.getLoginButton().click();

        //        Check error text
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getErrorText(), expectedError, "Wrong error message!");

        //        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        softAssert.assertAll();

    }
}
