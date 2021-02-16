package com.cvetelina.book;

import java.util.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class HomePage {

  private static WebDriver driver;
  public static final String UL_XPATH = "//*[contains(@class,'mainbody')]/ul//li";
  /**
   * Pridal jsem do POM TestNg anotace. Takze misto jUnit budeme pouzivat TestNg. To nam dava moznost pouzivat i Asserty atp. Je to obdoba jUnit.
   * Tato metoda udela to, ze nainicializuje chrome driver a vstoupi na domovskou stranku. Presne nejak takto muze vypadat setup testu co napises testu.
   */
  @BeforeClass
  public void beforeClassSetup() {
    driver = initializeDriver();
    goToHomePage(driver);
  }

  @Test
  public void displayInputTest() {
      WebElement inputField = driver.findElement(By.id("q"));
      Assert.assertEquals(true, inputField.isDisplayed());
      inputField.sendKeys("Cvetelina");
  }

  @Test
  public void findUrlsTest() {
      List<String> expectedNames = Arrays.asList("Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter8");
        System.out.println(expectedNames);
        //*[contains(@id,'59')]/ul//li
      List<WebElement> liElements = driver.findElements(By.xpath(UL_XPATH));
        for (int i = 0; i < expectedNames.size(); i++) {
        Assert.assertEquals(liElements.get(i).getText(), expectedNames.get(i));
    }
  }

  @Test
  public void displayHeadingTest(){
      String expectedHeading = "Selenium: Beginners Guide";
      String actualHeading = driver.getTitle();
      WebElement heading = driver.findElement(By.className("mainheading"));
      Assert.assertEquals(expectedHeading, actualHeading);
  }

  //@Test
  //public void displayHeadingTest(){
      //String expectedHeading = "Selenium: Beginners Guide";
      //String actualHeading = driver.getTitle();
      //WebElement secondHeading = driver.findElement(By.id("abId0.2997272623719913"));
      //Assert.assertEquals(expectedHeading, actualHeading);
      //WebElement secondHeading = driver.findElement(By.id("abId0.2997272623719913"));
      //Assert.assertTrue(secondHeading.contains());
    //}
  /**
   * Takto se po testech uklizi. Pokud je potreba. Muzeme treba zavrit okno, atp.
   */
  @AfterClass
  public void cleanUp() {
    //not needed right now
    //  driver.close();
  }

}
