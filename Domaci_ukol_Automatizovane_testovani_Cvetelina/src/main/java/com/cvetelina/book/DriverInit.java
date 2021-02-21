package com.cvetelina.book;

import com.cvetelina.book.tools.Tools;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class DriverInit {

  private static String url = "http://book.theautomatedtester.co.uk/";

  public DriverInit() {
  }

  /**
   * Ten zakomentovany radek je pro Mac, chromedriver se tam nachazi v jine ceste nez na Windows.
   */
  public static WebDriver initializeDriver() {
    WebDriver driver;
    System.setProperty("webdriver.chrome.driver", "C:/Users/David/Downloads/chromedriver_win32/chromedriver.exe");
    //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); //Path to chromedriver at mac machine
    driver = new ChromeDriver();
    return driver;
  }

  public static void goToHomePage(WebDriver driver) {
    driver.navigate().to(url);
    Tools.waitForSeconds(2);
  }
}
