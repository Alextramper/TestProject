package workpackage.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import workpackage.manage.ManageTest;

public class MailPage {

    @FindBy(className = "textinput__control")
    private WebElement searchMessageInput;

    @FindBy(css = "button[class*='search-input__form-button']")
    WebElement searchButton;

    @FindBy(css = "span[class*='with-xs-left-gap']")
    WebElement resultElement;

    @FindBy(css = "a[title*='Написать']")
    private WebElement writeMessageBtn;

    @FindBy(css = "div[class='composeYabbles']")
    private WebElement inputToEmail;

    @FindBy(css = "input[class*='Subject-TextField']")
    private WebElement inputTheme;

    @FindBy(css = "div[role='textbox']")
    private WebElement inputText;

    @FindBy(css = "button[class*='Button_action']")
    private WebElement sendButton;

    private WebDriver webDriver;

    public MailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int countMessages(String theme) {
        int count;
        searchMessageInput.sendKeys(theme);
        searchButton.click();
        ManageTest.waitPage(webDriver, 3);
        String result = resultElement.getText();
        count = Integer.parseInt(result.substring(0, result.indexOf(" ")));
        return count;
    }

    public void sendMessage(int messageCount, String theme, String toEMail) {
        writeMessageBtn.click();
        inputToEmail.sendKeys(toEMail);
        inputTheme.sendKeys(theme + ". Крайнов");
        inputText.sendKeys("Кол-во найденных писем - " + messageCount);
        sendButton.click();
    }
}

