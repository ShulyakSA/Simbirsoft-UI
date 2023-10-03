package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Waits extends BasePage {

    public static WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicit_wait")))).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicit_wait")))).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public static void waitAlertIsPresent() {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicit_wait")))).until(ExpectedConditions.alertIsPresent());
    }
}
