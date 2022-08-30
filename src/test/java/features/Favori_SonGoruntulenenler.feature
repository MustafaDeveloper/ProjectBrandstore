Feature: Wunschliste Check

  Scenario: Login
    Given kullanıcı siteye gider "https://brandstore.e-shopland.ch/"
    When  Login butonuna basar
    And   kullanıcı  email "kursjava@gmail.com" ve password "kurs.java.123" girer
    And   Kullanıcı Anmelden butonuna basar

 # @Favorite
#    Scenario: Wunschliste

   #   Given user clicks on favorite products
   #   When  user clicks on favorite button
      And   user gets products from favorite site
      Then  user checks selected favorite products

  @SonGrt
  Scenario: Son goruntulenler

    Given  Kullanici urun secer
    Then  Kullanici sectigi urunu son goruntulenenlerde dogrular