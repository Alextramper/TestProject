package workpackage.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import workpackage.manage.ManageTest;

public class LoginPage {

    private WebDriver webDriver;
    private String webTitle;

    @FindBy(css = "a[class*='Button-Enter'")
    private WebElement enterButton;

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "passwd")
    private WebElement passwordInput;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void openPage(String pageUrl) {
        webDriver.get(pageUrl);
    }

    public void logInToMail(String login, String password) {
        enterButton.click();
        loginInput.sendKeys(login);
        click(loginInput);
        ManageTest.waitPage(webDriver, 3);
        passwordInput.sendKeys(password);
        click(passwordInput);
        webTitle = webDriver.getTitle();
    }

    void click(WebElement webElem) {
        webElem.submit();
    }
}
