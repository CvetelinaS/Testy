package com.cvetelina.book;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class HomePage {

<<<<<<< HEAD
    private static WebDriver driver;
    public static final String CHAPTERS_LIST = "//*[contains(@class,'mainbody')]/ul//li";
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
        Assert.assertTrue(inputField.isDisplayed());
        inputField.sendKeys("Cvetelina");
    }

    @Test
    public void findUrlsTest() {
        List<String> expectedNames = Arrays.asList("Chapter1", "Chapter2", "Chapter3", "Chapter4", "Chapter8");
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
        List <WebElement> SubHeading = driver.findElements(By.xpath("//*[@class='mainheading']//following-sibling::div"));
        String[]firstElement = new String[SubHeading.size()];
        int i=0;
        for(WebElement element: SubHeading) {
            firstElement[i] = element.getText();
            i++;
            //System.out.println(firstElement[0].contains("Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book."));
            Assert.assertTrue(firstElement[0].contains("Below is a list of links to the examples needed in the chapters. Click on the links below and follow the steps in the book."));
        }
    }
    /**
     * Takto se po testech uklizi. Pokud je potreba. Muzeme treba zavrit okno, atp.
     */
    @AfterClass
    public void cleanUp() {
        //not needed right now
        //  driver.close();
    }
=======
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
>>>>>>> 5251e6bc1c861c50bd9898eb67fdddc79fe62a5a

}
