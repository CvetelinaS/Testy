package com.cvetelina.stareTesty;

import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class BookingTest {

    WebDriver browser;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver",
                //"C:/Users/David/Downloads/Domaci_ukol_Automatizovane_Testovani_Cvetelina/Domaci_ukol_Automatizovane_Testovani_Cvetelina/geckpdriver.exe");
        //browser = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/David/Downloads/chromedriver_win32/chromedriver.exe");

        browser = new ChromeDriver();
    }

    @Test
    public  void booking() throws InterruptedException {
        BookingPage bookingPage = new BookingPage(browser);
        bookingPage.navigateToBookingPage();
        String currentUrl = bookingPage.clickOnBookBtn();
        ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
        browser.switchTo().window(tabs2.get(1));
        Assert.assertEquals("Uzivatel je presmerovan na spravne strance s produktem.", "http://www.czechitas-hackhaton.cz/en/home/4-super-delux-rooms.html", currentUrl);
    }

    @After
    public void cleanUp(){

        browser.quit();
    }

}
