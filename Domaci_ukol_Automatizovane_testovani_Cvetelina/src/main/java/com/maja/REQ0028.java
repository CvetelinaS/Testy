package com.maja;

import org.openqa.selenium.firefox.*;

public class REQ0028 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Selenium/geckodriver.exe");

        FirefoxDriver firefox = new FirefoxDriver();

        firefox.navigate().to("http://www.czechitas-hackhaton.cz/en/");

        Thread.sleep(5000);

        firefox.quit();
    }

}
