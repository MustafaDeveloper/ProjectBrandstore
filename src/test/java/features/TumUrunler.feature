Feature: TumUrunler

  Background:
    Given kullanıcı siteye gider "https://brandstore.e-shopland.ch/"
    And    Kullanıcı Alle Produkte butonuna basar

  @TümÜrünlerResimFiyat
  Scenario: Tüm ürünlerin resimleri ve fiyat bilgileri var mi

    When   Kullanıcı All butonuna basar
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







