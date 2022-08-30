Feature: Brandstore

  @Products
  Scenario: Products on homepage
    Given   User goes to page "https://brandstore.e-shopland.ch/"
    When    User sees that the Products are defined

  @Login
  Scenario:Login
    Given   User presses on button Login
    And     User enters email "kunden01@gmail.com" and password "kunden.01"
    And     User presses button Anmelden
    Then    User sees statement Mein Konto

