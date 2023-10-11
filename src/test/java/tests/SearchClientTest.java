package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchClientTest extends BaseTest {
    @BeforeEach
    public void beforeEach() {
        basePage.addCustomer();
        addCustomerPage
                .inputFirstName(config.getTestConfig().getFirstName())
                .inputLastName(config.getTestConfig().getLastName())
                .inputPostCode(config.getTestConfig().getPostCode())
                .clickButtonAddCustomer();
    }

    @Test
    @Owner("Shulyak S.A.")
    @DisplayName("Поиск клиента")
    @Description("Проверка поиска созданного клиента клиента по имени")
    public void searchClientTest() {
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
