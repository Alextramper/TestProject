package workpackage.platform;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;



public class WebdriverFactory {

    final static String PATH = System.getProperty("user.dir") + "//src//test//resources//grid//";

    public static WebDriver getChromeDriver(URL hubURLAdress) {
        System.setProperty("webdriver.chrome.driver", PATH + "chromedriver.exe");
        ChromeOptions chrOptions = new ChromeOptions();
        chrOptions.setCapability("platform", Platform.WINDOWS);
        WebDriver webDriver = new RemoteWebDriver(hubURLAdress, chrOptions);
        System.out.println("ChromeDriver is run");
        return webDriver;
    }
}
