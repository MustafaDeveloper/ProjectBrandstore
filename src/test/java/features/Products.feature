Feature: TumUrunler

  Background:
    Given  User goes to page "https://brandstore.e-shopland.ch/"
    And    User presses button Alle Produkte

  @AllProductsPictureAndPrice
  Scenario: Picture and price information of all products

    When   User presses on button All
    Then   Tüm ürünlerin resimlerinin  varlığını doğrular
    And    Tüm ürünlerin fiyat bilgilerin varlığını doğrular


  @KategorilerDropdown
  Scenario: sol tarafta bulunan kategoriler dropdown calisiyor mu?

    When  Kategorien dropdownundan  menü secer
    Then  Kategorien dropdownundaki menülerde belirtilen ürün sayısılarından seçileni doğrular

    @ÜrünSıralama
    Scenario:  Sag üst tarafta bulunan siralama islemi düzgün calisiyor mu?
      When  Kullanıcı sıralama işlemi için menü seçer
      Then  Kullanıcı sıralamanın doğru çalıştığını doğrular







