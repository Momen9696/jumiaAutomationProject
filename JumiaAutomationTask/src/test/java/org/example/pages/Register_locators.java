package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Locators
public class Register_locators {
    public WebElement subscribePopUp() {
        return Hooks.driver.findElement(By.xpath("//div[@class='-pvxl -phl -tac -fw']"));
    }

    public WebElement popUpExitKey() {
        return Hooks.driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/section[1]/button[1]/*[name()='svg']/*[name()='use']"));
    }

    public WebElement accountTab() {
        return Hooks.driver.findElement(By.xpath("//label[normalize-space()='Account']//*[name()='svg']"));
    }


    public WebElement signInButton() {
        return Hooks.driver.findElement(By.xpath("(//a[normalize-space()='Sign In'])[1]"));
    }

    public WebElement emailField() {
        return Hooks.driver.findElement(By.xpath("(//input[@id='input_identifierValue'])[1]"));
    }

    public WebElement firstContinueButton() {
        return Hooks.driver.findElement(By.cssSelector("button[type='submit'] span[class='mdc-button__touch']"));
    }

    public WebElement passwordField() {
        return Hooks.driver.findElement(By.cssSelector("input[name='password']"));
    }

    public WebElement confirmationPasswordField() {
        return Hooks.driver.findElement(By.cssSelector(".mdc-text-field__input.confirm-password-input"));
    }

    public WebElement passwordStrength() {
        return Hooks.driver.findElement(By.xpath("(//p[@id='password-strength-text'])[1]"));
    }

    public WebElement secondContinueButton() {
        return Hooks.driver.findElement(By.cssSelector("button[class='mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded'] span[class='mdc-button__touch']"));
    }

    public WebElement firstName() {
        return Hooks.driver.findElement(By.xpath("//input[@id='input_first_name']"));
    }

    public WebElement secondName() {
        return Hooks.driver.findElement(By.cssSelector("#input_last_name"));
    }

    public WebElement prefixField() {
        return Hooks.driver.findElement(By.xpath("//div[@class='prefix-phone-select mdc-select--ltr-text mdc-select mdc-select--outlined prefix-component']//div[@class='mdc-select__anchor']"));
    }

    public WebElement phoneNumber() {
        return Hooks.driver.findElement(By.xpath("(//input[@name='phone[number]'])[1]"));
    }

    public WebElement thirdCountineButton() {
        return Hooks.driver.findElement(By.cssSelector("button[class='mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded'] span[class='mdc-button__touch']"));
    }

    public WebElement genderField() {
        return Hooks.driver.findElement(By.xpath("//div[@aria-required='true']"));
    }

    public WebElement maleGender() {
        return Hooks.driver.findElement(By.xpath("//li[@data-value='M']"));
    }

    public WebElement birthDate() {
        return Hooks.driver.findElement(By.xpath("//input[@id='input_birth_date']"));
    }

    public WebElement acceptTC() {
        return Hooks.driver.findElement(By.xpath("(//input[@id='acceptTC'])[1]"));
    }

    public WebElement fourthCountineButton() {
        return Hooks.driver.findElement(By.xpath("(//span[@class='mdc-button__touch'])[3]"));
    }

    public WebElement loginAccountTab() {
        return Hooks.driver.findElement(By.xpath("(//section[@class='row -i-ctr -fw-nw -pvm'])[1]"));
    }
    public WebElement secureYourAccountPopUp() {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"passkeys-enrolment-screen\"]"));
    }
    public WebElement skipSecureButton() {
        return Hooks.driver.findElement(By.xpath("//a[@id=\"skipPasskeyButton\"]"));
    }
    public WebElement confirmPasswordLabel() {
        return Hooks.driver.findElement(By.xpath("//div[@id=\"confirm-password-label\"]"));
    }
}