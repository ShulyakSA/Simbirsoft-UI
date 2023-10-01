package tests;

import helpers.Checkers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;


public class AddCustomerTest extends BaseTest{
    final String FIRST_NAME="Михаил";
    final String LAST_NAME="Тестов";
    final String POST_CODE="E58856";
    final String ALLERT_TEXT="Customer added successfully with customer id :6";
    @Test
    @Owner("Shulyak S.A.")
    @Description("Создание клиента")
    public void addCustomerTest() {
        basePage.addCustomer();
        addCustomerPage
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputPostCode(POST_CODE)
                .buttonAddCustomer();
        Checkers.checkAlertText(ALLERT_TEXT);
    }
}

