package com.cvetelina.stareTesty;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class PaymentTest {
    WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/David/Downloads/chromedriver_win32/chromedriver.exe");
        browser = new ChromeDriver();
    }

    @Test
    public void Pay() throws InterruptedException {
        PaymentPage paymentPage = new PaymentPage(browser);
        paymentPage.navigateToPaymentPage();
        String currentUrl = paymentPage.InputBtn();
        ArrayList<String> tabs2 = new ArrayList<String>(browser.getWindowHandles());
        browser.switchTo().window(tabs2.get(1));
        //Assert.assertEquals("Uzivatel je presmerovan.", "http://www.czechitas-hackhaton.cz/en/home/3-super-delux-rooms.html", currentUrl);


    }

    @After
    public void CleanUp(){

        browser.quit();
    }

}
