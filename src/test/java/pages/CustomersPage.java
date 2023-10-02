package pages;

import helpers.Checkers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

import static helpers.CommonActions.*;

public class CustomersPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'First Name')]")
    WebElement firstNameLink;
    @FindBy(xpath = "//table/tbody")
    private WebElement tableBody;

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на ссылку 'First Name'")
    public CustomersPage clickToFirstNameLink() {
        clickWithWaiting(firstNameLink);
        return this;
    }
    @Step("Проверить сортировку списка 'First Name' в обратном порядке")
    public CustomersPage firstNameСolumnListDesс() {
        List<WebElement> rows=tableBody.findElements(By.xpath("./tr/td[1]"));
        List<String> actualList=toActualList(rows);
        List<String> expectedList=toExpectedList(actualList);
        Collections.sort(expectedList, Collections.reverseOrder());
        Checkers.checkSortList(expectedList, actualList);
        return this;
    }
    @Step("Проверить сортировку списка 'First Name' в алфавитном порядке")
    public CustomersPage firstNameСolumnList() {
        List<WebElement> rows=tableBody.findElements(By.xpath("./tr/td[1]"));
        List<String> actualList=toActualList(rows);
        List<String> expectedList=toExpectedList(actualList);
        Collections.sort(expectedList);
        Checkers.checkSortList(expectedList, actualList);
        return this;
    }


}
