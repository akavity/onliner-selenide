package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.TopNavigationPage;

@Log4j2
public class TopNavigationSteps {
    TopNavigationPage topNavigation = new TopNavigationPage();

    @Step("Click top menu item")
    public void clickTopMenuItem(String topMenuItemName) {
        log.info("Click top menu item: " + topMenuItemName);
        topNavigation.getTopMenuItem(topMenuItemName).click();
    }

    @Step("Click classifier item")
    public void clickClassifierItem(String classifierItemName) {
        log.info("Click classifier item: " + classifierItemName);
        topNavigation.getClassifierItem(classifierItemName).click();
    }

    @Step("Click aside list item")
    public void clickAsideListItem(String classifierItemName, String asideItemName) {
        String dataId = getDataId(classifierItemName);
        log.info("Click aside list item: " + asideItemName);
        topNavigation.getAsideListItem(dataId, asideItemName).click();
    }

    @Step("Click drop down item")
    public void clickDropDownItem(String classifierItemName, String asideItemName, String dropDownItemName) {
        String dataId = getDataId(classifierItemName);
        log.info("Click drop down item: " + dropDownItemName);
        topNavigation.getDropDownItem(dataId, asideItemName, dropDownItemName).click();
    }

    @Step("Click authorization button")
    public void clickAuthorizationButton() {
        topNavigation.getAuthButton().click();
        log.info("Click the authorization button");
    }

    public String getDataId(String classifierItemName) {
        String id = "";
        switch (classifierItemName) {
            case "Электроника":
                id = "1";
                break;
            case "Компьютеры":
                id = "2";
                break;
            case "Бытовая техника":
                id = "3";
                break;
            case "Стройка":
                id = "4";
                break;
            case "Дом":
                id = "5";
                break;
            case "Авто":
                id = "6";
                break;
            case "Красота":
                id = "7";
                break;
            case "Детям":
                id = "8";
                break;
            case "На каждый":
                id = "9";
                break;
            case "Onlíner":
                id = "12";
                break;
            case "Зроблена":
                id = "brand-0";
                break;
            case "Суперцены":
                id = "brand-1";
                break;
            case "Игровая":
                id = "brand-2";
                break;
            case "BOSH":
                id = "brand-3";
                break;
            case "LG":
                id = "brand-4";
                break;
            case "XIAOMI":
                id = "brand-5";
                break;
            case "SAMSUNG":
                id = "brand-6";
                break;
            case "APPLE":
                id = "brand-7";
                break;
        }
        return id;
    }
}
