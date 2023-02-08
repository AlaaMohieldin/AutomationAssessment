package stepDefinations;

import static org.testng.Assert.assertTrue;

import Utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import runner.Runner;
import static org.testng.Assert.assertEquals;

public class StepDefination extends Runner {
    ExcelUtil excel = new ExcelUtil ();
    // WebDriver driver = super.Driver;
    Base base = new Base(Driver);
    KSRTCHome KSRTChome = new KSRTCHome(Driver);
    AmazonHome AmazonHome = new AmazonHome(Driver);

    @Given  ("Open Amazon Website")
    public void OpenAmazon() throws Throwable {
        Driver.get("http://www.amazon.com/");
    }

    @Given  ("Open KSRTC Portal")
    public void OpenKSRTPortal() throws Throwable {
        Driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
    }

    @When("Click Route Selection")
    public void OpenLivePosting() throws Throwable {
        KSRTChome.ClickRouteSelection();
    }
    @And("Click Return Date")
    public void CompleteLiveMaps() throws Throwable {
        KSRTChome.ClickReturnDate();
    }
    @And("Click Search For Buses")
    public void ClickSearchButton() throws Throwable {
        KSRTChome.ClickSearch();
    }
    @And("Select Seat")
    public void SelectSeat() throws Throwable {
        KSRTChome.SelectSeat();
    }

    @When("User Add Item To Cart")
    public void ItemaAdedToCart() {
        AmazonHome.SearchForCaraccessories();
        AmazonHome.SelectItem();
    }

    @Then("Item Is Added Successfully")
    public void ItemAddedSuccessfully() {
        AmazonHome.GotoCartPage();
        WebElement itempresent = Driver.findElement(By.xpath("//*[contains(text(),'JUSTTOP Car Trash Can with Lid')][2]"));
        Assert.assertEquals(true, itempresent.isDisplayed());
    }

    @When("Filter The Products in Todays Deals")
    public void FilterTheProductsInTodaysDeals() {
        AmazonHome.TodaysDeals();
    }

    @Then("Add item from Deals to Cart")
    public void AddTheItemToTheCart() {
        AmazonHome.SelectDealsItem();
    }


}