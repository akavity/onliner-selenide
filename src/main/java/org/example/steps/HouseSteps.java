package org.example.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.HousePage;

@Log4j2
public class HouseSteps {
    HousePage housePage = new HousePage();

    @Step
    public void enterMinValueOfLimit(String title, String minValue) {
        log.info("enter Min value of " + title + ": " + minValue);
        SelenideElement element = housePage.getMinValueField(title);
        element.click();
        element.sendKeys(minValue);
    }

    @Step
    public void enterMaxValueOfLimit(String title, String maxValue) {
        log.info("enter Max value of " + title + ": " + maxValue);
        SelenideElement element = housePage.getMaxValueField(maxValue);
        element.click();
        element.sendKeys(maxValue);
    }

    @Step
    public void choseNumberOfRooms(int number) {
        log.info("Number of rooms: " + number);
        housePage.getNumberOfRooms(number).click();
    }

    @Step
    public void clickTypeHomeButton(String type) {
        log.info("Type house: " + type);
        housePage.getTypeHouseButton(type).click();
    }

    @Step
    public void choseMaterial(String material) {
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
        log.info("Chose material" + material);
        housePage.getMaterialElement(material).click();
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
    }
    @Step
    public void choseMaterial(String material, String material2) {
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
        log.info("Chose material" + material);
        housePage.getMaterialElement(material).click();
        log.info("Chose material2" + material2);
        housePage.getMaterialElement(material2).click();
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
    }

    @Step
    public void choseMaterial(String material, String material2, String material3) {
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
        log.info("Chose material" + material);
        housePage.getMaterialElement(material).click();
        log.info("Chose material2" + material2);
        housePage.getMaterialElement(material2).click();
        log.info("Chose material3" + material3);
        housePage.getMaterialElement(material3).click();
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
    }

    @Step
    public void choseMaterial(String material, String material2, String material3, String material4) {
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
        log.info("Chose material" + material);
        housePage.getMaterialElement(material).click();
        log.info("Chose material2" + material2);
        housePage.getMaterialElement(material2).click();
        log.info("Chose material3" + material3);
        housePage.getMaterialElement(material3).click();
        log.info("Chose material4" + material4);
        housePage.getMaterialElement(material4).click();
        log.info("Click material drop down");
        housePage.getMaterialsDropDown().click();
    }

//    @Step
//    public void clickMaterialDropDown() {
//        log.info("Click material drop down");
//        housePage.getMaterialsDropDown().click();
//    }
//
//    @Step
//    public void clickMaterialElement(String material) {
//        housePage.getMaterialElement(material).click();
//    }

    @Step
    public void clickUnsuitableFloorButton() {
        log.info("Click unsuitable floor Button");
        housePage.getUnsuitableFloorButton().click();
    }

    @Step
    public void enterAddress(String address) {
        log.info("Enter address: " + address);
        housePage.getAddressField().sendKeys(address);
    }
}
