package com.auto1.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageWithBurgerMenu extends BasePage{
    public PageWithBurgerMenu(WebDriver driver) {
        super(driver);
    }

    private WebElement burgerMenu=byId("react-burger-menu-btn");
    private WebElement logout = byId("logout_sidebar_link");

    public void logout(){
        burgerMenu.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();

    }
}
