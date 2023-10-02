package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class SearchClientTest extends BaseTest {
    final String FIRST_NAME = "Ron";
    final String LAST_NAME = "Weasly";
    final String POST_CODE = "E55555";

    @Test
    @Owner("Shulyak S.A.")
    @Description("Поиск клиента")
    public void searchClientTest() {
        basePage.customersList();
        customersPage
                .inputFirstName(FIRST_NAME)
                .searchResult(FIRST_NAME)
                .searchResult(LAST_NAME)
                .searchResult(POST_CODE);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertAll();


    }

}
