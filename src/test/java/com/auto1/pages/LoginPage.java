package com.auto1.pages;

import com.auto1.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    WebElement loginButton;
    WebElement usernameField;
    WebElement passwordFild;
    String errorXpath = "//h3[@data-test = 'error']";

    public LoginPage(WebDriver driver) {
        super(driver);
        setLoginButton();
        usernameField = byId("user-name");
        passwordFild = byName("password");

    }

    public String getFirstValue(String className) {
        String values = byClassName(className).getText();
        return values.split("\n")[1];
    }

    public WebElement getError() {
        return byXpath(errorXpath);
    }

    public boolean isErrorPresent() {
        try {
            return byXpath(errorXpath).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void setLoginButton(){
        loginButton= byCssSelector("input#login-button");
    }

    public WebElement getErrorButton() {
        return byClassName("error-button");
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void fillUserName(String text) {
        usernameField.sendKeys(text);
    }

    public void fillPassword(String text) {
        passwordFild.sendKeys(text);
    }

}
