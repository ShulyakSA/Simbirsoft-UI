package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.CommonActions.*;

public class AddCustomerPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeInput;
    @FindBy(xpath = "//button[text()='Add Customer']")
    private WebElement addCustomerButton;

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Ввести в поле 'First Name' значение '{userFirstName}'")
    public AddCustomerPage inputFirstName(String userFirstName) {
        input(firstNameInput, userFirstName);
        return this;
    }
    @Step("Ввести в поле 'Last Name' значение '{userLastName}'")
    public AddCustomerPage inputLastName(String userLastName) {
        input(lastNameInput, userLastName);
        return this;
    }
    @Step("Ввести в поле 'Post Code' значение '{postCode}'")
    public AddCustomerPage inputPostCode(String postCode) {
        input(postCodeInput, postCode);
        return this;
    }
    @Step("Нажать на кнопку 'Add Customer'")
    public AddCustomerPage buttonAddCustomer() {
        submitWithWaiting(addCustomerButton);
        return this;
    }

}
