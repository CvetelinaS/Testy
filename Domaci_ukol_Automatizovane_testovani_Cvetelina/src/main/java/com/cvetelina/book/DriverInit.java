package com.cvetelina.book;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class DriverInit {

    WebDriver driver = new ChromeDriver();
    String url;

    public DriverInit( String url) {
        this.url = url;
    }

    public void initializeDriver(String url){
        System.setProperty("webdriver.chrome.driver", "C:/Users/David/Downloads/chromedriver_win32/chromedriver.exe");
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
}