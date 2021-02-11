package com.company1;

import java.sql.*;
import org.omg.CORBA.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Main_40b {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver",
                "C:/Java-Training/Selenium/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");

        WebDriver browser = new FirefoxDriver(options);

        Thread.sleep(2000);

        try {
            browser.navigate().to("http://www.czechitas-hackhaton.cz/en/my-account");
            Thread.sleep(2000);
            WebElement loginmail = browser.findElement(By.id("email"));
            loginmail.sendKeys("lavickova.adela@seznam.cz");
            WebElement password = browser.findElement(By.id("passwd"));
            password.sendKeys("12345");
            WebElement button = browser.findElement(By.id("SubmitLogin"));
            button.click();
            Thread.sleep(2000);
            WebElement Name = browser.findElement(By.id("user_info_acc"));
            Name.click();
            Thread.sleep(2000);
            WebElement viewmyorders = browser.findElement(By.linkText("http://www.czechitas-hackhaton.cz/en/order-history"));
            viewmyorders.click();
            
            //        WebElement mail = browser.findElement(By.id("signin_userName"));

            //      mail.sendKeys("NonExistingCustomer");
            Thread.sleep(1000);


        } catch (Exception ex) {
            // catch blok slouzi ke zpracovani vyjimky, v nasem pripade nechame vyjimku byt
            System.out.println("Bohuzel doslo k chybe. Jedna z poslednich informaci by mel byt: (Main.java:**cislo radku kde chyba vznikla**) ");
            System.out.println(ex);
        } finally {
            // blok finally nam v tomto pripade poslouzi k tomu aby se WebDriver ukoncil spravne za kazdych okolnosti

            browser.quit();
        }
    }
}

