package com.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebElement loginButton;
    WebElement usernameField;
    WebElement passwordFild;
    WebDriver driver;
    String errorXpath = "//h3[@data-test = 'error']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginButton = driver.findElement(By.xpath("//div[@class='login-box']//input[@data-test = 'login-button']"));
        usernameField = driver.findElement(By.id("user-name"));
        passwordFild = driver.findElement(By.name("password"));

    }

    public String getFirstValue(String className) {
        String values = driver.findElement(By.className(className)).getText();
        return values.split("\n")[1];
    }

    public WebElement getError() {
        return driver.findElement(By.xpath(errorXpath));
    }

    public boolean isErrorPresent() {
        try {
            return driver.findElement(By.xpath(errorXpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public WebElement getErrorButton() {
        return driver.findElement(By.className("error-button"));
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
