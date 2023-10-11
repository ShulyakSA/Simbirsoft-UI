package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

import static steps.Checkers.checkSortList;
import static steps.Checkers.checkTableRow;
import static steps.MainSteps.*;

public class CustomersPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'First Name')]")
    private WebElement firstNameLink;
    @FindBy(xpath = "//table/tbody")
    private WebElement tableBody;
    @FindBy(xpath ="./tr/td[1]" )
    private List<WebElement> tableRows;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerInput;

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на ссылку 'First Name'")
    public CustomersPage clickFirstNameLink() {
        clickWithWaiting(firstNameLink, "First Name");
        return this;
    }

    @Step("Получить список результатов поиска в столбце 'First Name' в обратном порядке")
    public CustomersPage getListFirstNameReverse() {
        List<String> actualList = getList(tableRows);
        List<String> expectedList = getSortedList(actualList);
        Collections.sort(expectedList, Collections.reverseOrder());
        checkSortList(expectedList, actualList);
        return this;
    }

    @Step("Получить список результатов поиска в столбце 'First Name' в алфавитном порядке")
    public CustomersPage getListFirstName() {
        List<String> actualList = getList(tableRows);
        List<String> expectedList = getSortedList(actualList);
        Collections.sort(expectedList);
        checkSortList(expectedList, actualList);
        return this;
    }

    @Step("Ввести в поле 'Search Customer' значение '{customer}'")
    public CustomersPage inputFirstName(String customer) {
        inputField(searchCustomerInput, "Search Customer", customer);
        return this;
    }

    @Step("Получить значение '{expectedText}' в результатах поиска")
    public CustomersPage getSearchResult(String expectedText) {
        waitElementIsVisible(tableBody);
        String actualText=tableBody.findElement(By.xpath(String.format("./tr[1]/td[contains(text(),'%s')]", expectedText))).getText();
        checkTableRow(actualText, expectedText);
        return this;
    }
}
