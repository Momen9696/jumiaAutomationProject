package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddToCart_locators {
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

    public WebElement loginEmailField() {
        return Hooks.driver.findElement(By.xpath("(//input[@id='input_identifierValue'])[1]"));
    }

    public WebElement countineButton() {
        return Hooks.driver.findElement(By.cssSelector("button[type='submit'] span[class='mdc-button__touch']"));
    }

    public WebElement loginPasswordField() {
        return Hooks.driver.findElement(By.cssSelector("input[name='password']"));
    }

    public WebElement loginButton() {
        return Hooks.driver.findElement(By.xpath("//button[@id='loginButton']//span[@class='mdc-button__touch']"));
    }

    public WebElement superMarketMenu() {
        return Hooks.driver.findElement(By.xpath("(//a[@href='/groceries/'])[1]"));
    }

    public WebElement bakerySection() {
        return Hooks.driver.findElement(By.xpath("//a[normalize-space()='Bakery']"));
    }

    public WebElement firstItem() {
        return Hooks.driver.findElement(By.xpath("//article[2]//a[1]//div[1]//img[1]"));
    }

    public WebElement addFirstItem() {
        return Hooks.driver.findElement(By.xpath("//article[2]//footer[1]//form[1]//button[1]"));
    }

    public WebElement secondItem() {
        return Hooks.driver.findElement(By.xpath("//article[3]//a[1]//div[1]//img[1]"));
    }

    public WebElement successMessageDisappear() {
        return Hooks.driver.findElement(By.xpath("//div[@class='cnt']"));
    }

    public WebElement addSecondItem() {
        return Hooks.driver.findElement(By.xpath("//article[3]//footer[1]//form[1]//button[1]"));
    }

    public WebElement cartIcon() {
        return Hooks.driver.findElement(By.xpath("(//a[normalize-space()='Cart'])[1]"));
    }

    public WebElement itemsCount() {
        return Hooks.driver.findElement(By.cssSelector(".-fs20.-m.-phm.-pvxs"));
    }

    public WebElement itemOnePrice() {
        return Hooks.driver.findElement(By.xpath("(//div[@class='prc'][normalize-space()='EGP 54.00'])[1]"));
    }

    public WebElement itemTwoPrice() {
        return Hooks.driver.findElement(By.xpath("//div[normalize-space()='EGP 67.50']"));
    }

    public WebElement totalAmountDue() {
        return Hooks.driver.findElement(By.xpath("//p[@class='-fs20 -plm -tar']"));
    }

    public WebElement removeItemOne() {
        return Hooks.driver.findElement(By.xpath("(//*[name()='svg'][@class='ic'])[11]"));
    }

    public WebElement confirmRemoveButton() {
        return Hooks.driver.findElement(By.xpath("//span[normalize-space()='Remove Item']"));
    }

}
