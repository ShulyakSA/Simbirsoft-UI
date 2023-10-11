package pages;
/**
 * Класс базовой страницы. Реализует общие методы для всех страниц
 */

import config.TestConfigFactory;
import helpers.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static steps.MainSteps.*;

public class BasePage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
    public static TestConfigFactory config=TestConfigFactory.getInstance();
    protected static WebDriverWait wait;

    @FindBy(xpath = "//div/button[@ng-click='addCust()']")
    private WebElement addCustomer;
    @FindBy(xpath = "//div/button[@ng-click='openAccount()']")
    private WebElement openAccount;
    @FindBy(xpath = "//div/button[@ng-click='showCust()']")
    private WebElement customers;

    public BasePage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getWebConfig().getExplicitWait()));
    }

    /**
     * Передача драйвера из базового теста на страницы
     * @param webDriver принимает WebDriver
     */
    public static void setDriver(final WebDriver webDriver) {
        try {
            driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ожидание видимости элемента
     * @param element получает объект WebElement
     */
    protected static void waitElementIsVisible(WebElement element) {
        wait.until(visibilityOf(element));
    }

    /**
     * Ожидание сликабельности элемента
     * @param element получает объект WebElement
     */
    protected static void waitElementIsClickable(WebElement element) {
        wait.until(elementToBeClickable(element));
    }

    /**
     * Ожидание появления алерта
     */
    protected static void waitAlertIsPresent() {
        wait.until(alertIsPresent());
    }

    @Step("Нажать на кнопку 'Add Customer'")
    public BasePage addCustomer() {
        clickWithWaiting(addCustomer, "Add Customer");
        return this;
    }

    @Step("Нажать на кнопку 'Customers'")
    public BasePage clickButtonCustomersList() {
        clickWithWaiting(customers, "Customers");
        return this;
    }
}
