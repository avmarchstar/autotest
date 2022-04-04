package com.auto4.pages;

import com.auto4.helpers.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input#login-button")
    WebElement loginButton;
    @FindBy (id = "user-name")
    WebElement usernameField;
    @FindBy(name = "password")
    WebElement passwordFild;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    WebElement error;
    @FindBy(className = "error-button")
    WebElement errorButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstValue(String className) {
        String values = byClassName(className).getText();
        return values.split("\n")[1];
    }

    public boolean isErrorPresent() {
        try {
            return error.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public WebElement getErrorButton() {
        return errorButton;
    }
    public String getErrorText() {
        return error.getText();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void fillUserName(String text) {
        clearInputField(usernameField);
        usernameField.sendKeys(text);
    }

    public void fillPassword(String text) {
        clearInputField(passwordFild);
        passwordFild.sendKeys(text);
    }

    private void clearInputField(WebElement element) {
        int length = element.getAttribute("value").length();

        do {
            element.sendKeys(Keys.BACK_SPACE);
        }while(element.getAttribute("value").length()>0 && element.getAttribute("value").length()<length);

    }

}
