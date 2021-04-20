package com.test;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProfilePage {
    private WebDriver webDriver;

    ProfilePage(WebDriver webDriver) {
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
    private WebElement resultMailCount;
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
    void clickUserMenu() {
        userMenu.click();
    }

    @Step
    void clickUserPost() {
        userPost.click();
    }

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
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(span, 'Папки')]")));
        foldersBtn.click();
    }

    @Step
    void clickIncomingBtn() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Входящие']/ancestor::div[@class='control menu__item menu__item_type_option']")));
        incomingBtn.click();
    }

    @Step
    String getMailCountAfterSort(String resultMailCountBeforeSort) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(webDriver1 -> {
            String resultMailCountAfterSort = webDriver.findElement(By.xpath("//span[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']")).getText();
            if (resultMailCountAfterSort.equals(resultMailCountBeforeSort)) {
                return false;
            }
            return true;
        });
        String result = resultMailCount.getText();
        return result;
    }

    @Step
    String getMailCountBeforeSort() {
        String result = resultMailCount.getText();
        return result;
    }

    @Step
    void clickWriteLetter() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
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
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Отправленные']/ancestor::div[@class='control menu__item menu__item_type_option']")));
        sentBtn.click();
    }

    @Step
    void checkingMailSend(String incomingMail, String sentMail) {
        String incomingMailNumber = incomingMail.replaceAll("[^0-9]", "");
        String sentMailNumber = sentMail.replaceAll("[^0-9]", "");
        int incomingMailCount = Integer.parseInt(incomingMailNumber);
        int sentMailCount = Integer.parseInt(sentMailNumber);
        int differenceToCheck = sentMailCount - incomingMailCount;
        Assert.assertTrue("Письмо отправлено", differenceToCheck == 1);
        Assert.assertFalse("Письмо не отправлено", differenceToCheck != 1);
    }

    @Step
    void clickRefreshBtn() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'mail-ComposeButton-Refresh js-main-action-refresh ns-action')]")));
        refreshBtn.click();
    }
}
