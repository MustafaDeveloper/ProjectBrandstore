Feature: Products

  Background:
    Given  User goes to page "https://brandstore.e-shopland.ch/"
    And    User clicks on button Alle Produkte

  @AllProductsPictureAndPrice
  Scenario: Verification of all product pictures and price information
    When   User clicks on button All
    Then   User verifies the existence of images of all products
    And    User verifies the existence of prices of all products


  @CategoriesDropdown
  Scenario: Verification of working of Categories-Dropdown

    When  User selects menu from Kategorien-Dropdown
    Then  User validates the number of products specified in the menu

  @ProductRanking
  Scenario:  Verification of working properly of ranking at the top right
    When  User selects menu for ranking
    Then  User verifies that ranking is working correctly







