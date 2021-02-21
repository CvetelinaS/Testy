package com.company;

import java.util.*;
import org.openqa.selenium.*;

public class PaymentPage {
    WebDriver browser;
    //JavascriptExecutor js = (JavascriptExecutor) browser;

    public PaymentPage(WebDriver browser) {
        this.browser = browser;
    }

    public void navigateToPaymentPage() {
        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        browser.manage().window().maximize();
    }

    public String InputBtn() throws InterruptedException {
        System.out.println("Press the Book button.");

        WebElement bookButton = browser.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[1]/div/div[3]/a"));
        bookButton.click();

        Thread.sleep(2000);

        ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
        browser.switchTo().window(tabs2.get(1));

        String currentUrl = browser.getCurrentUrl();


        WebElement bookButtonOpet = browser.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/form/div[9]/p/button"));
        bookButtonOpet.click();
        return currentUrl;

        //System.out.println("Kliknout na terms and conditions.");

        //WebElement inputBtn = browser.findElement(By.xpath("cgv"));
        //inputBtn.click();

       // Thread.sleep(2000);

        //String currentUrl = browser.getCurrentUrl();
        //return currentUrl;
    }
    
}
