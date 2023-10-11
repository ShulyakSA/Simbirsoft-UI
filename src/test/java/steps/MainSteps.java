package steps;
/**
 * В классе реализованы шаги основные шаги
 */

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class MainSteps extends BasePage {

    @Step("Открытие страницы {url}")
    public static void openPage(String url) {
        driver.get(url);
    }

    @Step("Ввод значения '{value}' в поле '{elementName}'")
    public static void inputField(WebElement element, String elementName, String value) {
        waitElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    @Step("Нажатие на элемент '{elementName}'")
    public static void clickWithWaiting(WebElement element, String elementName) {
        waitElementIsClickable(element);
        element.click();
    }

    @Step("Переход к алерту")
    public static Alert switchToAlert() {
        waitAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    @Step("Подтверждение алерта")
    public static void alertAccept(Alert alert) {
        alert.accept();
    }

    @Step("Получение списка значений")
    public static List<String> getList(List<WebElement> rows) {
        List<String> list = new ArrayList<>();
        try {
            for (WebElement row : rows) {
                list.add(row.getText());
            }
        } catch (NullPointerException e) {
            LOGGER.error("List is empty");
            e.printStackTrace();
        }
        return list;
    }

    @Step("Получение отсортированного списка значений")
    public static List<String> getSortedList(List<String> rows) {
        List<String> list = new ArrayList<>();
        try {
            for (String row : rows) {
                list.add(row);
            }
        } catch (NullPointerException e) {
            LOGGER.error("List is empty");
            e.printStackTrace();
        }
        return list;
    }
}
