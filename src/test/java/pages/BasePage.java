package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static helpers.CommonActions.*;

public class BasePage {
    protected static WebDriver driver;
    @FindBy(xpath = "//div/button[@ng-click='addCust()']")
    private WebElement addCustomer;
    @FindBy(xpath = "//div/button[@ng-click='openAccount()']")
    private WebElement openAccount;
    @FindBy(xpath = "//div/button[@ng-click='showCust()']")
    private WebElement customers;
    public BasePage() {
        open(System.getProperty("url"));
        PageFactory.initElements(driver, this);

    }
    public static void setDriver(final WebDriver webDriver) {
        try {
            driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Нажать на кнопку 'Add Customer'")
    public BasePage addCustomer() {
        clickWithWaiting(addCustomer);
        return this;
    }
    @Step("Нажать на кнопку 'Customers'")
    public BasePage customersList() {
        clickWithWaiting(customers);
        return this;
    }



}
