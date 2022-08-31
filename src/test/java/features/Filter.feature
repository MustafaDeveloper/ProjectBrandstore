Feature: Filter

  Background:
    Given   User goes to page "https://brandstore.e-shopland.ch/"
    And     User clicks on button All
    And     User clicks on button Produkte-Filter


  @FilterByPriceRange
  Scenario: Sort by price range
    When  User selects price range
    Then  User verifies the price of the products in the selected range


  @FilterByColour
  Scenario: Sort by colour
    When  User selects color with Filter nach Farbe
    Then  user verifies that filtering by color is working

  @FilterByGender
  Scenario: Cinsiyete Göre Filtreleme Çalışıyor mu?
    When Filtern nach Gender kısmından cinsiyet seçer
    Then Seçtiği cinsiyete göre ürün filtrelemesinin çalıştığını doğrular

  @FilterBySize
  Scenario: Bedene Göre Filtreleme Çalışıyor mu?
    When Filtern nach Grösse kısmından beden seçer
    Then Seçilen bedene göre ürün filtrelemesinin çalıştığını doğrular

  @FilterByMaterial
  Scenario: Malzemeye Göre Filtreleme Çalışıyor mu?
    When Filtern nach Material kısmından malzeme türünü seçer
    Then Seçilen malzemeye göre ürün filtrelemesinin çalıştığını doğrular



