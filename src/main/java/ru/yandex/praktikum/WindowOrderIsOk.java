package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowOrderIsOk {
    private final WebDriver webDriver;
    public WindowOrderIsOk(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    private By textOkInWindow = By.xpath("//div[text()='Заказ оформлен']");

    public boolean isVisibleTextOkInWindow() {
        return webDriver.findElement(textOkInWindow).isDisplayed();
    }
}
