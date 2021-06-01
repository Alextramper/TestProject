package workpackage.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailPage {
    private WebDriver webDriver;

    public MailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public int countMessages(String theme) {
        int count = 0;
        if(isMailPage()) {
            List<WebElement> elemList = webDriver.findElements(By.cssSelector("span[title='Simbirsoft -Тестовое задание']"));
            for (WebElement wblm : elemList) {
                try {
                    if(wblm.getText().contains(theme)) {
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    webDriver.quit();
                }
            }
            return count;
        }
        return 0;
    }

    public void sendMessage(int messageNumber) {
        if(isMailPage()) {
            webDriver.findElement(By.cssSelector("a[title='Написать (w, c)']")).click();
            webDriver.findElement(By.cssSelector("input[class='composeTextField ComposeSubject-TextField']"))
                    .sendKeys("Simbirsoft -Тестовое задание Крайнов");

            webDriver.findElement(By.cssSelector("div[class='composeYabbles']"))
                    .sendKeys("krainov2012@yandex.ru");

            webDriver.findElement(By.cssSelector("div[role='textbox'"))
                    .sendKeys("Кол-во найденных писем - " + messageNumber);

            webDriver.findElement(By.cssSelector("button[class='control button2 button2_view_default" +
                    " button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle " +
                    "ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")).click();
        }
    }

    public boolean isMailPage() {
        return webDriver.getTitle().contains("Входящие");
    }
}
