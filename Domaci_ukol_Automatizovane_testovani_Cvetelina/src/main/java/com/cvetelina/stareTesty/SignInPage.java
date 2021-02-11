package com.cvetelina.stareTesty;

import org.openqa.selenium.*;

public class SignInPage {
    WebDriver browser;
    //JavascriptExecutor js = (JavascriptExecutor) browser;

    public SignInPage(WebDriver browser) {
        this.browser = browser;
    }

    public void navigateToSignInPage() {
        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/");
        browser.manage().window().maximize();
    }

    public String signInButton() throws InterruptedException {
        System.out.println("Press the SignIn button.");

        WebElement signInButton = browser.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[7]/ul/li/a"));
        signInButton.click();

        Thread.sleep(2000);

        WebElement emailPole = browser.findElement(By.id("email"));
        emailPole.sendKeys("Eldice@seznam.cz");
        WebElement hesloPole = browser.findElement(By.id("passwd"));
        hesloPole.sendKeys("testy");
        WebElement signInBtn = browser.findElement(By.id("SubmitLogin"));
        signInBtn.click();
        
        String currentUrl = browser.getCurrentUrl();
        return currentUrl;
    }

}
