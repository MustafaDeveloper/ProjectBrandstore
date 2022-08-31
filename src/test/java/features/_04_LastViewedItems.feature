Feature: Wunschliste Check


  Background:
    Given   User goes to page "https://brandstore.e-shopland.ch/"
    When    User clicks on button Login
    And     User enters email "kunden01@gmail.com" and password "kunden.01"
    And     User clicks on button Anmelden

  @Favorite
  Scenario: Wunschliste

    Given user clicks on favorite products
    And   user gets products from favorite site
    Then  user checks selected favorite products

  @SonGrt
  Scenario: Recently viewed

    Given User selects product
    Then  User validates the selected product in the last viewers

