package helpers;
/**
 * Класс реализует настройку драйвера и кроссбраузерность
 */

import config.TestConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private static TestConfigFactory config=TestConfigFactory.getInstance();

    /**
     * Выбор браузра в зависимости от значения, указанного в файле 'test.conf'
     * @return возвращает драйвер в зависимости от выбранного браузера
     */
    public static WebDriver createWebDriver() {
        switch (config.getWebConfig().getBrowser()) {
            case "CHROME":
                return getChromedriver();
            case "MOZILLA":
                return getFirefoxDriver();
            default:
                return getChromedriver();
        }
    }

    /**
     * Настройка Chrome-драйвера
     * @return возвращает экземпляр chrome-драйвера
     */
    private static ChromeDriver getChromedriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions()
                //.addArguments("--headless=new")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--window-size=1920,1080"));
    }

    /**
     * Настройка Firefox-драйвера
     * @return возвращает экземпляр firefox-драйвера
     */
    private static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(new FirefoxOptions()
                .addArguments("--headless")
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--window-size=1920,1080"));
    }
}
