package org.example.stepDefs;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class FunctionsHelper {
    //This class will contain all functions which will be used more than once
    public static void takeScreenshot(WebDriver driver, String directoryPath) {
        // Check if the driver supports taking screenshots
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

            // Capture the screenshot as a file
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

            // Get the current timestamp
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String timestamp = currentTime.format(formatter);

            // Specify the destination where you want to save the screenshot with a unique name
            String fileName = "screenshot_" + timestamp + ".png";
            File destination = new File(directoryPath, fileName);

            try {
                // Copy the screenshot to the desired location
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot taken: " + destination.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Screenshot not supported for this WebDriver instance.");
        }
    }

    public static void scrollToSpecificElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Find the target element
        WebElement targetElement = element;

        // Scroll to the target element
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    }

    public static void scrollDown(WebDriver driver, int endScrollingPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + endScrollingPosition + ")");
    }

    public Actions hoverOnElement(WebElement path) {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(path).perform();
        return action;
    }

    public void multiClicker(WebElement element, int countOfClicks) {
        for (int i = 1; i <= countOfClicks; i++)
            element.click();
    }

    public void tabsController(int indexPage) {
        ArrayList<String> tabController = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabController.get(indexPage));
    }

    public WebDriverWait waitElement() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        return wait;
    }

    public SoftAssert softAssert() {
        SoftAssert softAssert = new SoftAssert();
        return softAssert;
    }

}
