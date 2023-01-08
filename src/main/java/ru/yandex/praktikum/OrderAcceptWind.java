package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Окно "Хотите оформить заказ?"
public class OrderAcceptWind {
    private final WebDriver webDriver;
    public OrderAcceptWind(WebDriver webDriver){
        this.webDriver = webDriver;
    }

// Кнопка "Да"
    private  By yesButton = By.xpath("//button[text()='Да']");

    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }
}
