package com.auto1.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected BasePage(WebDriver driver){
        this.driver=driver;
    }
    protected WebDriver driver;

    protected WebElement byId(String id){
        return driver.findElement(By.id(id));
    }
    protected WebElement byName(String name){
        return driver.findElement(By.name(name));
    }
    protected WebElement byClassName(String className){
        return driver.findElement(By.className(className));
    }
    protected WebElement byXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    protected WebElement byCssSelector(String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }


}
