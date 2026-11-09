package com.example.module7_6.pages;

import com.example.module7_6.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class CookieSettingsPage {

    private final AllureLogger log = new AllureLogger(LoggerFactory.getLogger(CookieSettingsPage.class));
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[@id='ch2-dialog-title']")
    private WebElement titleCookieSettings;

    @FindBy(xpath = "//button[contains(text(),'Accept All')]")
    private WebElement buttonAcceptAll;

    public void displayTitle() {
        log.info("Ждём, когда появится окно с куки");
        wait.until(ExpectedConditions.visibilityOf(titleCookieSettings));
    }

    public boolean displayButton() {
        log.infoWithScreenshot("Проверка, что кнопка принятия куки отображается");
        return buttonAcceptAll.isDisplayed();
    }

    public void clickButtonAcceptAll() {
        log.info("Кликаем по кнопке Accept All");
        wait.until(ExpectedConditions.elementToBeClickable(buttonAcceptAll));
        buttonAcceptAll.click();
    }

    public CookieSettingsPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
