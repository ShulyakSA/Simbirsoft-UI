package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

import static helpers.Checkers.checkSortList;
import static helpers.Checkers.checkTableRow;
import static helpers.CommonActions.*;

public class CustomersPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'First Name')]")
    private WebElement firstNameLink;
    @FindBy(xpath = "//table/tbody")
    private WebElement tableBody;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerInput;

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на ссылку 'First Name'")
    public CustomersPage clickToFirstNameLink() {
        clickWithWaiting(firstNameLink);
        return this;
    }

    @Step("Проверить сортировку столбца 'First Name' в обратном порядке")
    public CustomersPage firstNameСolumnListDesс() {
        List<WebElement> rows = tableBody.findElements(By.xpath("./tr/td[1]"));
        List<String> actualList = toActualList(rows);
        List<String> expectedList = toExpectedList(actualList);
        Collections.sort(expectedList, Collections.reverseOrder());
        checkSortList(expectedList, actualList);
        return this;
    }

    @Step("Проверить сортировку столбца 'First Name' в алфавитном порядке")
    public CustomersPage firstNameСolumnList() {
        List<WebElement> rows = tableBody.findElements(By.xpath("./tr/td[1]"));
        List<String> actualList = toActualList(rows);
        List<String> expectedList = toExpectedList(actualList);
        Collections.sort(expectedList);
        checkSortList(expectedList, actualList);
        return this;
    }

    @Step("Ввести в поле 'Search Customer' значение '{customer}'")
    public CustomersPage inputFirstName(String customer) {
        input(searchCustomerInput, customer);
        return this;
    }

    @Step("Проверить значение '{value}' в результатах поиска")
    public CustomersPage searchResult(String value) {
        checkTableRow(tableBody, value);
        return this;
    }

}
