package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.MainPage;

import static org.junit.Assert.assertEquals;

//Тест текста в выпадающем списке в разделе «Вопросы о важном»
@RunWith(Parameterized.class)
    public class CheckImportantQuestionsTextInDropDownList extends TestBase {
        int num_heading;
        String result;

        public CheckImportantQuestionsTextInDropDownList(int num_heading,String result){
            this.num_heading=num_heading;
            this.result=result;
        }

        @Parameterized.Parameters
        public static Object[][] getTextData(){
            return new Object[][]{
                    {0,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {1,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {2,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
            };
        }
    @Test
    public void checkDropDownList(){
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookieButton();
        mainPage.scrollToAccordingHeading();
        mainPage.clickAccordionHeading(num_heading);
        assertEquals("Сообщение верное.",result, mainPage.getTextAccordionPanel(num_heading));
    }
}

