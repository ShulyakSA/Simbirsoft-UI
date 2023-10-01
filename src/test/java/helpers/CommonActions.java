package helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import static helpers.Waits.*;

public class CommonActions extends BasePage {
    @Step("Открыть страницу {url}")
    public static void open(String url) {
        driver.get(url);
    }

    @Step("Ввод значения '{value}'")
    public static void input(WebElement element, String value) {
        waitElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    @Step("Нажать на элемент:")
    public static void submitWithWaiting(WebElement element) {
        waitElementIsVisible(element);
        element.submit();
    }

    @Step("Нажать на элемент:")
    public static void clickWithWaiting(WebElement element) {
        waitElementIsClickable(element);
        element.click();
    }

    @Step("Перейти к алерту")
    public static Alert switchToAlert() {
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    @Step("Подтвердить алерт")
    public static void alertAccept(Alert alert) {
        alert.accept();
    }
}
