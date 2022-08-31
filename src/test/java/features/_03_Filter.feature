Feature: Filter

  Background:
    Given   User goes to page "https://brandstore.e-shopland.ch/"
    And     User clicks on button Alle Produkte
    And     User clicks on button Produkte-Filter


  @FilterByPriceRange
  Scenario: Sorting by price range
    When  User selects price range
    Then  User verifies the price of the products in the selected range


  @FilterByColour
  Scenario: Sorting by colour
    When  User selects color with Filter nach Farbe
    Then  User verifies that filtering by color is working

  @FilterByGender
  Scenario: Sorting by gender
    When User selects gender from Filtern-nach-Gender
    Then User verifies that filtering by gender is working

  @FilterBySize
  Scenario: Sorting by size
    When User selects gender from Filtern-nach-Groesse
    Then User verifies that filtering by size is working

  @FilterByMaterial
  Scenario: Sorting by material
    When User selects gender from Filtern-nach-Material
    Then User verifies that filtering by material is working



