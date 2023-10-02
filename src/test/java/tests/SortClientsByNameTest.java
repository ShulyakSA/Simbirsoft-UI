package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


public class SortClientsByNameTest extends BaseTest{

    @Test
    @Owner("Shulyak S.A.")
    @Description("Сортировка клиентов по имени")
    public void sortClientsByNameTest() {
        basePage.customersList();
        customersPage
                .clickToFirstNameLink()
                .firstNameСolumnListDesс()
                .clickToFirstNameLink()
                .firstNameСolumnList();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertAll();

    }
}

