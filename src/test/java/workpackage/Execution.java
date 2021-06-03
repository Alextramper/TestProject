package workpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import workpackage.manage.ManageTest;
import workpackage.page.LoginPage;
import workpackage.page.MailPage;
import workpackage.platform.WebdriverFactory;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс для запуска тестов
 */
public class Execution {

    String hubURLAdress = "http://localhost:4444/wd/hub";
    String pageUrl = "https://mail.yandex.ru/";
    String login = "MrDady2016";
    String password = "qwerty123456";
    String searchFilter = "папка:Входящие тема:";
    String theme = searchFilter + "\"Simbirsoft -Тестовое задание\"";
    String toEmail = "krainov2012@yandex.ru";
    int count;
    URL hubUrl;
    WebDriver webDriver = WebdriverFactory.getChromeDriver(hubUrl);
    LoginPage loginPage = new LoginPage(webDriver);
    MailPage mailPage = new MailPage(webDriver);
    By cssSelector = new By.ByCssSelector("div[class='ComposeDoneScreen-Wrapper'");

    {
        try {
            hubUrl = getURL(hubURLAdress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Тест авторизации на почте yandex
     */
    @Test
    public void firstTest() {
        loginPage.openPage(pageUrl);
        loginPage.logInToMail(login, password);
        Assert.assertFalse(loginPage.getWebTitle().contains("Входящие"));
    }

    /**
     * Тест считывания количества писем с темой
     */
    @Test()
    public void secondTest() {
        ManageTest.waitPage(webDriver,3);
        setCount(mailPage.countMessages(theme));
        Assert.assertEquals(count, 3);
    }

    /**
     * Тест отправки
     */
    @Test()
    public void thirdTest() {
        mailPage.sendMessage(count, theme, toEmail);
        ManageTest.waitPage(webDriver, 3);
        Assert.assertTrue(webDriver.findElement(cssSelector).isEnabled());
    }

    @AfterTest
    public void stopSession() {
        if(webDriver!=null) {
            webDriver.quit();
            System.out.println("Driver is stopped");
        }
    }

    URL getURL(String urlAdress) throws MalformedURLException {
        return new URL(urlAdress);
    }
}
