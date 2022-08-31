Feature: Wunschliste Check

  Scenario: Login
    Given kullanıcı siteye gider "https://brandstore.e-shopland.ch/"
    When  Login butonuna basar
    And   User enters email "kunden01@gmail.com" and password "kunden.01"
    And   Kullanıcı Anmelden butonuna basar

 # @Favorite
#    Scenario: Wunschliste

   #   Given user clicks on favorite products
   #   When  user clicks on favorite button
      And   user gets products from favorite site
      Then  user checks selected favorite products

  @SonGrt
  Scenario: Recently viewed

    Given User selects product
    Then  User validates the selected product in the last viewers

