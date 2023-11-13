package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
     ElementsCollection products = $$(By.xpath(" //div[@id='schema-products']"));

     public SelenideElement schemaHeaderText = $(By.xpath("//div[@class='schema-header']/h1"));

     //span[contains(@data-bind,'.full_name')]     название продуктов;
     //span[contains(@data-bind,'.minPrice')]      цена продуктов
     //div[@class="schema-product__status"]  нет в наличии
     //div[@class="schema-product__offers"] количество предложений


     //div[contains(@class, "schema-product")]


     public SelenideElement getSchemaHeadText() {
          return schemaHeaderText;
     }

}
//span[contains(@data-bind,'.minPrice')]