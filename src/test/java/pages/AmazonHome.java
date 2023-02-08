package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AmazonHome extends Base {
    WebDriver driver;


    @FindBy(id="twotabsearchtextbox")
    WebElement txt_searchBar ;

    @FindBy(id="nav-search-submit-button")
    WebElement btn_submitSearch;

    @FindBy(xpath = "//span[contains(text(),'JUSTTOP Car Trash Can with Lid')]")
    WebElement txt_itemName;

    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement btn_Deals;

    @FindBy(id = "nav-cart-count")
    WebElement btn_Cart;

    @FindBy(id="add-to-cart-button")
    WebElement btn_itemAdded;

    @FindBy(xpath = "//span[contains(text(),'Headphones')]")
    WebElement btn_Headphones;

    @FindBy(xpath = "//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][normalize-space()='Grocery']")
    WebElement btn_Grocery;

    @FindBy(xpath = "//span[contains(text(),'10%')]")
    WebElement btn_Discount;

    @FindBy(xpath = "//a[contains(text(),'3')]")
    WebElement btn_thirdpage;

    @FindBy(xpath = "//a[contains(text(),'4')]")
    WebElement btn_fourthpage;

    @FindBy(xpath = "//div[contains(text(),'Active Noise Cancelling Bluetooth Earbuds')]")
    WebElement btn_item;

    public AmazonHome(WebDriver driver) {
        super(driver);
    }

    public void SearchForCaraccessories()
    {
        setTextElementText(txt_searchBar,"Car Accessories");
        clickButton(btn_submitSearch);
    }

    public void SelectItem()
    {
        clickButton(txt_itemName);
        clickButton(btn_itemAdded);
    }

    public void GotoCartPage()
    {
        clickButton(btn_Cart);
    }
    public void TodaysDeals(){
        WaitForElement(btn_Deals);
        clickButton(btn_Deals);
        clickButton(btn_Headphones);
        clickButton(btn_Grocery);
        clickButton(btn_Discount);
        WaitForElement(btn_thirdpage);
        scrolltoElement(btn_thirdpage);
        clickButton(btn_thirdpage);
        WaitForElement(btn_fourthpage);
        clickButton(btn_fourthpage);
    }

    public void SelectDealsItem(){
        WaitForElement(btn_item);
        scrolltoElement(btn_item);
        clickButton(btn_item);
    }

}
