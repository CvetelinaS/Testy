package com.company;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class PaymentTest {
    WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Selenium/geckodriver.exe");
        browser = new FirefoxDriver();
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
