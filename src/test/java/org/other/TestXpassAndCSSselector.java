package org.other;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;

public class TestXpassAndCSSselector {
    WebDriver driver;

    public static void timecalculator(WebDriver driver, int num) {

        long timeBefor;
        long timeAfter;
        long time;
        By by;

        String fmethod;
        LinkedList<WebElement> list = new LinkedList<>();
        String path;

        if (num == 1) {
            fmethod = "Xpath";
            path = "//*[@id=\"page-content\"]/section[1]/div/div[2]/div/div[2]/div/a/div/picture/img";
            by = By.xpath(path);
        } else if (num == 2) {
            fmethod = "CssSelector";
            path = "#page-content > section.products-opener.glue-page.glue-mod-spacer-5-top.glue-mod-spacer-6-bottom > div > div.products-opener--highlights.glue-grid__col.glue-grid__col--span-4-sm.glue-grid__col--span-6-md.glue-grid__col--span-6-lg.glue-grid__col--align-middle > div > div.products-opener--tile.glue-grid__col.glue-grid__col--span-2-sm.glue-grid__col--span-3-md.glue-grid__col--span-3-lg > div > a > div > picture > img";
            by = By.cssSelector(path);
        } else {
            fmethod = "";
            by = By.id("1");
        }
        timeBefor = System.currentTimeMillis();
        for (int i = 0; i < 3000; i++) {
            list.add(driver.findElement(by));
        }
        timeAfter = System.currentTimeMillis();
        time = timeAfter - timeBefor;
        System.out.println(fmethod + " " + time);

    }


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://about.google/products/");




                timecalculator(driver, 1);

                timecalculator(driver, 2);


        driver.quit();

    }
}
