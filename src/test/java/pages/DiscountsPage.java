package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DiscountsPage {
    public DiscountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement forCustomersButton;
    @FindBy(xpath = "((//ul[@data-popper-placement='bottom-start'])[1]/li/a)[1]")
    public WebElement discountCatalog;
    @FindBy(xpath = "//h4")
    public WebElement titleOfDiscountPage;
    @FindBy(xpath = "//section[@class='page-catalog page-container my-5']/div[1]/div[2]/div[2]/div/div")
    public List<WebElement> listOfGoods;
    @FindBy(xpath = "//img[@alt='Каталог']")
    public WebElement catalogBanner;

    @FindBy(xpath = "//div[@class='sorting-button dropdown']/button")
    public WebElement sortingButton;
    @FindBy(xpath = "//div[@x-placement='bottom-end']/a[1]")
    public WebElement sortByIncreasingPrice;
    @FindBy(xpath = "//div[@x-placement='bottom-end']/a[2]")
    public WebElement sortByDecreasingPrice;
    @FindBy(xpath = "//div[@x-placement='bottom-end']/a[3]")
    public WebElement sortByIncreasingDiscount;
    @FindBy(xpath = "//div[@x-placement='bottom-end']/a[4]")
    public WebElement sortByDecreasingDiscount;
    @FindBy(xpath = "//div[@x-placement='bottom-end']/a//label")
    public List<WebElement> listOfSortingNames;


    @FindBy(xpath = "//h2[@class='accordion-header']/button")
    public WebElement menuProductCategories;
    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> listOfAllGoodsCategories;
    @FindBy(xpath = "//div[@class='px-0 text-center accordion-body']//label[2]")
    public List<WebElement> listOfCategoryNames;

    @FindBy(xpath = "//div[@class='position-relative']//span[1]")
    public List<WebElement> listOfDiscounts;
    @FindBy(xpath = "//div[@class='position-relative']//span[2]")
    public List<WebElement> listOfGoodsPrices;

}