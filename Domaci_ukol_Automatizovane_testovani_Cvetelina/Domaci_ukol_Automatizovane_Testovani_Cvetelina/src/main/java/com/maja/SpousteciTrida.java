package com.company;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class SpousteciTrida {
    

    public static void main(String[] args) throws InterruptedException {

        final String setProperty = System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Hackathon3/geckodriver.exe");

        FirefoxDriver firefox = new FirefoxDriver();

        firefox.navigate().to("http://www.czechitas-hackhaton.cz/languageSelected.");

        WebElement OkButton = firefox.findElement(By.name("Submit"));
        OkButton.click();

        Thread.sleep(5000);
        

        firefox.quit();

    }
}