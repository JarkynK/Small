package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.Config;
import utilities.Driver;
import utilities.Wait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageSwitchTest {

    MainPage mainPage = new MainPage();

    @BeforeClass
    public void setup() {
        String url = Config.getProperty("url");
        Driver.getDriver().get(url);     //launching the small.kz page
    }

    @Test
    public void mainHeaderLanguageSwitchToKazakh() {

            String russianText1 = "Покупателям";
            String russianText2 = "Акции";
            String russianText3 = "Карьера";
            String russianText4 = "Бизнесу";
            String russianText5 = "О нас";

            //проверка контектса страницы на русский язык
            Assert.assertEquals(russianText1, mainPage.forCustomersNavbar.getText());
            Assert.assertEquals(russianText2, mainPage.stocksNavbar.getText());
            Assert.assertEquals(russianText3, mainPage.careerNavbar.getText());
            Assert.assertEquals(russianText4, mainPage.businessNavBar.getText());
            Assert.assertEquals(russianText5, mainPage.aboutUsNavBar.getText());

            mainPage.switchLanguageButton.click(); // переключение на казахскиий язык

            String kazahk1 = "Сатып алушыларға";
            String kazakh2 = "Науқан";
            String kazakh3 = "Мансап";
            String kazakh4 = "Бизнеске";
            String kazakh5 = "Біз туралы";

            Wait.exWait(mainPage.forCustomersNavbar);
            //проверка контекста на казахский язык
            Assert.assertEquals(kazahk1, mainPage.forCustomersNavbar.getText());
            Assert.assertEquals(kazakh2, mainPage.stocksNavbar.getText());
            Assert.assertEquals(kazakh3, mainPage.careerNavbar.getText());
            Assert.assertEquals(kazakh4, mainPage.businessNavBar.getText());
            Assert.assertEquals(kazakh5, mainPage.aboutUsNavBar.getText());

    }

    @Test
    public void verifyOfferForCustomers(){

        String forCustomers = "Покупателям";
       Assert.assertEquals(forCustomers,mainPage.forCustomers.getText());

        List<String> expectedValues = Arrays.asList("Каталог", "Акции", "Магазины", "Оптовик", "Новости");

        //  фактические результаты
        List<String> actualValues = new ArrayList<>();
        for (WebElement element : mainPage.listOfOffersForCustomer) {
            actualValues.add(element.getText());
        }
        Assert.assertEquals(actualValues, expectedValues, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

        String feedbackRus = "Обратная связь";
        Assert.assertEquals(feedbackRus, mainPage.feedBackButton.getText()); // проверка техтса кнопки "Обратная связь"

        // переход на казахскиий язык
        mainPage.switchLanguageButton.click();

        String forCustomersKaz = "Сатып алушыларға";
        Assert.assertEquals(forCustomersKaz, mainPage.forCustomers.getText());

        List<String> expectedValKaz = Arrays.asList("Каталог", "Акциялар", "Дүкендер", "Көтерме сауда", "Жаңалықтар");

        //  фактические результаты
        List<String> actualValKaz = new ArrayList<>();
        for (WebElement element : mainPage.listOfOffersForCustomer) {
            actualValKaz.add(element.getText());
        }
        Assert.assertEquals(actualValKaz, expectedValKaz, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

        String feedBackKaz = "Кері байланыс";
        Assert.assertEquals(feedBackKaz, mainPage.feedBackButton.getText());  // проверка текст кнопки обратная связь

    }


    @Test
    public void verifyBusinessOffers(){

        String forBusiness = "Бизнесу";
        Assert.assertEquals(forBusiness, mainPage.forBusiness.getText());

        List<String> expectedValues = Arrays.asList("Реклама", "Партнерство", "Выписать ЭСФ", "Сдать нам площадь", "Снять у нас площадь");

        //  фактические результаты
        List<String> actualValues = new ArrayList<>();
        for (WebElement element : mainPage.listOfBusinessOffers) {
            actualValues.add(element.getText());
        }
        Assert.assertEquals(actualValues, expectedValues, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата


        mainPage.switchLanguageButton.click(); // переключение на казахскиий язык

        Wait.exWait(mainPage.forBusiness);
        String forBusinessKaz = "Бизнеске";
        Assert.assertEquals(forBusinessKaz, mainPage.forBusiness.getText());

        List<String> expectedValKaz = Arrays.asList("Жарнама", "Партнерство", "ЭШФ шығарy", "Бізге аудан жалға беру", "Бізден аудан жалға алу");

        //  фактические результаты
        List<String> actualValKaz = new ArrayList<>();
        for (WebElement eachElement : mainPage.listOfBusinessOffers){
            actualValKaz.add(eachElement.getText());
        }
        Assert.assertEquals(actualValKaz, expectedValKaz, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

    }

    @Test
    public void verifyCareerOffers(){

        String forBusiness = "Карьера";
        Assert.assertEquals(forBusiness, mainPage.careerInSmall.getText());

        List<String> expectedValues = Arrays.asList("Работа в SMALL", "Мой Казахстан", "Eco SMALL");

        //  фактические результаты
        List<String> actualValues = new ArrayList<>();
        for (WebElement element : mainPage.listOfCareerOffers) {
            actualValues.add(element.getText());
        }
        Assert.assertEquals(actualValues, expectedValues, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

        mainPage.switchLanguageButton.click(); // переключение на казахскиий язык

        String forBusinessKaz = "Карьера";
        Assert.assertEquals(forBusinessKaz, mainPage.careerInSmall.getText());

        List<String> expectedValKaz = Arrays.asList("Жұмыс", "Біздің Қазақстан", "Eco SMALL");

        //  фактические результаты
        List<String> actualValKaz = new ArrayList<>();
        for (WebElement element : mainPage.listOfCareerOffers) {
            actualValKaz.add(element.getText());
        }
        Assert.assertEquals(actualValKaz, expectedValKaz, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

    }

    @AfterClass
    public void closing() {
        Driver.closeDriver();   // закрытие драйвера
    }
}
