package com.cvetelina.book.tools;

import java.util.*;
import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class Chapter2Page {
    private static WebDriver driver;

    @BeforeClass
    public void beforeClassSetup() {
        driver = initializeDriver();
        goToHomePage(driver);

        WebElement chapter1Link = driver.findElement(By.linkText("Chapter2"));
        chapter1Link.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, UrlsToChapters.URL_CHAPTER2);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
