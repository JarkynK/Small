package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

  @FindBy(xpath = "//button[@type='button'][2]")
    public WebElement switchLanguageButton;
    @FindBy(xpath = "(//li[@class='nav-item flex-grow-1 dropdown'])[1]/a/span")
    public WebElement forCustomersNavbar;
    @FindBy(xpath = "(//li[@class='nav-item flex-grow-1 dropdown'])[2]/a")
    public WebElement stocksNavbar;
    @FindBy(xpath = "(//li[@class='nav-item flex-grow-1 dropdown'])[3]/a")
    public WebElement careerNavbar;
    @FindBy(xpath = "(//li[@class='nav-item flex-grow-1 dropdown'])[4]/a/span")
    public WebElement businessNavBar;
    @FindBy(xpath = "(//li[@class='nav-item flex-grow-1 dropdown'])[5]/a")
    public WebElement aboutUsNavBar;


    @FindBy(xpath = "(//div[@class='footer-menu-col'])[1]//h5")
    public WebElement forCustomers;
    @FindBy(xpath = "(//div[@class='footer-menu-col'])[1]/ul/li/a")
    public List<WebElement> listOfOffersForCustomer;

    @FindBy(xpath = "(//div[@class='footer-menu-col'])[2]//h5")
    public WebElement forBusiness;
    @FindBy(xpath = "(//div[@class='footer-menu-col'])[2]/ul/li/a")
    public List<WebElement> listOfBusinessOffers;

    @FindBy(xpath = "(//div[@class='footer-menu-col'])[3]//h5")
    public WebElement careerInSmall;
    @FindBy(xpath = "(//div[@class='footer-menu-col'])[3]/ul/li/a")
    public List<WebElement> listOfCareerOffers;

    @FindBy(xpath = "//button[@class='btn-red-gradient btn']")
    public WebElement feedBackButton;
}