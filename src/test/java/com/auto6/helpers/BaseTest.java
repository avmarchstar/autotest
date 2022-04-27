package com.auto6.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
//    private long defaultTimeout = 5;
    @Step("before")
    @BeforeMethod
    public void setUp() throws IOException {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
        PropertyConfigurator.configure("src/test/resources/properties/allure.properties");
//        Properties props = new Properties();
//        props.load(new FileInputStream("src/test/resources/properties/log4j.properties"));
//        PropertyConfigurator.configure(props);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeout));
        driver.get("https://saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Step("After")
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
