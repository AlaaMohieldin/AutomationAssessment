package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class KSRTCHome extends Base {
    WebDriver driver;

    @FindBy(xpath = "//*[contains(@onclick,'populateSearch') and text()=' Chikkamagaluru - Bengaluru']")
    WebElement  btn_routeSelection;

    @FindBy(xpath ="//table[@class='ui-datepicker-calendar']//tr[2]//td[7]")
    WebElement  cal_DepartDate;

    @FindBy(name="txtJourneyDate")
    WebElement  btn_DepartDate;
    @FindBy(xpath ="//table[@class='ui-datepicker-calendar']//tr[4]//td[7]")
    WebElement  cal_ReturnDate;

    @FindBy(name="txtReturnJourneyDate")
    WebElement  btn_ReturnDate;

    @FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block btn-booking']")
    WebElement  btn_Search;

    @FindBy(xpath="//div[@class='rSetForward']//input[@id='SrvcSelectBtnForward0']")
    WebElement  btn_SelectSeat;



    public KSRTCHome(WebDriver driver) {
        super(driver);
    }

    public void ClickRouteSelection() throws InterruptedException {
        WaitForElement(btn_routeSelection);
        clickButton(btn_routeSelection);
    }

    public void ClickReturnDate() throws InterruptedException {
        clickButton(btn_DepartDate);
        WaitForElement(cal_DepartDate);
        clickButton(cal_DepartDate);

        clickButton(btn_ReturnDate);
        WaitForElement(cal_ReturnDate);
        clickButton(cal_ReturnDate);
    }

    public void ClickSearch() throws InterruptedException {
        scrollToButton();
        clickButton(btn_Search);

    }

    public void SelectSeat() throws InterruptedException {
        WaitForElement(btn_SelectSeat);
        clickButton(btn_SelectSeat);
    }

}

