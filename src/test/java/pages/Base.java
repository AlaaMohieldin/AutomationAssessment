package pages;

import java.io.IOException;
import java.sql.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public Select select = null;
    public Actions action = null;

    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void MouseHover(WebElement element) {
        // TODO Auto-generated method stub
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public int GetNumberOfWebElement(By elementLocation) {
        List<WebElement> NumWebelemnt = driver.findElements(elementLocation);
        return NumWebelemnt.size();
    }

    protected void clickButton(WebElement button) {

        button.click();
    }

    protected void setTextElementText(WebElement txtElement, String value) {
        txtElement.sendKeys(value);
    }

    public void scrollToButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public String GetText(WebElement element) {
        return element.getText();}

    public String GetAttribute(WebElement element, String value) {
        return element.getAttribute(value);}

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
    }

    public boolean isElementPresent(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    protected void WaitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void scrolltoElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public String DateFormate(String source) throws ParseException {
        final String OLD_FORMAT = "yyyy/MM/dd";
        final String NEW_FORMAT = "dd/MM/yyyy";
        // August 12, 2010
        String oldDateString = source;
        String newDateString;
        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(oldDateString);
        sdf.applyPattern(NEW_FORMAT);
        return newDateString = sdf.format(d);
    }

    public void MouseClick(WebElement element) {
        action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    public void MoveToTab(int tab) {

        ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(availableWindows.get(tab));
    }
    public void SwitchtoFrame(WebElement element) {

        driver.switchTo().frame(element);

    }

}
