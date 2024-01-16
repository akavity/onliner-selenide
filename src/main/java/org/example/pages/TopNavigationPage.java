package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigationPage {
    public SelenideElement getTopMenuItem(String topMenuItemName) {
        return $(By.xpath("//div[@class='b-top-menu']//span[contains(text(), '" + topMenuItemName + "')]"));
    }

    public SelenideElement getClassifierItem(String classifierItemName) {
        return $(By.xpath("//ul[contains(@class, 'catalog-na')]//li//span[contains(text()," +
                " '" + classifierItemName + "')]"));
    }

    public SelenideElement getAsideListItem(String dataId, String asideItemName) {
        return $(By.xpath("//div[@data-id='" + dataId + "']//div[contains(text(),'" + asideItemName + "')]/.."));
    }

    public SelenideElement getDropDownItem(String dataId, String asideItemName, String dropDownItemName) {
        return $(By.xpath("//div[@data-id='" + dataId + "']//div[contains(text()," +
                " '" + asideItemName + "')]//..//span[contains(text(), '" + dropDownItemName + "')]/ancestor::a"));
    }
}
