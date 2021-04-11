package com.test;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_mail')]")
    private WebElement userPost;

    @FindBy(xpath = "//*[contains(@class, 'control textinput textinput_theme_normal textinput_view_default textinput_size_n textinput_has-icon_yes textinput_icon-right_yes textinput_tone_mail-suggest-themed search-input__form-input')]")
    private WebElement searchFieldClick;

    @FindBy(xpath = "//*[contains(@class, 'textinput__control')]")
    private WebElement searchField;

    @FindBy(xpath = "//*[contains(text(), 'Найти')]/..")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    private WebElement foldersBtn;

    @FindBy(css = "body > div.popup2.popup2_view_default.popup2_theme_normal.popup2_direction_bottom-left.popup2_visible_yes.popup2_target_anchor > div > div > div:nth-child(1)")
    private WebElement incomingBtn;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/span/span")
    private WebElement resultIncomingMail;

    @FindBy(xpath = "//*[contains(@class, 'mail-ComposeButton-Text')]")
    private WebElement writeLetter;

    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    private WebElement whomField;

    @FindBy(xpath = "//*[contains(@class, 'composeTextField ComposeSubject-TextField')]")
    private WebElement subjectField;

    @FindBy(xpath = "//*[contains(@class, 'cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder')]")
    private WebElement textField;

    @FindBy(xpath = "//*[contains(@class, 'control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action')]")
    private WebElement sendBtn;

    @Step
    public void clickUserMenu() {
        userMenu.click();
    }

    @Step
    public void clickUserPost() {
        userPost.click();
    }

    @Step
    public void clickSearchField() {
        searchFieldClick.click();
    }

    @Step
    public void inputSearchString(String searchString) {
        searchField.sendKeys(searchString);
    }

    @Step
    public void clickSearchBtn() {
        searchBtn.click();
    }

    @Step
    public void clickFoldersBtn() {
        foldersBtn.click();
    }

    @Step
    public void clickIncomingBtn() {
        incomingBtn.click();
    }

    @Step
    public String getIncomingMail() throws InterruptedException {
        Thread.sleep(300);
        String result = resultIncomingMail.getText();
        return result;
    }

    @Step
    public void clickWriteLetter() {
        writeLetter.click();
    }

    @Step
    public void inputWhomFieldString(String whomFieldString) {
        whomField.sendKeys(whomFieldString);
    }

    @Step
    public void inputSubjectFieldString(String subjectFieldString) {
        subjectField.sendKeys(subjectFieldString);
    }

    @Step
    public void inputTextFieldString(String textFieldString) {
        textField.sendKeys(textFieldString);
    }

    @Step
    public void clickSendBtn() {
        sendBtn.click();
    }

}
