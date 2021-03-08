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

    @BeforeClass
    public void beforeClassSetup() {
        driver = initializeDriver();
        goToHomePage(driver);

        System.out.println("Redirects to the chapter1 page after click.");
        WebElement chapter1Link = driver.findElement(By.linkText("Chapter1"));
        chapter1Link.click();
    }

    @Test
    public void checkSubHeadingAppearsTest() {
        WebElement subHeading = driver.findElement(By.xpath("//*[@class='mainbody']//p[1]"));
        System.out.println("Expected text is:");
        System.out.println(subHeading.getText());
        Assert.assertEquals("If you have arrived here then you have installed Selenium IDE and are ready to start recording your first test.", subHeading.getText());
    }

    @Test
    public void checkRadioButtonTest() {
        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        System.out.println("Button is displayed.");
        Assert.assertTrue(radioButton.isDisplayed());
        for (int i = 0; i < 2; i++) {
            radioButton.click();

            Assert.assertTrue(radioButton.isSelected());
            System.out.println("Button is toggled on.");
            Assert.assertTrue(!radioButton.isSelected(), "Button is not toggled off, as expected.");
            System.out.println("Button is toggled off");
        }
    }

    @Test
    public void checkDropDownisDisplayed(){
        WebElement dropDown = driver.findElement(By.id("selecttype"));
        //Select select = new Select(dropDown);
        System.out.println("Drop-Down menu is displayed.");
        Assert.assertTrue(dropDown.isDisplayed());
    }

    @Test
    public void checkDropDownOptionsAreDisplayedTest() {
        String[] expectedOptions = {"Selenium IDE", "Selenium Core", "Selenium RC", "Selenium Grid"};
        System.out.println("These are expected options:" + Arrays.toString(expectedOptions));
        Select dropDown = new Select(driver.findElement(By.id("selecttype")));
        List<WebElement> options = dropDown.getOptions();
        for (WebElement element : options) {
            boolean match = false;
            for (int i = 0; i < options.size(); i++) {
                if (element.getText().equals(expectedOptions[i])) {
                    match = true;
                }
            }
            Assert.assertTrue(match);
        }
    }

    @Test
    public void checkDropDownOptionsAreSelectedTest() {
        Select dropDown = new Select(driver.findElement(By.id("selecttype")));
        dropDown.selectByVisibleText("Selenium IDE");
        System.out.println("First option is available and selected value is Selenium IDE.");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Selenium IDE");

        dropDown.selectByIndex(1);
        System.out.println("Second option is available and selected value is Selenium Core.");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Selenium Core");

        dropDown.selectByIndex(2);
        System.out.println("Third option is available and selected value is Selenium RC..");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Selenium RC");

        dropDown.selectByIndex(3);
        System.out.println("Third option is available and selected value is Selenium Grid..");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Selenium Grid");
    }

    @Test
    public void selectCheckBoxtest() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='selected(1234)']"));
        for (int i = 0; i < 2; i++) {
            checkbox.click();
            if (checkbox.isSelected()) {
                System.out.println("Checkbox is toggled on.");
                Assert.assertTrue(checkbox.isSelected());
            } else {
                System.out.println("Checkbox is toggled off.");
                Assert.assertTrue(!checkbox.isSelected());
            }
        }
    }

    @Test
    public void homePageLinkTest(){
        String expectedUrl = "http://book.theautomatedtester.co.uk/";
        WebElement homeLink = driver.findElement(By.partialLinkText("Home Page"));
        homeLink.click();
        System.out.println("Redirected to Home page.");
        String redirectURL=driver.getCurrentUrl();
        Assert.assertEquals(redirectURL, expectedUrl);
        driver.navigate().back();
    }

    @Test
    public void displayAssertTextTest() {
        String expectedAssertText = "Assert that this text is on the page";
        WebElement assertText = driver.findElement(By.className("leftdiv"));
        String displayedText = assertText.getText();
        System.out.println("Displayed text is: " + displayedText);
        Assert.assertEquals(displayedText, expectedAssertText);
    }

    @Test
    public void verifyButtonTest(){
        WebElement buttonOnTheRight = driver.findElement(By.id("verifybutton"));
        System.out.println("Button on the right is displayed");
        Assert.assertTrue(buttonOnTheRight.isDisplayed());
        //Am I supposed to check something else?
    }

    @Test
    public void loadButtonTest() {
        WebElement buttonOnTheRight = driver.findElement(By.id("secondajaxbutton"));
        Assert.assertTrue(buttonOnTheRight.isDisplayed());
        WebElement noTextElement = driver.findElement(By.id("html5div"));
        String textBefore = noTextElement.getText().trim();
        buttonOnTheRight.click();
        WebElement textElement = driver.findElement(By.id("html5div"));
        //wait.until(ExpectedConditions.visibilityOf(textElement));
        String textAfter = textElement.getText();

        System.out.println("This text appears before click:" + textBefore);
        System.out.println("This text appears before click:" + textAfter);
        Assert.assertNotEquals(textBefore, textAfter);

        String expectedText = "To be used after the AJAX section of the book\n" + "I have been added with a timeout\n";
        Assert.assertEquals(textAfter.trim(), expectedText.trim());
    }

    @Test
    private void linkPopUpTest() {
        WebElement firstLink = driver.findElement(By.id("multiplewindow"));
        firstLink.click();
        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

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
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
    //Can I unite both PopuP tests using for loop?
    @Test
    public void linkSeconPopUpTest() {
        WebElement firstLink = driver.findElement(By.className("multiplewindow2"));
        firstLink.click();
        String MainWindow = driver.getWindowHandle();

        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                driver.switchTo().window(ChildWindow);
                WebElement textInPopUp = driver.findElement(By.id("popuptext"));
                System.out.println("Text in the second pop-up window is: " + textInPopUp.getText());
                Assert.assertEquals("Text within the pop up window", textInPopUp.getText());

                driver.findElement(By.id("closepopup")).click();
            }
        }
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
        Assert.assertEquals("The following text has been loaded from another page on this site. It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter", ajaxText.getText());
    }

    @Test
    public void inputFieldTest() {
        WebElement inputField = driver.findElement(By.id("storeinput"));
        Assert.assertTrue(inputField.isDisplayed());
        inputField.sendKeys("nevermind");
    }

    @Test
    public void bigTextFieldTest() {
        WebElement textFieldInput = driver.findElement(By.id("html5div"));
        Assert.assertTrue(textFieldInput.isDisplayed());
        textFieldInput.sendKeys("nevermind");
        Assert.assertTrue(textFieldInput.getText().contains("nevermind"));
    }

    @AfterClass
    public void cleanUp() {
        //driver.close();
    }


}
