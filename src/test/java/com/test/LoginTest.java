package com.test;

import io.qameta.allure.*;
import org.junit.AfterClass;
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

    @Epic("TESTING FOR https://passport.yandex.ru")
    @Feature(value = "Login Tests")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test, we will login and check the work of the mail")
    @Story(value = "LoginTest1")
    @Test
    public void loginTest() throws InterruptedException {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        profilePage.clickUserMenu();
        profilePage.clickUserPost();
        profilePage.clickSearchField();
        profilePage.inputSearchString("Simbirsoft Тестовое задание");
        profilePage.clickSearchBtn();
        String resultMailCountBeforeSortIncoming = profilePage.getMailCountBeforeSort();
        profilePage.clickFoldersBtn();
        profilePage.clickIncomingBtn();
        String incomingMail = profilePage.getMailCountAfterSort(resultMailCountBeforeSortIncoming);
        profilePage.clickWriteLetter();
        profilePage.inputWhomFieldString(ConfProperties.getProperty("email"));
        profilePage.inputSubjectFieldString("Simbirsoft Тестовое задание. Алексеев");
        profilePage.inputTextFieldString(incomingMail);
        profilePage.clickSendBtn();
        profilePage.clickRefreshBtn();
        String resultMailCountBeforeSortSent = profilePage.getMailCountBeforeSort();
        profilePage.clickRefreshBtn();
        profilePage.clickFoldersBtn();
        profilePage.clickSentBtn();
        String sentMail = profilePage.getMailCountAfterSort(resultMailCountBeforeSortSent);
        profilePage.checkingMailSend(incomingMail, sentMail);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
