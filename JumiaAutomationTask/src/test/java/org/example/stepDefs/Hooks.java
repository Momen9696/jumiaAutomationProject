package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    public static WebDriver driver;

    @Before

    public static void initDriver() {
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            try {
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
            } catch (NoAlertPresentException e) {
            }
            String baseUrl = "https://www.jumia.com.eg/";
            driver.navigate().to(baseUrl);

        }
    }

    @After
    public static void quitDriver() throws InterruptedException {
        FunctionsHelper.takeScreenshot(driver, "C:\\Users\\momen\\IdeaProjects\\JumiaAutomationTask\\screenShots");
        Thread.sleep(3000);
        driver.quit();

    }

}