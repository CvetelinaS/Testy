package com.maja;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;


public class REQ0029 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Selenium/geckodriver.exe");

        FirefoxDriver firefox = new FirefoxDriver();

        firefox.navigate().to("http://www.czechitas-hackhaton.cz/en/");

        WebElement LanguageButton = firefox.findElement(By.className("current"));
        LanguageButton.click();

        WebElement EnglishChoose = firefox.findElement(By.id("first-languages"));
        EnglishChoose.click();

        Thread.sleep(5000);

        firefox.quit();

    }

}
