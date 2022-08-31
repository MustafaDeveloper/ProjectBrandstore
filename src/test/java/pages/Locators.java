package pages;

import org.openqa.selenium.By;

public interface Locators {
    By lcookies = By.cssSelector("p a.woocommerce-store-notice__dismiss-link");
    By lloginButton = By.xpath("(//i[@class='_mi _before far fa-user-circle'])[1]");
    By lusername = By.cssSelector("p input#username");
    By lpassword = By.cssSelector("p input#password");
    By lsubmitButton = By.xpath("(//button[@type='submit'])[2]");
    By lHomeImg = By.cssSelector("html img");

    By lMeinKonto = By.cssSelector("li.trail-item.trail-end span span");
    By lWunschListeProductNameList = By.cssSelector("td.product-name a");
    By lAlleProdukteButton = By.cssSelector("li#menu-item-45");
    By lAllButton = By.cssSelector("a[data-type='all']");
    By lAllProducts = By.cssSelector("li.ast-col-sm-12");
    By lAllProductsImages = By.cssSelector("div.astra-shop-thumbnail-wrap img");
    By lAllProductsPrices = By.cssSelector("span.price");
    By lAllProductsNames = By.cssSelector("span.ast-woo-product-category");
    By lCategoriesDropdown = By.cssSelector("#product_cat");

    By lOrderSelect = By.cssSelector("select.orderby");
    By lOrderedProductsPrice = By.cssSelector("div[class='astra-shop-summary-wrap'] span[class='price']");
    By lProducteFilterButton = By.cssSelector("span.astra-woo-filter-text");
    By lRightScroll = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
    By lLeftScroll = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]");
    By lSlipBarPrice = By.cssSelector("div.price_label");
    By lFilternButton = By.xpath("//div[@class='price_slider_amount']//button");
    By lFilterByColourInput = By.xpath("(//input[@class='select2-search__field'])[1]");
    By lSelectSelectOptions = By.cssSelector("ul[class='select2-results__options'] li");

    By lProductsInformation = By.cssSelector("li#tab-title-additional_information");
    By lProductColourCheck = By.xpath("(//td//p)[1]");
    By lColourJetzFiltern = By.xpath("(//button[@value='Jetzt filtern...'])[1]");
    By lOrderedProductsBySelected = By.cssSelector("div.astra-shop-thumbnail-wrap");
    By lFilterByGenderInput = By.xpath("(//input[@class='select2-search__field'])[4]");
    By lGenderJetzFiltern = By.xpath("(//button[@value='Jetzt filtern...'])[4]");

    By lProductGenderControl = By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_gender td");
    By lFilterBySizeInput = By.xpath("(//input[@class='select2-search__field'])[2]");
    By lSizeJetzFiltern = By.xpath("(//button[@value='Jetzt filtern...'])[2]");
    By lProductSizeControl = By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_groesse td");

    By lFilterByMaterialInput = By.xpath("(//input[@class='select2-search__field'])[3]");
    By lMaterialJetzFiltern = By.xpath("(//button[@value='Jetzt filtern...'])[3]");
    By lProductMaterialControl = By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_material td");

    By lSelectFavoriteProductList = By.cssSelector("div.yith-wcwl-add-button a i.yith-wcwl-icon.fa.fa-heart-o");
    By lFavoriteProductNameList = By.cssSelector("div.astra-shop-summary-wrap a h2");
    By lFavoriteButton = By.xpath("(//div[@class='ast-custom-button'])[2]");
    By lNeulichAngesehen = By.cssSelector(".product-title");

}
