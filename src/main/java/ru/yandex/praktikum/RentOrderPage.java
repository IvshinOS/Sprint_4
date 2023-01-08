package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Страница "Про аренду"
public class RentOrderPage {
    private final WebDriver webDriver;
    public RentOrderPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
//Поле "Когда привезти самокат"
    private By fieldWhen = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
//Дата из календаря
    private By date = By.xpath(".//div[5]/div[2][@role='button']");
//Поле "Срок аренды"
    private By fieldHowLong = By.className("Dropdown-placeholder");
//Элемент из списка "Срок аренды"
    private By countDays = By.xpath(".//div[text()='сутки']");
    //Чек-бокс для выбора цвета самоката
    private By colorScooter = By.xpath("//label[@for='grey']");
//Поле "Комментарий для курьера"
    private By commentCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");
//Кнопка "Заказать"
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

//Выбор даты привоза самоката
    public void selectDate(int weekDay){
        date = By.xpath(".//div[5]/div["+weekDay+"][@role='button']");
        webDriver.findElement(fieldWhen).click();
        webDriver.findElement(date).click();
    }

//Выбор срока аренды
    public void selectCountDays(String sumDays){
        countDays = By.xpath(".//div[text()='"+sumDays+"']");
        webDriver.findElement(fieldHowLong).click();
        webDriver.findElement(countDays).click();
    }

//Выбор цвета самоката
    public void selectColorScooter(String color){
        colorScooter = By.xpath("//label[@for='"+color+"']");
        webDriver.findElement(colorScooter).click();
    }

//Ввод комментария для курьера
    public void enterComment(String comment){
        webDriver.findElement(commentCourier).sendKeys(comment);
    }

//Нажатие на кнопку "Заказать"
    public void clickOrderButton(){
        webDriver.findElement(orderButton).click();
    }
}
