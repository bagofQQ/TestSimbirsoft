package com.test;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class ProfilePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    ProfilePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    @FindBy(className = "search-input__text-bubble-container")
    private WebElement searchFieldClick;
    @FindBy(className = "textinput__control")
    private WebElement searchField;
    @FindBy(xpath = "//*[contains(text(), 'Найти')]/..")
    private WebElement searchBtn;
    @FindBy(xpath = "//*[contains(span, 'Папки')]")
    private WebElement foldersBtn;
    @FindBy(xpath = "//span[text()='Входящие']/ancestor::div[@class='control menu__item menu__item_type_option']")
    private WebElement incomingBtn;
    @FindBy(xpath = "//div[@class='mail-MessageSnippet-Wrapper']//span[text()='Входящие']")
    private List<WebElement> mailIncomingList;
    @FindBy(xpath = "//div[@class='mail-MessageSnippet-Wrapper']//span[text()='Отправленные']")
    private List<WebElement> mailSentList;
    @FindBy(xpath = "//*[contains(@class, 'mail-ComposeButton js-main-action-compose')]")
    private WebElement writeLetter;
    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    private WebElement whomField;
    @FindBy(xpath = "//*[contains(@class, 'composeTextField ComposeSubject-TextField')]")
    private WebElement subjectField;
    @FindBy(xpath = "//*[contains(@class, 'cke_htmlplaceholder')]")
    private WebElement textField;
    @FindBy(xpath = "//*[contains(span, 'Отправить')]")
    private WebElement sendBtn;
    @FindBy(xpath = "//span[text()='Отправленные']/ancestor::div[@class='control menu__item menu__item_type_option']")
    private WebElement sentBtn;
    @FindBy(xpath = "//*[contains(@class, 'mail-ComposeButton-Refresh js-main-action-refresh ns-action')]")
    private WebElement refreshBtn;

    @Step
    void clickSearchField() {
        searchFieldClick.click();
    }

    @Step
    void inputSearchString(String searchString) {
        searchField.sendKeys(searchString);
    }

    @Step
    void clickSearchBtn() {
        searchBtn.click();
    }

    @Step
    void clickFoldersBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(span, 'Папки')]")));
        foldersBtn.click();
    }

    @Step
    void clickIncomingBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Входящие']/ancestor::div[@class='control menu__item menu__item_type_option']")));
        incomingBtn.click();
    }

    @Step
    int getIncomingMailCount() {
        return mailIncomingList.size();
    }

    @Step
    int getSentMailCount() {
        return mailSentList.size();
    }

    @Step
    void clickWriteLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'mail-ComposeButton js-main-action-compose')]")));
        writeLetter.click();
    }

    @Step
    void inputWhomFieldString(String whomFieldString) {
        whomField.sendKeys(whomFieldString);
    }

    @Step
    void inputSubjectFieldString(String subjectFieldString) {
        subjectField.sendKeys(subjectFieldString);
    }

    @Step
    void inputTextFieldString(String textFieldString) {
        textField.sendKeys(textFieldString);
    }

    @Step
    void clickSendBtn() {
        sendBtn.click();
    }

    @Step
    void clickSentBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Отправленные']/ancestor::div[@class='control menu__item menu__item_type_option']")));
        sentBtn.click();
    }

    @Step
    boolean checkingMailSend(int incomingMailCount, int sentMailCount) {
        return sentMailCount - incomingMailCount != 1;
    }

    @Step
    void clickRefreshBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'mail-ComposeButton-Refresh js-main-action-refresh ns-action')]")));
        refreshBtn.click();
    }
}
