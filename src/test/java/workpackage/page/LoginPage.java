package workpackage.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private String webTitle;
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getWebTitle() {
        return webTitle;
    }

    public void openPage() {
        webDriver.get("https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru&retpath=https%3A%2F%2Fmail" +
                ".yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1");
    }

    public void logInToMail() {
        webDriver.findElement(By.name("login")).sendKeys("MrDady2016");
        click();
        webDriver.findElement(By.name("passwd")).sendKeys("qwerty123456");
        click();
        webTitle = webDriver.getTitle();
    }

    void click() {
        webDriver.findElement(By.xpath("//*[@class='Button2 Button2_size_l" +
                " Button2_view_action Button2_width_max Button2_type_submit']")).click();
    }



}
