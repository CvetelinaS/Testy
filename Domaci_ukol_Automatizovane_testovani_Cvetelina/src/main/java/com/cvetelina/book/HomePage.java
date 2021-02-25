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
  public static final String CHAPTERS_LIST = "//*[contains(@class,'mainbody')]/ul//li"; // make private
  private static final String SUB_HEADING = "Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book.";

  // Tohle je komentar
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
    System.out.println(liElements);
    for (int i = 0; i < expectedNames.size(); i++) {
      Assert.assertEquals(liElements.get(i).getText(), expectedNames.get(i), "Expected names do not match actual.");
    }
  }

  @Test
  public void displayHeadingTest() {
    String expectedHeading = "Selenium: Beginners Guide";
    String actualHeading = driver.getTitle(); // Checkujes nadpis tabu, ne nadpis stranky.
    Assert.assertEquals(expectedHeading, actualHeading);
  }

  @Test
  public void displaySubHeadingTest() {
    //nazev listu s malym
    List<WebElement> SubHeading = driver.findElements(By.xpath("//*[@class='mainheading']//following-sibling::div"));
    WebElement element = SubHeading.get(0);
    String elementText = element.getText();
    // Find way how to extract only desired text from elementText String. Desired text equal SUB_HEADING.
    Assert.assertEquals(element.getText(), SUB_HEADING);
  }

  @AfterClass
  public void cleanUp() {
    // consider adding window closing.
  }

}
