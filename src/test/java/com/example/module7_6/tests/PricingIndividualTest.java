package com.example.module7_6.tests;


import com.example.module7_6.pages.CookieSettingsPage;
import com.example.module7_6.pages.PricingIndividualPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PricingIndividualTest extends BaseTest {

    private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    private PricingIndividualPage pricingIndividualPage = new PricingIndividualPage(getDriver(), wait);
    private CookieSettingsPage cookieSettingsPage = new CookieSettingsPage(getDriver(), wait);

    @BeforeEach
    public void setup() {
        getDriver().get("https://www.jetbrains.com/store/?section=personal&billing=yearly");
    }

    @BeforeEach
    @Step("Принимаем куки")
    public void clickCookie() {
        cookieSettingsPage.displayTitle();
        Assertions.assertTrue(cookieSettingsPage.displayButton(),
                "Кнопка не отображается");
        cookieSettingsPage.clickButtonAcceptAll();
    }

    @Test
    @DisplayName("Проверка, что кнопка покупки пакета на год доступна")
    public void enabledBuyYear() {
        Assertions.assertTrue(pricingIndividualPage.enabledButtonPackYear(),
                "Кнопка покупки пакета на год недоступна");
    }

    @Test
    @DisplayName("Проверка, что можно переключиться на страницу")
    public void clickSwitchMonthly() {
        Assertions.assertTrue(pricingIndividualPage.enabledSwitchMonthly(),
                "Не получилось переключиться на страницу месячных подписок");
        pricingIndividualPage.clickSwitchMonthly();
        pricingIndividualPage.NoDisplayTitleSecondYear();
    }

    @Test
    @DisplayName("Проверка, что переключились на вкладку для студентов и учителей")
    public void clickTabStudents() {
        pricingIndividualPage.clickTabStudents();
        Assertions.assertTrue(pricingIndividualPage.displayTitleClassroom(),
                "Заголовок \"For classroom assistance free\" не отобразился");
    }
}
