package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AddToCart_locators;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D02_addToCartStepDef {
    AddToCart_locators addToCart = new AddToCart_locators();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions action = new Actions(Hooks.driver);
    SoftAssert softAssert = new SoftAssert();

    String currentURL, expectedURL;
    Double itemOnePrice, itemTwoPrice, expectedTotalPrice, actualTotalPrice;

    @Given("User navigates to Jumia ,skips pop up ,and clicks on Account tab")
    public void clickOnAccountTab() {
        if (addToCart.subscribePopUp().isDisplayed()) {
            addToCart.popUpExitKey().click();
        }
        addToCart.accountTab().click();
    }

    @When("User clicks on signIn button")
    public void clickSignIn() {
        addToCart.signInButton().click();
    }


    @And("User uses his valid credentials {string} and {string} to login")
    public void fillValidCredentials(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(addToCart.loginEmailField()));
        addToCart.loginEmailField().sendKeys(email);
        addToCart.countineButton().click();
        addToCart.loginPasswordField().sendKeys(password);
        addToCart.loginButton().click();
    }


    @And("User hovers on supermarket icon and clicks on bakery")
    public void hoverOnSupermarketAndSelectBakery() {
        currentURL = Hooks.driver.getCurrentUrl();
        expectedURL = "https://www.jumia.com.eg/";
        softAssert.assertEquals(currentURL, expectedURL);
        action.moveToElement(addToCart.superMarketMenu()).perform();
        addToCart.bakerySection().click();
        softAssert.assertAll();
    }

    @And("User clicks add to cart to the first and second items")
    public void addTwoItemsToCart() {
        Hooks.scrollDown(Hooks.driver);
        action.moveToElement(addToCart.firstItem()).perform();
        addToCart.addFirstItem().click();
        wait.until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));
        action.moveToElement(addToCart.secondItem()).perform();
        addToCart.addSecondItem().click();
        wait.until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));

    }

    @And("User navigates to his cart")
    public void clickOnCart() {

        addToCart.cartIcon().click();
    }

    @Then("The same two items shall be added to Users cart with total amount equals both items prices")
    public void itemsCountAndAmountAssertion() {
        softAssert.assertTrue(addToCart.itemsCount().getText().contains("2"));
        itemOnePrice = Double.valueOf(addToCart.itemOnePrice().getText().replaceAll("[^0-9.]", ""));
        itemTwoPrice = Double.valueOf(addToCart.itemTwoPrice().getText().replaceAll("[^0-9.]", ""));
        expectedTotalPrice = itemOnePrice + itemTwoPrice;
        actualTotalPrice = Double.valueOf(addToCart.totalAmountDue().getText().replaceAll("[^0-9.]", ""));
        softAssert.assertEquals(actualTotalPrice, expectedTotalPrice);
        //Items will be removed for the next execution
        addToCart.removeItemOne().click();
        addToCart.confirmRemoveButton().click();
        wait.until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));
        addToCart.removeItemOne().click();
        addToCart.confirmRemoveButton().click();
        softAssert.assertAll();
    }

}