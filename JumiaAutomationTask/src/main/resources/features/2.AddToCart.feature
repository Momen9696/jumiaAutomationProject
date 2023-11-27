@smoke @UAT @ @valid_tests
Feature: Add Items To Cart

  Scenario Outline: [UAT] Existed user can make order by add items to his cart

    Given   User navigates to Jumia ,skips pop up ,and clicks on Account tab
    When    User clicks on signIn button
    And     User uses his valid credentials "<E-mail>" and "<Password>" to login
    And     User hovers on supermarket icon and clicks on bakery
    And     User clicks add to cart to the first and second items
    And     User navigates to his cart
    Then    The same two items shall be added to Users cart with total amount equals both items prices

    Examples:
      | E-mail                        |  | Password             |
      | validTestUserName10@gmail.com |  | validTest@Password10 |

