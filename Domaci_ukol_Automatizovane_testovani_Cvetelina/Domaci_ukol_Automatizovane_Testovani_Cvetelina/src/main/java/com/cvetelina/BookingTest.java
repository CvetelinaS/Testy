package com.company;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class BookingTest {

    WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Selenium/geckodriver.exe");
        browser = new FirefoxDriver();
    }

    @Test
    public  void Booking() throws InterruptedException {
        BookingPage bookingPage = new BookingPage(browser);
        bookingPage.navigateToBookingPage();
        String currentUrl = bookingPage.clickOnBookBtn();
        ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
        browser.switchTo().window(tabs2.get(1));
        Assert.assertEquals("Uzivatel je presmerovan na spravne strance s produktem.", "http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", currentUrl);
    }

    @After
    public void CleanUp(){

        browser.quit();
    }

}
