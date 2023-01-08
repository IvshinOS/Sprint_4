package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Страница "Для кого самокат"
public class OrderPage {
        private final WebDriver webDriver;
        public OrderPage(WebDriver webDriver){
                this.webDriver = webDriver;
        }

//Поле Имя
        private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
//Поле Фамилия
        private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
//Поле Адрес
        private By fieldAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
//Поле Станция метро
        private By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");
//Элемент выпадающего списка с названием станции метро
        private By stationMetro = By.xpath("//li[@data-value='1']");
//Поле Телефон
        private By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
//Кнопка Далее
        private By buttonNext = By.xpath("//button[text()='Далее']");
//Ввод имени в поле Имя
        public void inputName (String name){
                webDriver.findElement(fieldName).sendKeys(name);
        }
//Ввод фалимии в поле Фамилия
        public void inputSurname (String surname){
                webDriver.findElement(fieldSurname).sendKeys(surname);
        }
//Ввод адреса в поле Адрес
        public void inputAdress (String adress){
                webDriver.findElement(fieldAdress).sendKeys(adress);
        }
//Выбор станции метро из списка
        public void selectStationMetro(int numberStation){
                stationMetro = By.xpath("//li[@data-value='"+numberStation+"']");
                webDriver.findElement(fieldMetro).click();
                webDriver.findElement(stationMetro).click();
        }
//Ввод номера телефона в поле Телефон
        public void inputPhone (String phoneNumber){
                webDriver.findElement(fieldPhone).sendKeys(phoneNumber);
        }
//Нажатие на кнопку Далее
        public void clickButtonNext (){
                webDriver.findElement(buttonNext).click();
        }
}
