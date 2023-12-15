@smoke @UAT @ @valid_tests
Feature: Make A New Registration (Sign Up)

  Scenario: [UAT] User can make a registration on Jumia using valid data

    Given   User navigates to Jumia english ,Skips pop up ,and Clicks on Account tab on the top of screen
    When    User clicks on sign in button
    And     User enters his valid E-mail address which shouldn't be used before in E-mail field
    And     User clicks on continue button in orange color
    And     User skips the securiy pop-up
    And     User enters his password which should be with good or strong level of strength in password field
    And     User reenter the same password which in confirm password field
    And     User clicks continue to redirect to first page of personal info pages
    And     User enters his personal details First Name,Last Name
    And     User asserts country prefix is valid and enters a valid Phone Number
    And     User clicks continue to redirect to second page of personal info pages
    And     User continue entering his personal details Gender,Birth date
    And     User clicks on I read and consented to the Terms and Conditions
    And     User clicks on continue button in orange color
    Then    User should be redirected to the home page and tab account changing with HI, and his FirstName
