package com.cvetelina.book.tools;

import java.util.*;
import java.util.concurrent.*;
import org.apache.tools.ant.taskdefs.optional.pvcs.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import static com.cvetelina.book.DriverInit.goToHomePage;
import static com.cvetelina.book.DriverInit.initializeDriver;

public class Chapter1Page {
    private static WebDriver driver;
    private static final String SUB_HEADING_CHAPTER1 = "If you have arrived here then you have installed Selenium IDE and are ready to start recording your first test.";
    private static final String ANOTHER_PAGE_TEXT = "The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";
    private static final String LOAD_TEXT_WITH_BUTTON = "To be used after the AJAX section of the book\n" + "I have been added with a timeout\n";
    private static final By DROPDOWN_SELECTOR = By.id("selecttype");
    private static final By EDITABLE_CONTENT_FIELD = By.id("html5div");

    @BeforeClass
    public void beforeClassSetup() {
        driver = initializeDriver();
        goToHomePage(driver);

        WebElement chapter1Link = driver.findElement(By.linkText("Chapter1"));
        chapter1Link.click();
        System.out.println("Redirects to the chapter1 page after click.");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://book.theautomatedtester.co.uk/chapter1");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkSubHeadinDisplayedTest() {
        WebElement subHeading = driver.findElement(By.xpath("//*[@class='mainbody']//p[1]"));
        System.out.println("Actual text is:" + subHeading.getText());
        Assert.assertEquals(SUB_HEADING_CHAPTER1, subHeading.getText());
    }

    @Test
    public void checkRadioButtonTest() {
        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        Assert.assertTrue(radioButton.isDisplayed());
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());
        radioButton.click();
        Assert.assertTrue(!radioButton.isSelected(), "Button is not toggled off, as expected");
        }

    @Test
    public void checkDropDownMenuTest() {
        WebElement dropDown = driver.findElement(DROPDOWN_SELECTOR);
        Assert.assertTrue(dropDown.isDisplayed(), "Drop-Down menu is displayed.");
        String[] expectedOptions = {"Selenium IDE", "Selenium Core", "Selenium RC", "Selenium Grid"};
        Select dropDownSelect = new Select(driver.findElement(DROPDOWN_SELECTOR));
        List<WebElement> options = dropDownSelect.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(expectedOptions[i], options.get(i).getText());
        }

        dropDownSelect.selectByIndex(0);
        Assert.assertEquals(dropDownSelect.getFirstSelectedOption().getText(), "Selenium IDE");

        dropDownSelect.selectByIndex(1);
        Assert.assertEquals(dropDownSelect.getFirstSelectedOption().getText(), "Selenium Core");

        dropDownSelect.selectByIndex(2);
        Assert.assertEquals(dropDownSelect.getFirstSelectedOption().getText(), "Selenium RC");

        dropDownSelect.selectByIndex(3);
        Assert.assertEquals(dropDownSelect.getFirstSelectedOption().getText(), "Selenium Grid");
    }

    @Test
    public void selectCheckBoxTest() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='selected(1234)']"));
        Assert.assertTrue(checkbox.isDisplayed());
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Assert.assertTrue(!checkbox.isSelected());
    }

    @Test(priority = 1)
    public void homePageLinkTest(){
        String expectedUrl = "http://book.theautomatedtester.co.uk/";
        WebElement homeLink = driver.findElement(By.linkText("Home Page"));
        homeLink.click();
        String redirectURL=driver.getCurrentUrl();
        Assert.assertEquals(redirectURL, expectedUrl);
        driver.navigate().back();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://book.theautomatedtester.co.uk/chapter1");
    }

    @Test
    public void displayAnnotationDivTextTest() {
        String expectedDivText = "Assert that this text is on the page";
        WebElement annotationDivText = driver.findElement(By.className("leftdiv"));
        String displayedText = annotationDivText.getText();
        Assert.assertEquals(displayedText, expectedDivText);
    }

    @Test
    public void verifyHereButtonTest(){
        WebElement buttonNamedHere = driver.findElement(By.id("verifybutton"));
        Assert.assertTrue(buttonNamedHere.isDisplayed());
        Assert.assertEquals("Verify this button is here", buttonNamedHere.getAttribute("value"), "Expected and actual text do not match.");
    }

    @Test(priority = 2)
    public void loadAjaxButtonTest() {
        WebElement ajaxButton = driver.findElement(By.id("secondajaxbutton"));
        Assert.assertTrue(ajaxButton.isDisplayed());
        WebElement noTextElement = driver.findElement(EDITABLE_CONTENT_FIELD);
        String textBefore = noTextElement.getText().trim();
        ajaxButton.click();
        WebElement textElement = driver.findElement(EDITABLE_CONTENT_FIELD);
        String textAfter = textElement.getText();

        System.out.println("This text appears before click:" + textBefore);
        System.out.println("This text appears before click:" + textAfter);
        Assert.assertNotEquals(textBefore, textAfter);

        String expectedText = LOAD_TEXT_WITH_BUTTON;
        Assert.assertEquals(textAfter.trim(), expectedText.trim());
    }

    @Test(priority = 4)
    private void linksWithPopUpsTest() {
        WebElement firstLink = driver.findElement(By.id("multiplewindow"));
        firstLink.click();
        WebElement secondLink = driver.findElement(By.className("multiplewindow2"));
        secondLink.click();
        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        for (int i=0; i<2; i++){
            while (i1.hasNext()) {
                String ChildWindow = i1.next();
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    WebElement textInPopUp = driver.findElement(By.id("popuptext"));
                    System.out.println("Text in the pop-up window is: " + textInPopUp.getText());
                    Assert.assertEquals("Text within the pop up window", textInPopUp.getText());
                    driver.findElement(By.id("closepopup")).click();
                }
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }

    @Test
    public void loadAjaxLink() {
        WebElement loadAjaxLink = driver.findElement(By.id("loadajax"));
        loadAjaxLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ajaxText = driver.findElement(By.xpath("//*[@id='ajaxdiv']//child::p"));
        Assert.assertTrue(ajaxText.isDisplayed());
        System.out.println("Loaded text, after click on ajax link is:" + ajaxText.getText());
        Assert.assertEquals(ANOTHER_PAGE_TEXT, ajaxText.getText());
    }

    @Test(priority = 3)
    public void inputFieldTest() {
        WebElement inputField = driver.findElement(By.id("storeinput"));
        Assert.assertTrue(inputField.isDisplayed());
        inputField.sendKeys("never mind");
    }

    @Test
    public void bigTextFieldTest() {
        WebElement textFieldInput = driver.findElement(EDITABLE_CONTENT_FIELD);
        Assert.assertTrue(textFieldInput.isDisplayed());
        textFieldInput.sendKeys("never mind");
        Assert.assertTrue(textFieldInput.getText().contains("never mind"));
    }

    @AfterClass
    public void cleanUp() {
        //driver.close();
    }


}
