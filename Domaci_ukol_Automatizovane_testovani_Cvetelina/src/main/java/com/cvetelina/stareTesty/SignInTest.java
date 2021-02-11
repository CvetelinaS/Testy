package com.cvetelina.stareTesty;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class SignInTest {

    WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/David/Downloads/chromedriver_win32/chromedriver.exe");
        browser = new ChromeDriver();
    }

    @Test
    public  void SignIn() throws InterruptedException {
        SignInPage SignInPage = new SignInPage(browser);
        SignInPage.navigateToSignInPage();
        //SignInPage.signInButton();
        String currentUrl = SignInPage.signInButton();
        //ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
        //browser.switchTo().window(tabs2.get(1));
        Assert.assertEquals("Uzivatel je prihlasen.", "http://www.czechitas-hackhaton.cz/en/my-account", currentUrl);


    }

    @After
    public void CleanUp(){

        browser.quit();
    }

}
