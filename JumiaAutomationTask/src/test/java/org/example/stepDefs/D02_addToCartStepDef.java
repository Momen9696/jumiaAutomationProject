package org.example.stepDefs;

        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.example.pages.AddToCart_locators;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.asserts.SoftAssert;

        import java.time.Duration;

public class D02_addToCartStepDef {
    AddToCart_locators addToCart = new AddToCart_locators();
    FunctionsHelper functions = new FunctionsHelper();

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
        functions.waitElement().until(ExpectedConditions.visibilityOf(addToCart.loginEmailField()));
        addToCart.loginEmailField().sendKeys(email);
        addToCart.countineButton().click();
        addToCart.loginPasswordField().sendKeys(password);
        addToCart.loginButton().click();
    }

    @And("User click on skip for now button")
    public void clickSkipForNow() {
        functions.waitElement().until(ExpectedConditions.visibilityOf(addToCart.skipSecureButton()));
        if (addToCart.secureYourAccountPopUp().isDisplayed()) {
            addToCart.skipSecureButton().click();
        }
    }


    @And("User hovers on supermarket icon and clicks on bakery")
    public void hoverOnSupermarketAndSelectBakery() {
        currentURL = Hooks.driver.getCurrentUrl();
        expectedURL = "https://www.jumia.com.eg/";
        functions.softAssert().assertEquals(currentURL, expectedURL);
        functions.hoverOnElement(addToCart.superMarketMenu());
        addToCart.bakerySection().click();
        functions.softAssert().assertAll();
    }

    @And("User clicks add to cart to the first and second items")
    public void addTwoItemsToCart() {
        FunctionsHelper.scrollDown(Hooks.driver, 200);
        functions.hoverOnElement(addToCart.firstItem());
        addToCart.addFirstItem().click();
        functions.waitElement().until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));
        functions.hoverOnElement(addToCart.secondItem());
        addToCart.addSecondItem().click();
        functions.waitElement().until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));

    }

    @And("User navigates to his cart")
    public void clickOnCart() {

        addToCart.cartIcon().click();
    }

    @Then("The same two items shall be added to Users cart with total amount equals both items prices")
    public void itemsCountAndAmountAssertion() throws InterruptedException {
        functions.softAssert().assertTrue(addToCart.itemsCount().getText().contains("2"));
        if (addToCart.itemsPrice().size() <= 32) {
            itemOnePrice = Double.valueOf(addToCart.itemsPrice().get(0).getText().replaceAll("[^0-9.]", ""));
            itemTwoPrice = Double.valueOf(addToCart.itemsPrice().get(1).getText().replaceAll("[^0-9.]", ""));
            expectedTotalPrice = itemOnePrice + itemTwoPrice;
            actualTotalPrice = Double.valueOf(addToCart.totalAmountDue().getText().replaceAll("[^0-9.]", ""));
        }
        functions.softAssert().assertEquals(actualTotalPrice, expectedTotalPrice);

        //Items will be removed for the next execution
        if (addToCart.removeItems().size() <= 2) {
            addToCart.removeItems().get(0).click();
            addToCart.confirmRemoveButton().click();
            functions.waitElement().until(ExpectedConditions.invisibilityOf(addToCart.successMessageDisappear()));
            addToCart.removeItems().get(0).click();
            addToCart.confirmRemoveButton().click();
        }
        functions.softAssert().assertAll();
;
    }

}