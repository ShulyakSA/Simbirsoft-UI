package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriver driver=null;
        switch (System.getProperty("browser")) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions()
                        .addArguments("--headless=new")
                        .addArguments("--remote-allow-origins=*"));

                break;
            case "MOZILLA":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions()
                        .addArguments("--headless")
                        .addArguments("--remote-allow-origins=*")
                        .addArguments("--no-sandbox")
                        .addArguments("--disable-dev-shm-usage"));
                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME->" + System.getProperty("browser"));

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("implicit_wait")), TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        return driver;
    }
}
