Feature: Brandstore

  @AnasayfaTanımlıUrunler
  Scenario: anasayfada tanimli ürünler
    Given kullanıcı siteye gider "https://brandstore.e-shopland.ch/"
    When  Ürünlerin tanımlı olduğunu görür

  @LoginOlma
  Scenario:LoginOlma
    Given Login butonuna basar
    And kullanıcı  email "abc@gmail.com" ve password "Def_Ghi123_?" girer
    And Kullanıcı Anmelden butonuna basar
    Then  Mein Konto ifadesini görür

