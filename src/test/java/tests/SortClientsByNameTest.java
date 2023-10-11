package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortClientsByNameTest extends BaseTest{

    @Test
    @Owner("Shulyak S.A.")
    @DisplayName("Сортировка клиентов по имени")
    @Description("Проверка сортировки клентов полю 'First Name'")
    public void sortClientsByNameTest() {
        basePage.clickButtonCustomersList();
        customersPage
                .clickFirstNameLink()
                .getListFirstNameReverse()
                .clickFirstNameLink()
                .getListFirstName();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertAll();
    }
}

