package com.cvetelina.book;

import java.util.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class HomePage {

  private static WebDriver driver;
  public static final String CHAPTERS_LIST = "//*[contains(@class,'mainbody')]/ul//li";


  @BeforeClass
  public void beforeClassSetup() {
    driver = initializeDriver();
    goToHomePage(driver);
  }

  @Test
  public void displayInputTest() {
    WebElement inputField = driver.findElement(By.id("q"));
    Assert.assertTrue(inputField.isDisplayed());
    inputField.sendKeys("Cvetelina");
  }

  @Test
  public void findUrlsTest() {
    List<String> expectedNames = Arrays.asList("Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter5");
    System.out.println(expectedNames);
    List<WebElement> liElements = driver.findElements(By.xpath(CHAPTERS_LIST));
    for (int i = 0; i < expectedNames.size(); i++) {
      Assert.assertEquals(liElements.get(i).getText(), expectedNames.get(i));
    }
  }

  @Test
  public void displayHeadingTest(){
    String expectedHeading = "Selenium: Beginners Guide";
    String actualHeading = driver.getTitle();
    Assert.assertEquals(expectedHeading, actualHeading);
  }

  @Test
  public void displaySubHeadingTest(){
    List<WebElement> SubHeading = driver.findElements(By.xpath("//*[@class='mainheading']//following-sibling::div"));
    String[]firstElement = new String[SubHeading.size()];
    int i=0;
    for(WebElement element: SubHeading) {
      firstElement[i] = element.getText();
      i++;
      //System.out.println(firstElement[0].contains("Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book."));
      Assert.assertTrue(firstElement[0].contains("Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book."));
    }
  }

  @AfterClass
  public void cleanUp() {
    //not needed right now
    //
  }

}
