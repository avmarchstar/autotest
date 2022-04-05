package com.auto5.pages;

import com.auto5.helpers.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   public final static String LOGIN = "login_credentials";
   public final static String PASSWORD = "login_password";



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

    Logger log = Logger.getLogger(this.getClass());

    public LoginPage(WebDriver driver) {
        super(driver);
        log.info("Set up login page.");
    }

    public String getFirstValue(String className) {
        log.info("Get value from "+className);
        String values = byClassName(className).getText();
        String value = values.split("\n")[1];
        log.info("first value = "+value);

        return value;
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

    public InventoryPage login(String username, String password){
        log.info("Login with username: "+username+" password: "+password);
        clearInputField(usernameField);
        usernameField.sendKeys(username);
        clearInputField(passwordFild);
        passwordFild.sendKeys(password);
        loginButton.click();

        return new InventoryPage(driver);
    }

    private void clearInputField(WebElement element) {
        int length = element.getAttribute("value").length();

        do {
            element.sendKeys(Keys.BACK_SPACE);
        }while(element.getAttribute("value").length()>0 && element.getAttribute("value").length()<length);

    }

}
