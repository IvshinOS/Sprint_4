package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.*;

import static org.junit.Assert.assertTrue;

//Тест удачного заказа самоката
@RunWith(Parameterized.class)
public class OrderingScooterTest extends TestBase{
    String choseOrderButton;
    String name;
    String surname;
    String adress;
    int numberStation;
    String phoneNumber;
    int weekDay;
    String sumDays;
    String color;
    String comment;

    public OrderingScooterTest (String choseOrderButton, String name,String surname,String adress, int numberStation, String phoneNumber, int weekDay, String sumDays, String color, String comment) {
        this.choseOrderButton = choseOrderButton;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.numberStation = numberStation;
        this.phoneNumber = phoneNumber;
        this.weekDay = weekDay;
        this.sumDays = sumDays;
        this.color = color;
        this.comment = comment;
    }
        @Parameterized.Parameters
        public static Object[][] getTextData(){
            return new Object[][]{
                    {"","Иван","Иванов","Проспект мира",1,"89030930033",4,"сутки","grey","Тест ввода текста"},
                    {"","Петр","Петров","улица Победы",5,"89094561237",5,"трое суток","black","Тест ввода текста2"},
                    {" Button_Middle__1CSJM","Ольга","Иванова","улица Первого мая",10,"89567894163",6,"пятеро суток","grey","Тест ввода текста3"},
                    {" Button_Middle__1CSJM","Дарья","Кузнецова","Московская улица",16,"89231478956",7,"семеро суток","black","Тест ввода текста4"}
            };
        }


    @Test
    public void orderingScooterTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButton();
        mainPage.sclollToOrderButton(choseOrderButton);
        mainPage.clickButtonOrder(choseOrderButton);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputName(name);
        orderPage.inputSurname(surname);
        orderPage.inputAdress(adress);
        orderPage.selectStationMetro(numberStation);
        orderPage.inputPhone(phoneNumber);
        orderPage.clickButtonNext();

        RentOrderPage rentOrderPage = new RentOrderPage(driver);
        rentOrderPage.selectDate(weekDay);
        rentOrderPage.selectCountDays(sumDays);
        rentOrderPage.selectColorScooter(color);
        rentOrderPage.enterComment(comment);
        rentOrderPage.clickOrderButton();

        OrderAcceptWind orderAcceptWind = new OrderAcceptWind(driver);
        orderAcceptWind.clickYesButton();

        WindowOrderIsOk windowOrderIsOk = new WindowOrderIsOk(driver);
        boolean resultOrder = windowOrderIsOk.isVisibleTextOkInWindow();
        assertTrue(resultOrder);

    }

}
