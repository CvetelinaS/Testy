package com.cvetelina.book;

import org.openqa.selenium.WebDriver;
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
    driver.navigate().to("https://www.google.com/");

  }

  /**
   * Takto se po testech uklizi. Pokud je potreba. Muzeme treba zavrit okno, atp.
   */
  @AfterClass
  public void cleanUp() {
    //not needed right now
  }

}
