package com.cvetelina.book;

import java.util.*;

import org.openqa.selenium.*;

import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.java.util.jar.pack.*;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class HomePage {

    private static WebDriver driver;
    private static final String CHAPTERS_LIST = "//*[contains(@class,'mainbody')]/ul//li";
    private static final String SUB_HEADING = "Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book.";

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
      System.out.println("Expected names:");
      System.out.println(expectedNames);
      List<WebElement> liElements = driver.findElements(By.xpath(CHAPTERS_LIST));
      System.out.println("Actual names");
      System.out.println(liElements);// This println() actually does't give me the strings of the elements, tried this liElements.forEach(System.out::println);
      for (int i = 0; i < expectedNames.size(); i++) {
          Assert.assertEquals(liElements.get(i).getText(), expectedNames.get(i), "Expected names do not match actual.");
      }
  }

  @Test
  public void displayHeadingTest() {
      WebElement expectedHeading = driver.findElement(By.className("mainheading"));
      String actualHeading = expectedHeading.getText();
      System.out.println(actualHeading);
      Assert.assertEquals("Selenium: Beginners Guide", actualHeading);
  }    

  @Test
  public void displaySubHeadingTest() {
      List<WebElement> subHeading = driver.findElements(By.xpath("//*[@class='mainheading']//following-sibling::div"));
     // WebElement element = subHeading.get(0);
      //String elementText = element.getText();
      //int numberOfElements = subHeading.size();
      for(int i=0; i < subHeading.size(); i++) {
          String element = subHeading.get(i).getText();
          System.out.println(element);
          Assert.assertEquals(element, SUB_HEADING);
          //Cannot extract the the first element, as this is a list of one element. tried to convert it to an array, but that didn't work neither.
      }
  }

  @AfterClass
  public void cleanUp() {
      driver.close();
    }

}
