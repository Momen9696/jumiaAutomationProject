package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Register_locators;
import org.example.utils.ConfigManager;
import org.example.utils.ExcelUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

//Actions
public class D01_registerStepDef {
    ExcelUtils validDynamicTestDataSheet = new ExcelUtils(ConfigManager.getInstance().getString("baseExcelSheetPath") + ConfigManager.getInstance().getString("RegistrationDataExcelPath"), "dynamicTestData");
    String emailAddress = retrieveUnusedData("e-mailAddress");
    String password = retrieveUnusedData("password");
    String phoneNumber = retrieveUnusedData("phoneNumber");

    ExcelUtils validStaticTestDataSheet = new ExcelUtils(ConfigManager.getInstance().getString("baseExcelSheetPath") + ConfigManager.getInstance().getString("RegistrationDataExcelPath"), "staticTestData");
    int validRowNumber = validStaticTestDataSheet.getRowNum("validTestData");

    String firstName = validStaticTestDataSheet.getCellData(validRowNumber, validStaticTestDataSheet.getColNumber("firstName"));
    String lastName = validStaticTestDataSheet.getCellData(validRowNumber, validStaticTestDataSheet.getColNumber("lastName"));
    String birthDate = validStaticTestDataSheet.getCellData(validRowNumber, validStaticTestDataSheet.getColNumber("birthDate"));
    Register_locators register = new Register_locators();
    SoftAssert softAssert = new SoftAssert();

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    //= new WebDriverWait(driver, Duration.ofSeconds(10));

    public String retrieveUnusedData(String columnName) {
        //retrieve row that has valid unused data
        int validRow = validDynamicTestDataSheet.getValidRowNumber(validDynamicTestDataSheet.getColNumber("usedFlag"));
        return validDynamicTestDataSheet.getCellData(validRow, validDynamicTestDataSheet.getColNumber(columnName));
    }

    @Given("User navigates to Jumia english ,Skips pop up ,and Clicks on Account tab on the top of screen")
    public void clickAccountTab() {
        if (register.subscribePopUp().isDisplayed()) {
            register.popUpExitKey().click();
        }
        register.accountTab().click();
    }

    @When("User clicks on sign in button")
    public void clickSignInButton() {
        register.signInButton().click();
    }

    @And("User enters his valid E-mail address which shouldn't be used before in E-mail field")
    public void fillFirstEmail() {

        wait.until(ExpectedConditions.visibilityOf(register.emailField()));
        register.emailField().sendKeys(emailAddress);
    }

    @And("User clicks on continue button in orange color")
    public void clickCountineButton() {

        register.firstContinueButton().click();
    }

    @And("User enters his password which should be with good or strong level of strength in password field")
    public void fillFirstPassword() {
        register.passwordField().sendKeys(password);
    }

    @And("User reenter the same password which in confirm password field")
    public void fillConfirmationPassword() {
        register.confirmationPasswordField().sendKeys(password);
    }

    @And("User clicks continue to redirect to first page of personal info pages")
    public void clickSecondCountineButton() {
        wait.until(ExpectedConditions.textToBePresentInElement(register.passwordStrength(), "Strong"));
        register.secondContinueButton().click();
    }


    @And("User enters his personal details First Name,Last Name")
    public void fillNameFields() {
        register.firstName().sendKeys(firstName);
        register.secondName().sendKeys(lastName);
    }

    @And("User asserts country prefix is valid and enters a valid Phone Number")
    public void fillPhoneNumber() {
        softAssert.assertTrue(register.prefixField().getText().contains("+20"), "Prefix is invalid");
        register.phoneNumber().sendKeys(phoneNumber);
        softAssert.assertAll();
    }

    @And("User clicks continue to redirect to second page of personal info pages")
    public void clickThirdCountineButton() {
        register.thirdCountineButton().click();
    }

    @And("User continue entering his personal details Gender,Birth date")
    public void selectGenderAndBirthDate() {
        register.genderField().click();
        register.maleGender().click();
        register.birthDate().sendKeys(birthDate);
    }

    @And("User clicks on I read and consented to the Terms and Conditions")
    public void clickAcceptTC() {
        register.acceptTC().click();
        register.fourthCountineButton().click();
    }

    @Then("User should be redirected to the home page and tab account changing with HI, and his FirstName")
    public boolean assertA() {
        softAssert.assertTrue(register.loginAccountTab().getText().contains("Hi,"));
        softAssert.assertAll();
        setUsedFlagToTrue();
        return true;
    }

    public void setUsedFlagToTrue() {
        int validRow = validDynamicTestDataSheet.getValidRowNumber(validDynamicTestDataSheet.getColNumber("usedFlag"));
        validDynamicTestDataSheet.setCellData(validRow, validDynamicTestDataSheet.getColNumber("usedFlag"), "true");
    }

}





















