package com.test;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


class LoginPage {
    private WebDriver webDriver;

    LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(id = "passp-field-login")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;
    @FindBy(id = "passp-field-passwd")
    private WebElement passwdField;

    @Step
    void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step
    void inputPasswd(String password) {
        passwdField.sendKeys(password);
    }

    @Step
    void clickLoginBtn() {
        loginBtn.click();
    }
}
