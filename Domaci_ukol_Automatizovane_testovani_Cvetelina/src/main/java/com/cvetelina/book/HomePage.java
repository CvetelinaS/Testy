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
    List<String> expectedNames = Arrays.asList("Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter8");
    System.out.println(expectedNames);

    List<WebElement> liElements = driver.findElements(By.xpath(
        "//ul/li")); //tady tohle funguje, nicmene bych zkusil zapsat trosku lepsi cestu. Tyto elementy maji nejaky parent div. 2. Je mozne, ze tu cestu budes potrebovat pouzit opakovane. Vyrobil bych konstantu, kde tu cestu definujes a do kodu ji budes jen predavat.
    for (int i = 0; i < expectedNames.size(); i++) {
      Assert.assertEquals(liElements.get(i).getText(), expectedNames.get(i));
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
