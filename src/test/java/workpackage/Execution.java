package workpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import workpackage.page.LoginPage;
import workpackage.page.MailPage;
import workpackage.platform.WebdriverFactory;


public class Execution {

    int count;
    WebDriver webDriver = WebdriverFactory.getChromeDriver ();
    LoginPage loginPage = new LoginPage(webDriver);
    MailPage mailPage = new MailPage(webDriver);

    public void setCount(int count) {
        this.count = count;
    }

    @Test
    public void firstTest() {
        loginPage.openPage();
        loginPage.logInToMail();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("There is an exception");
        }
        Assert.assertFalse(loginPage.getWebTitle().contains("Входящие"));
    }

    @Test
    public void secondTest() {
        setCount(mailPage.countMessages("Simbirsoft -Тестовое задание"));
        Assert.assertEquals(count, 3);
    }

    @Test
    public void thirdTest() {
        mailPage.sendMessage(count);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

    }
        Assert.assertTrue(webDriver.findElement(By
                .cssSelector("div[class='ComposeDoneScreen-Wrapper'")).isEnabled());
    }

    @AfterTest
    public void stopSession() {
        if(webDriver!=null) {
            webDriver.quit();
            System.out.println("Driver is stopped");
        }
    }
}
