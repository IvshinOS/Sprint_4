package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

// Главная страница
public class MainPage{
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    // Кнопка закрытия уведомления и куки
    private By cookieButton = By.id("rcc-confirm-button");
//Пункт списка "Вопросы о важном"
    private By accordionHeading = By.id("accordion__heading-0");
//Выпадающий список
    private By accordionPanel = By.xpath(".//div[@id='accordion__panel-0']/p");
// Кнопка "Заказать" верхняя
    private By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Открытие сайта
    public void openMainPage(){
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Нажатие кнопки "да все привыкли" в окне сообщения о куки
    public void clickCookieButton (){
        webDriver.findElement(cookieButton).click();
    }

//Нажатие на определенныый элемент списка "Вопросы о важном"
    public void clickAccordionHeading(int num_heading){
        accordionHeading = By.id("accordion__heading-"+num_heading);
        webDriver.findElement(accordionHeading).click();
    }
//Прокрутка до списка "Вопросы о важном"
    public void scrollToAccordingHeading(){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(accordionHeading));
    }
    public void sclollToOrderButton(String choseOrderButton){
        buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g"+choseOrderButton+"']");
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(buttonOrder));
    }
//Получение текста из выпавшего элемента списка "Вопросов о важном"
    public String getTextAccordionPanel(int num_heading){
        accordionPanel = By.xpath(".//div[@id='accordion__panel-"+num_heading+"']/p");
        return webDriver.findElement(accordionPanel).getText();
    }

    //Нажатие на кнопку "Заказать" с выбором верхней или нижней
    public void clickButtonOrder(String choseOrderButton){
        buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g"+choseOrderButton+"']");
        webDriver.findElement(buttonOrder).click();
    }
}
