package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigationPage {
    public SelenideElement topMenuItem(String topMenuItemName) {
        return $(By.xpath("//div[@class='b-top-menu']//span[contains(text(), '" + topMenuItemName + "')]"));
    }

    public SelenideElement classifierItem(String classifierItemName) {
        return $(By.xpath("//ul[contains(@class, 'catalog-na')]//li//span[contains(text()," +
                " '" + classifierItemName + "')]"));
    }

    public SelenideElement asideListItem(String dataId, String asideItemName) {
        return $(By.xpath("//div[@data-id='" + dataId + "']//div[contains(text(),'" + asideItemName + "')]"));
    }
//    //div[@data-id='" + data_id + "']//div[contains(text(),'" + sectionOfNavigation + "')]
    //div[contains(text(), '" + sectionName + "')]

    public SelenideElement dropDownItem(String dataId, String asideItemName, String dropDownItemName) {
        return $(By.xpath("//div[@data-id='" + dataId + "']//div[contains(text()," +
                " '" + asideItemName + "')]//..//span[contains(text(), '" + dropDownItemName + "')]"));
    }

    //div[contains(text(), 'sectionOfAsideList')]//..//a[contains(@href, 'sectionOfDropdownList')]
    // //div[contains(text(), 'Мобил')]//..//a[contains(@href, 'headphones')]
    //div[contains(text(), 'Мобил')]//..//span[contains(text(), 'Фитнес')]
    //div[contains(@class, 'aside catalog')]//div[contains(text(), 'Ноутбуки')]



    ////div[@data-id='1']//div[contains(text(), 'Моб')]//..//span[contains(text(), 'Фитнес-браслеты')]


    ////div[contains(text(), '" + sectionOfAsideList + "')]//..//span[contains(text(), '"
    //                + sectionOfDropdownList + "')]
}
