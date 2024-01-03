package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.AccommodationPage;

@Log4j2
public class AccommodationSteps {
    AccommodationPage accommodation = new AccommodationPage();

    @Step
    public int getPrice() {
        int result = Integer.parseInt(accommodation.getPriceField().getText()
                .replace("$", "")
                .replace(" ", ""));
        log.info("Accommodation price: " + result);
        return result;
    }

    @Step
    public int getNumberRooms() {
        int number = Integer.parseInt(accommodation.getNumberRoomsField().getText()
                .replace("-комнатная квартира", ""));
        log.info("Number rooms: " + number);
        return number;
    }

    @Step
    public double getArea() {
        double area = Double.parseDouble(accommodation.getAreaField().getText()
                .replace(" м","")
                .replace(",","."));
        log.info("Area of accommodation: " + area);
        return area;
    }
}
