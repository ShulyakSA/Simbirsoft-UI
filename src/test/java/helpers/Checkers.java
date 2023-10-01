package helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pages.BasePage;

import static helpers.CommonActions.alertAccept;
import static helpers.CommonActions.switchToAlert;
public class Checkers extends BasePage {
    @Step("Проверить текст алерта")
    public static void checkAlertText(String value) {
        Alert alert=switchToAlert();
        checkText(alert.getText(), value);
        alertAccept(alert);
    }
    @Step("Сравнить текст с ожидаемым")
    public static void checkText(String actual, String expected) {
        Assertions.assertEquals(actual, expected);
    }
}
