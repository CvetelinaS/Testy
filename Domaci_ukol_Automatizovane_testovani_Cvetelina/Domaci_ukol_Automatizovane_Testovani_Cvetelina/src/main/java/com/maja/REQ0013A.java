package com.company;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;


public class REQ0013A {

    public static void main(String[] args) throws InterruptedException {

        final String setProperty = System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Hackathon3/geckodriver.exe");

        FirefoxDriver firefox = new FirefoxDriver();

        firefox.navigate().to("http://www.czechitas-hackhaton.cz/en/quick-order");

        WebElement ProceedButton = firefox.findElement(By.className("btn btn-default button button-medium pull-right"));
        ProceedButton.click();

        Thread.sleep(2000);

        firefox.quit();

    }
}