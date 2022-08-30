Feature: Filter

  Background:
    Given User goes to page "https://brandstore.e-shopland.ch/"
    And    Kullanıcı Alle Produkte butonuna basar
    And    Kullanıcı Produkte-Filtere tıklar


    @FiyataGöreFiltrelemeSlider
    Scenario: Fiyat aralığına göre sıralama
      When  Kullanıcı seçtiği fiyat aralığı seçer
      Then  Seçtiği fiyat aralığındaki ürünlerin fiyatını doğrular


   @RengeGöreÜrünFiltreleme
  Scenario: Renge Göre Fitreleme Çalışıyor mu?
    When  Filter nach Farbe kısmından renk seçer
    Then  Seçtiği renge göre ürün filtrelemenin çalıştığını doğrular

   @CinsiyeteGoreFiltreleme
   Scenario: Cinsiyete Göre Filtreleme Çalışıyor mu?
     When Filtern nach Gender kısmından cinsiyet seçer
     Then Seçtiği cinsiyete göre ürün filtrelemesinin çalıştığını doğrular

  @BedeneGoreFiltreleme
  Scenario: Bedene Göre Filtreleme Çalışıyor mu?
    When Filtern nach Grösse kısmından beden seçer
    Then Seçilen bedene göre ürün filtrelemesinin çalıştığını doğrular

  @MalmemeyeGoreFiltreleme
  Scenario: Malzemeye Göre Filtreleme Çalışıyor mu?
    When Filtern nach Material kısmından malzeme türünü seçer
    Then Seçilen malzemeye göre ürün filtrelemesinin çalıştığını doğrular



