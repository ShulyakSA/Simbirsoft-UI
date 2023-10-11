package steps;
/**
 * В классе реализованы шаги с проверками
 */

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import pages.BasePage;

import java.util.List;

import static steps.MainSteps.alertAccept;
import static steps.MainSteps.switchToAlert;

public class Checkers extends BasePage {

    @Step("Проверить текст алерта")
    public static void checkAlertText(String value) {
        Alert alert=switchToAlert();
        checkText(alert.getText(), value);
        alertAccept(alert);
    }

    @Step("Сравнить текст с ожидаемым")
    public static void checkText(String actual, String expected) {
        Assertions.assertThat(actual).contains(expected);
    }

    @Step("Проверить сортировку списка 'First Name'")
    public static void checkSortList(List<String> expectedList,List<String> actualList) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCollection(expectedList).isEqualTo(actualList);
    }

    @Step("Проверить значение '{expectedText}' в строке таблицы")
    public static void checkTableRow(String actualText, String expectedText) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
    }
}
