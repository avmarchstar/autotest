package com.auto.tests;

import com.auto.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FistTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

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
        Assert.assertTrue( driver.getCurrentUrl().contains("inventory"), "User is not log on!");
    }
}
