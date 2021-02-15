package com.cvetelina.book;

import java.util.*;
import javax.xml.soap.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.java.util.jar.pack.*;
import com.sun.org.apache.xml.internal.security.utils.*;
import sun.awt.*;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;
import static org.testng.Assert.*;

public class HomePage {

  private static WebDriver driver;

  /**
   * Pridal jsem do POM TestNg anotace. Takze misto jUnit budeme pouzivat TestNg. To nam dava moznost pouzivat i Asserty atp. Je to obdoba jUnit.
   * Tato metoda udela to, ze nainicializuje chrome driver a vstoupi na domovskou stranku. Presne nejak takto muze vypadat setup testu co napises testu.
   */
  @BeforeClass
  public void beforeClassSetup() {
    driver = initializeDriver();
    goToHomePage(driver);
  }

  /**
   * Takto muzes psat testy. Tady je jen ilustrovano, jak pracovat s tim driverem. Je to stejny WebDriver jako znas ze svych testu.
   * Krok --> bez na google je samozrejme blbost :)
   * Pokud budeme mit vic testovacich scenaru, pridame dalsi metodu s anotaci Test.
   */
  @Test
  public void homePageTest() {
    //test bude zde.
    //jen zkouším
    WebElement inputField = driver.findElement(By.id("q"));
    inputField.sendKeys("Cvetelina");
  }

  @Test
  public void findUrls() {
    //List<String> expected = Arrays.asList("Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter8");
    String[] expected = {"Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter8"};
    for (int i = 0; i < expected.length; i++) {
      System.out.println(expected[i]);
      }
    //System.out.println(expected) ;
    List<WebElement> liElements = driver.findElements(By.xpath("//ul/li"));
    for (WebElement element : liElements) {

      System.out.println(element.getText());
      }

//List<WebElement> liElements = driver.findElements(By.xpath("//ul/li"));
    //System.out.println(liElements.size());
    //for (int i = 1; i < liElements.size()+1; i++) {
    // WebElement linkElement = driver.findElement(By.xpath("//ul/li[" + i + "]/a"));

    //System.out.println(linkElement.getText());
    //Assert.assertEquals(expected, liElements.gettext());
    //Assert.assertEquals(expected, liElements);
    }
  /**
   * Takto se po testech uklizi. Pokud je potreba. Muzeme treba zavrit okno, atp.
   */
  @AfterClass
  public void cleanUp() {
    //not needed right now
  }

}
