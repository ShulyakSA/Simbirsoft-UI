package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static steps.MainSteps.*;

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
        inputField(firstNameInput, "First Name", userFirstName);
        return this;
    }

    @Step("Ввести в поле 'Last Name' значение '{userLastName}'")
    public AddCustomerPage inputLastName(String userLastName) {
        inputField(lastNameInput, "Last Name", userLastName);
        return this;
    }

    @Step("Ввести в поле 'Post Code' значение '{postCode}'")
    public AddCustomerPage inputPostCode(String postCode) {
        inputField(postCodeInput, "Post Code", postCode);
        return this;
    }

    @Step("Нажать на кнопку 'Add Customer'")
    public AddCustomerPage clickButtonAddCustomer() {
        clickWithWaiting(addCustomerButton, "Add Customer");
        return this;
    }
}
