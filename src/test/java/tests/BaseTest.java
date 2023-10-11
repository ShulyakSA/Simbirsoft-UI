package tests;
/**
 * Класс базового теста. Реализует общие методы для всех тестовых классов
 */

import config.TestConfigFactory;
import helpers.WebDriverFactory;
import helpers.TestListener;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AddCustomerPage;
import pages.BasePage;
import pages.CustomersPage;

import static pages.BasePage.setDriver;
import static steps.MainSteps.openPage;

@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected AddCustomerPage addCustomerPage;
    protected CustomersPage customersPage;
    protected BasePage basePage;
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static TestConfigFactory config = TestConfigFactory.getInstance();

    /**
     * Инициализация драйвера и страниц, открытие страницы
     */
    @BeforeEach
    void init() {
        driver.set(WebDriverFactory.createWebDriver());
        setDriver(driver.get());
        addCustomerPage = new AddCustomerPage();
        customersPage = new CustomersPage();
        basePage = new BasePage();
        openPage(config.getWebConfig().getUrl());
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void teardown() {
        clearCookiesAndLocalStorage();
        if (!config.getWebConfig().isHoldBrowserOpen()) {
            driver.get().quit();
        }
    }

    @Step("Очистка кэша")
    void clearCookiesAndLocalStorage() {
        if (config.getWebConfig().isClearCookies()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver.get();
            driver.get().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
}