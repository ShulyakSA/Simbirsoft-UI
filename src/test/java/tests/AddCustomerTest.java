package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import steps.Checkers;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

public class AddCustomerTest extends BaseTest{
    @Test
    @Owner("Shulyak S.A.")
    @DisplayName("Создание клиента")
    public void addCustomerTest() {
        basePage.addCustomer();
        addCustomerPage
                .inputFirstName(config.getTestConfig().getFirstName())
                .inputLastName(config.getTestConfig().getLastName())
                .inputPostCode(config.getTestConfig().getPostCode())
                .clickButtonAddCustomer();
        Checkers.checkAlertText(config.getTestConfig().getAlertText());
        basePage.clickButtonCustomersList();
        customersPage
                .inputFirstName(config.getTestConfig().getFirstName())
                .getSearchResult(config.getTestConfig().getFirstName())
                .getSearchResult(config.getTestConfig().getLastName())
                .getSearchResult(config.getTestConfig().getPostCode());
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertAll();
    }
}

