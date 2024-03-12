package org.example.stepDefs;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import static org.example.stepDefs.Hooks.driver;

public class FunctionsHelper {
    //This class will contain all functions which will be used more than once
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
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

        // Find the target element
        WebElement targetElement = element;

        // Scroll to the target element
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    }

    public static void scrollDown(WebDriver driver, int endScrollingPosition) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, " + endScrollingPosition + ")");
            System.out.println("Scrolled down successfully.");
        } catch (Exception e) {
            System.err.println("Error while scrolling down: " + e.getMessage());
        }
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

    public WebDriverWait waitElement(int durationOfSeconds) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(durationOfSeconds));
        return wait;
    }

    public SoftAssert softAssert() {
        SoftAssert softAssert = new SoftAssert();
        return softAssert;
    }

    public Faker fake() {
        Faker faker = new Faker();
        return faker;
    }

    public static String generateFakeEmail(long seed) {
        Random random = new Random(seed);
        Faker faker = new Faker(random);
        return faker.internet().emailAddress();
    }

    public static Select select(WebElement staticDropDown) {
        Select select = new Select(staticDropDown);
        return select;

    }

    public static void setValueWithJavaScript(WebElement element, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Hooks.driver;
        jsExecutor.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public void alert() {
        try {
            Alert alert = Hooks.driver.switchTo().alert();
            if (alert != null) {
                alert.dismiss();  // or alert.accept() based on your requirements
            }
        } catch (NoAlertPresentException e) {
            // Handle the case where no alert is present (if needed)
        }
    }


    public String randomStrNumbers(){
        //Math.abs used to ensure that value is always positive
        // +8999999999999999999L used to ensure that the generated number does not start with 0
        long randomNumber = Math.abs(new Random().nextLong()) + 8999999999999999999L;
        String idNumber =  String.valueOf(randomNumber);
        return idNumber.substring(0, 25);
    }
    public static String randomPhoneNumberGenerator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("011");
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    }

