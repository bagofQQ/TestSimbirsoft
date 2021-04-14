package com.test;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    private WebDriver webDriver;

    protected ProfilePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(className = "user-account__name")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(text(), 'Почта')]")
    private WebElement userPost;

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

    @FindBy(xpath = "//span[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']")
    private WebElement resultIncomingMail;

    @FindBy(className = "mail-ComposeButton-Text")
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
    protected void clickUserMenu() {
        userMenu.click();
    }

    @Step
    protected void clickUserPost() {
        userPost.click();
    }

    @Step
    protected void clickSearchField() {
        searchFieldClick.click();
    }

    @Step
    protected void inputSearchString(String searchString) {
        searchField.sendKeys(searchString);
    }

    @Step
    protected void clickSearchBtn() {
        searchBtn.click();
    }

    @Step
    protected void clickFoldersBtn() throws InterruptedException {
        Thread.sleep(1500);
        foldersBtn.click();
    }

    @Step
    protected void clickIncomingBtn() {
        incomingBtn.click();
    }

    @Step
    protected String getMailCount() throws InterruptedException {
        Thread.sleep(600);
        String result = resultIncomingMail.getText();
        return result;
    }

    @Step
    protected void clickWriteLetter() {
        writeLetter.click();
    }

    @Step
    protected void inputWhomFieldString(String whomFieldString) {
        whomField.sendKeys(whomFieldString);
    }

    @Step
    protected void inputSubjectFieldString(String subjectFieldString) {
        subjectField.sendKeys(subjectFieldString);
    }

    @Step
    protected void inputTextFieldString(String textFieldString) {
        textField.sendKeys(textFieldString);
    }

    @Step
    protected void clickSendBtn() {
        sendBtn.click();
    }

    @Step
    protected void clickSentBtn() {
        sentBtn.click();
    }

    @Step
    protected void checkingMailSendGood(){
        System.out.println("Письмо отправлено");
    }

    @Step
    protected void checkingMailSendFail(){
        System.out.println("Письмо не отправлено");
    }

    @Step
    protected void clickRefreshBtn() {
        refreshBtn.click();
    }
}
