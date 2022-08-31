package pages;

import org.openqa.selenium.By;

public interface Locators {
    By lcookies = By.cssSelector("p a.woocommerce-store-notice__dismiss-link");
    //By lloginButton=By.xpath("(//span[@class='menu-text']//span[text()='Login'])[1]");
    By lloginButton = By.xpath("(//i[@class='_mi _before far fa-user-circle'])[1]");
    By lJetztShoppenButton = By.cssSelector(".elementor-button-wrapper>a");
    By lusurname = By.cssSelector("p input#username");
    By lpassword = By.cssSelector("p input#password");
    By lsubmitButton = By.xpath("(//button[@type='submit'])[2]");
    By lHomeImg = By.cssSelector("html img");

    By lMeinKonto = By.cssSelector("li.trail-item.trail-end span span"); //
    By lTumUrunlerButonu = By.cssSelector("li#menu-item-45");
    By lAllButonu = By.cssSelector("a[data-type='all']");
    By lTümürünler = By.cssSelector("li.ast-col-sm-12");
    By lTümürünlerResim = By.cssSelector("div.astra-shop-thumbnail-wrap img");
    By lTümÜrünlerFiyat = By.cssSelector("span.price");
    By lTümÜrünisim = By.cssSelector("span.ast-woo-product-category");
    By lKategorilerDropdown = By.cssSelector("#product_cat");

    By lSıralamaSelect = By.cssSelector("select.orderby");
    By lSıralananUrunFiyat = By.cssSelector("div[class='astra-shop-summary-wrap'] span[class='price']");
    By lProducteFilterButton = By.cssSelector("span.astra-woo-filter-text");
    By lSağaaKaydırma = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
    By lSolaKaydırma = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]");
    By lSlipBarFiyat = By.cssSelector("div.price_label");
    By lFilternButton=By.xpath("//div[@class='price_slider_amount']//button");
   By lRengeGoreFiltrelemeInput=By.xpath("(//input[@class='select2-search__field'])[1]");
   By lSelectdekiFiltrelemeKıstasları =By.cssSelector("ul[class='select2-results__options'] li");

   By lUrunOzellikler=By.cssSelector("li#tab-title-additional_information");
   By lUrunRenkKontrol=By.xpath("(//td//p)[1]");
   By lRengeGoreJetzFiltern=By.xpath("(//button[@value='Jetzt filtern...'])[1]");
   By lSecileneGoreSıralananUrunler =By.cssSelector("div.astra-shop-thumbnail-wrap");
   By lCinsiyeteGoreFiltrelemeInput=By.xpath("(//input[@class='select2-search__field'])[4]");
   By lCinsiyeteGoreJetzFiltern=By.xpath("(//button[@value='Jetzt filtern...'])[4]");

   By lUrunCinsiyetKontrol=By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_gender td");
   By lBedeneGoreFiltrelemeInput=By.xpath("(//input[@class='select2-search__field'])[2]");
   By lBedeneGoreJetzFiltern=By.xpath("(//button[@value='Jetzt filtern...'])[2]");
   By lUrunBedenKontrol=By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_groesse td");

    By lMalzemeyeGoreFiltrelemeInput=By.xpath("(//input[@class='select2-search__field'])[3]");
    By lMalzemeyeGoreJetzFiltern=By.xpath("(//button[@value='Jetzt filtern...'])[3]");
    By lUrunMalzemeKontrol=By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_material td");
    By lFavoriUrunListSec=By.cssSelector("div.yith-wcwl-add-button a i.yith-wcwl-icon.fa.fa-heart-o");

    By lFavoriUrunIsimList=By.cssSelector("div.astra-shop-summary-wrap a h2"); //tüm ürünler isim
    By lFavoriButton=By.xpath("(//div[@class='ast-custom-button'])[2]"); //Wunschliste butonu
    By lFavoriListesindekiUrunIsimleriList=By.cssSelector("tbody.wishlist-items-wrapper tr td.product-name"); //Wunschliste deki ürünler

    By lSonGoruntulenenler=By.cssSelector(".product-title");//h2[@class='widget-title']

    By neulichAngesehen=By.xpath("(//h2[@class='widget-title'])[2]");//h2[@class='widget-title']
}
