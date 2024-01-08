package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.AccommodationPage;
import org.example.utils.Utils;

@Log4j2
public class AccommodationSteps {
    AccommodationPage accommodation = new AccommodationPage();
    Utils utils = new Utils();

    @Step
    public int getPrice() {
        String text = accommodation.getPriceField().getText();
        log.info("Get text: " + text);
        int result = utils.extractIntFromText(text, "\\d*[ ]\\d{3}([ ]\\d{3})?");
        log.info("Accommodation price: " + result);
        return result;
    }

    @Step
    public int getNumberRooms() {
        String text = accommodation.getNumberRoomsField().getText();
        log.info("Get text: " + text);
        int number = utils.extractIntFromText(text, "\\d+");
        log.info("Number rooms: " + number);
        return number;
    }

    @Step
    public double getArea() {
        String text = accommodation.getAreaField().getText();
        log.info("Get text: " + text);
        double area = utils.extractDoubleFromText(text, "\\d+,?\\d{1,2}");
        log.info("Area of accommodation: " + area);
        return area;
    }
}
