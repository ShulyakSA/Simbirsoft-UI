package helpers;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

import static helpers.CommonActions.alertAccept;
import static helpers.CommonActions.switchToAlert;
import static helpers.Waits.waitElementIsVisible;

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
    @Step("Проверить сортировку списка 'First Name'")
    public static void checkSortList(List<String> expectedList,List<String> actualList) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCollection(expectedList).isEqualTo(actualList);
    }
    @Step("Проверить значение '{expectedText}' в строке таблицы")
    public static void checkTableRow(WebElement element, String expectedText) {
        waitElementIsVisible(element);
        String actualText=element.findElement(By.xpath(String.format("./tr[1]/td[contains(text(),'%s')]", expectedText))).getText();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
    }

}
