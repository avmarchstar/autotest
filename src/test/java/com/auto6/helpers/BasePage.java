package com.auto6.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    protected WebDriver driver;

    protected WebElement byClassName(String className){
        return driver.findElement(By.className(className));

//    protected WebElement byId(String id){
//        return driver.findElement(By.id(id));
//    }
//    protected WebElement byName(String name){
//        return driver.findElement(By.name(name));
//    }
//    protected WebElement byXpath(String xpath){
//        return driver.findElement(By.xpath(xpath));
//    }
//    protected WebElement byCssSelector(String cssSelector){
//        return driver.findElement(By.cssSelector(cssSelector));
//    }


}
}
