package com.auto6.tests.login;

import com.auto6.helpers.BaseTest;
import com.auto6.helpers.DP;
import com.auto6.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLoginTest extends BaseTest {

    @Step("Negative")
    @Test(dataProvider = "p_credentials", dataProviderClass = DP.class)
    public void negativeLoginTest(String username, String password, String expectedError) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);


        //        Check error text
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getErrorText(), expectedError, "Wrong error message!");

        //        Check that error is not displaying
        loginPage.getErrorButton().click();
        softAssert.assertFalse(loginPage.isErrorPresent(), "Error still displayed");

        softAssert.assertAll();

    }
}
