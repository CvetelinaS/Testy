package com.cvetelina.book.tools;


import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class Chapter2Page {

    private static WebDriver driver;
    private static final String DIRECTIONS_ITEM_TEXT = "This item div has the id of find\n" +
            "put find into the target of Selenium IDE\n" +
            "and click the find button";
    private static final String CHANGING_ID_TEXT = "This element has a ID that changes every time the page is loaded";

    @BeforeClass
    public void beforeClassSetup() {
        driver = initializeDriver();
        goToHomePage(driver);

        WebElement chapter2Link = driver.findElement(By.linkText("Chapter2"));
        chapter2Link.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, UrlsToChapters.URL_CHAPTER2);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void findAndClickIndexTest() {
        String expectedUrlToHome = "http://book.theautomatedtester.co.uk/";
        WebElement indexLink = driver.findElement(By.linkText("Index"));
        indexLink.click();
        String redirectURL = driver.getCurrentUrl();
        Assert.assertEquals(redirectURL, expectedUrlToHome);

        driver.navigate().back();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, UrlsToChapters.URL_CHAPTER2);
    }

    @Test
    public void itemWithDirectionsTest() {
        WebElement itemDivFind = driver.findElement(By.id("find"));
        System.out.println("Actual text is:" + itemDivFind.getText());
        Assert.assertEquals(DIRECTIONS_ITEM_TEXT, itemDivFind.getText());
    }

    @Test
    public void btnWithNameTest() {
        WebElement btnThatComesFirst = driver.findElement(By.cssSelector("input[name*='but2']"));
        String actualText = btnThatComesFirst.getAttribute("value");
        Assert.assertEquals("Button with name", actualText);
    }

    @Test
    public void randomBtnTest() {
        WebElement btnThatComesSecond = driver.findElement(By.id("random"));
        String actualText = btnThatComesSecond.getAttribute("value");
        Assert.assertEquals("Random", actualText);
    }

    @Test
    public void chngIdDivTest() {
        WebElement divText = driver.findElement(By.xpath("//*[@id='divinthecenter']//following-sibling::div"));
        String actualText = divText.getText();
        Assert.assertEquals(CHANGING_ID_TEXT, actualText);
    }

    @Test
    public void btnWithIdTest() {
        WebElement firstBtnInTheMiddle = driver.findElement(By.id("but1"));
        String actualText = firstBtnInTheMiddle.getAttribute("value");
        Assert.assertEquals("Button with ID", actualText);
    }

    @Test
    public void siblingToBtnWithIdTest() {
        WebElement siblingBtn = driver.findElement(By.xpath("//*[@id='but1']//following-sibling::input"));
        String actualText = siblingBtn.getAttribute("value");
        Assert.assertEquals("Sibling Button", actualText);
    }
}
