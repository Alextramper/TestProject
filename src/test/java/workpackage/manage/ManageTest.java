package workpackage.manage;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ManageTest {
    public static void waitPage(WebDriver webDriver, int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}
