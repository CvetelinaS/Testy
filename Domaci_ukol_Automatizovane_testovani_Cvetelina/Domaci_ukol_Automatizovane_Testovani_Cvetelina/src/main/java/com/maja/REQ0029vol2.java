package com.company;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class REQ0029vol2 {

    public static void main(String[] args) throws InterruptedException {

            final String setProperty = System.setProperty("webdriver.gecko.driver",
                    "C:/Java-Training/Hackathon3/geckodriver.exe");

            FirefoxDriver firefox = new FirefoxDriver();

            firefox.navigate().to("http://www.czechitas-hackhaton.cz/en/");

            WebElement LanguageButton = firefox.findElement(By.className("current"));
            LanguageButton.click();

            WebElement CzechChoose = firefox.findElement(By.linkText("http://www.czechitas-hackhaton.cz/cz/"));
            CzechChoose.click();

            Thread.sleep(5000);

            firefox.quit();

        }

    }


