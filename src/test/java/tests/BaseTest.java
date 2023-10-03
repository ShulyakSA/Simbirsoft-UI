package tests;

import helpers.DriverFactory;
import helpers.TestListener;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AddCustomerPage;
import pages.BasePage;
import pages.CustomersPage;

import java.io.IOException;
import java.time.LocalTime;

@ExtendWith(TestListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    public WebDriver driver;
    protected AddCustomerPage addCustomerPage;
    protected CustomersPage customersPage;
    protected BasePage basePage;
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);


    @BeforeAll
    void loadProperties() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("START TIME:" + LocalTime.now());
    }

    @BeforeEach
    void init() {
        driver = DriverFactory.createDriver();
        addCustomerPage = new AddCustomerPage();
        customersPage = new CustomersPage();
        basePage = new BasePage();
    }

    @AfterEach
    @Step("Очистка кэша")
    void clearCookiesAndLocalStorage() {
        if (Boolean.valueOf(System.getProperty("clear_cookies"))) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    @Step("Закрытие браузера")
    void teardown() {
        if (!Boolean.valueOf(System.getProperty("hold_browser_open"))) {
            driver.quit();
        }
    }
}