package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DiscountsPage;
import utilities.Config;
import utilities.Driver;
import utilities.SortClass;
import utilities.Wait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NavigationTest {

    DiscountsPage discountsPage = new DiscountsPage();
    Random random = new Random();

    @BeforeClass
    public void setup() {
        String url = Config.getProperty("url");
        Driver.getDriver().get(url);     //launching the small.kz page
    }

    @BeforeMethod
    public void bMethod() {

        discountsPage.forCustomersButton.click(); //Переход в выпадающий список "Покупателям"
        discountsPage.discountCatalog.click();  // Переход на страницу "Каталог скидок"
    }

    @Test
    public void verificationDiscountPageDetails() {
        //Верификация страницы/детали каталог скидок/товаров

        String title = "Каталог товаров"; //ожидаемое название страницы
        Assert.assertEquals(title, discountsPage.titleOfDiscountPage.getText()); // Верификация страницы

        String sort = "Cортировка";
        Assert.assertEquals(sort, discountsPage.sortingButton.getText());  // Верификация вападающего меню "Сортировка"

        String productCategories = "Категории товаров";
        Assert.assertEquals(productCategories, discountsPage.menuProductCategories.getText()); // Верификация вападающего меню "Каталог товаров"

        Assert.assertTrue(discountsPage.catalogBanner.isDisplayed());  // // Верификация баннера "Small Каталог"

        int expectedSizeOfGoods = 16; // ожидаемое количевство товаров
        int actualSizeOfGoods = discountsPage.listOfGoods.size();// фактическое количество товаров
        Assert.assertEquals(expectedSizeOfGoods, actualSizeOfGoods); //Верификация количевство товаров на странице каталог скидок
    }


    @Test
    public void eachCategoriesTextVerification() throws Exception {

        // ожидаемые значения сортировочного меню
        List<String> expectedSortValues = Arrays.asList("по увеличению цены", "по уменьшению цены", "по увеличению скидки", "по уменьшению скидки");

        Wait.exWait(discountsPage.sortingButton);

        discountsPage.sortingButton.click();// переход в выпадающий список сортировки

        //фактические результаты
        List<String> actualSortValues = new ArrayList<>();
        for (WebElement element : discountsPage.listOfSortingNames) {
            actualSortValues.add(element.getText());
        }
        Assert.assertEquals(actualSortValues, expectedSortValues, "The actual values do not match the expected values.");  //проверка ожидаемых резултатов и фактических результатов

        Wait.exWait(discountsPage.menuProductCategories);

        discountsPage.menuProductCategories.click();   // выпадающий список меню категории
        Thread.sleep(500);

        //ожидаемые результаты
        List<String> expectedValues = Arrays.asList("Выпечка и хлеб", "Бакалея", "Бытовая химия", "Собственное производство", "Гигиена и косметика", "Для животных", "Заморозка",
                "Здоровое питание", "Колбаса, деликатесы", "Консервация", "Кулинария", "Мясо, птица, рыба", "Напитки", "Сладости", "Соусы и заправки", "Товары для детей", "Молочные продукты, яйцо", "Чай, кофе");

        //  фактические результаты
        List<String> actualValues = new ArrayList<>();
        for (WebElement element : discountsPage.listOfCategoryNames) {
            actualValues.add(element.getText());
        }
        Assert.assertEquals(actualValues, expectedValues, "The actual values do not match the expected values.");  // проверка ожидаемого результата и фактического результата

    }

    @Test
    public void checkPriceSorting() {

        Wait.exWait(discountsPage.sortingButton);

        discountsPage.sortingButton.click();// переход в выпадающий список сортировки

        discountsPage.sortByIncreasingPrice.click(); // выбор вид сортировки: по увелечению цены

        SortClass.ascendingOrder(discountsPage.listOfGoodsPrices); // Верификация по увелечении цены

        discountsPage.sortingButton.click();// переход в выпадающий список сортировки

        Wait.exWait(discountsPage.sortByDecreasingPrice);

        discountsPage.sortByDecreasingPrice.click();  // выбор вид сортировки: по уменьшению цены

        SortClass.descendingOrder(discountsPage.listOfGoodsPrices);  // верификация список товара отображен по уменешении цены

    }

    @Test
    public void checkDiscountSorting() {

        discountsPage.sortingButton.click();// переход в выпадающий список сортировки
        discountsPage.sortByIncreasingDiscount.click();  // выбор : по увеличении скидки
        SortClass.ascendingOrder(discountsPage.listOfDiscounts);  // верификация список товаров отображены по увеличению скидки


        discountsPage.sortingButton.click();// переход в выпадающий список сортировки
        discountsPage.sortByDecreasingDiscount.click();  // выбор : скидки по убыванию
        SortClass.descendingOrder(discountsPage.listOfDiscounts);  // верификация список товаров отображены по убыванию скидки

    }


    @Test
    public void checkEachCategoriesCheckbox() throws Exception {
        Wait.exWait(discountsPage.menuProductCategories);  //явное ожидание элемента пока загрузится

        discountsPage.menuProductCategories.click(); //открытие выпадающего списка меню категории товаров

        Thread.sleep(1000);

        discountsPage.listOfAllGoodsCategories.get(random.nextInt(17) + 1).click();  //рандомный выбор категории

        for (WebElement eachCheckbox : discountsPage.listOfAllGoodsCategories) {
            if (eachCheckbox.isSelected()) {        // поиск выбранной категории

                Assert.assertTrue(eachCheckbox.isSelected());   // проверка что выбрана категория
            }
        }
        int amountOfGoods = discountsPage.listOfGoods.size();
        System.out.println(amountOfGoods);   //  количества видов товара в данной категории

    }

    @AfterClass
    public void closing() {
        Driver.closeDriver();  // закрытие дривера
    }
}