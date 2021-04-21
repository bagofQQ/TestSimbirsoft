package com.test;

import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static LoginPage loginPage;
    private static ProfilePage profilePage;
    private static WebDriver webDriver;
    private static String nodeUrl;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        nodeUrl = ConfProperties.getProperty("nodeUrl");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        webDriver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("loginpage"));
    }

    @Epic("TESTING FOR https://mail.yandex.ru")
    @Feature(value = "Login Tests")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test, we will login and check the work of the mail")
    @Story(value = "LoginTest1")
    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage.clickSearchField();
        profilePage.inputSearchString("Simbirsoft Тестовое задание");
        profilePage.clickSearchBtn();
        profilePage.clickFoldersBtn();
        profilePage.clickIncomingBtn();
        int incomingMailCount = profilePage.getIncomingMailCount();
        profilePage.clickWriteLetter();
        profilePage.inputWhomFieldString(ConfProperties.getProperty("email"));
        profilePage.inputSubjectFieldString("Simbirsoft Тестовое задание. Алексеев");
        profilePage.inputTextFieldString("Количество входящих писем - " + String.valueOf(incomingMailCount));
        profilePage.clickSendBtn();
        profilePage.clickRefreshBtn();
        profilePage.clickFoldersBtn();
        profilePage.clickSentBtn();
        int sentMailCount = profilePage.getSentMailCount();
        Assert.assertFalse("Письмо не отправлено", profilePage.checkingMailSend(incomingMailCount,sentMailCount));
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
