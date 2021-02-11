package com.company;

import java.util.*;
import org.openqa.selenium.*;

public class BookingPage {

    WebDriver browser;
    //JavascriptExecutor js = (JavascriptExecutor) browser;

    public BookingPage(WebDriver browser) {
        this.browser = browser;
    }

    public void navigateToBookingPage() {
        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        browser.manage().window().maximize();
       // js.executeScript("window.scrollBy(0,1000)");
    }

   public String clickOnBookBtn() throws InterruptedException{
       System.out.println("Press the Book button.");

        WebElement bookButton = browser.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div/div[3]/a"));
        bookButton.click();

       Thread.sleep(6000);

       ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
       browser.switchTo().window(tabs2.get(1));

       String currentUrl = browser.getCurrentUrl();
       return currentUrl;

   }

}
