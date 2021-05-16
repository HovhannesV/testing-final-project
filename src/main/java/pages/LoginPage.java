package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver webDriver;
    private final By imdbLoginAnchor = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");
    private final By imdbLoginField = By.id("ap_email");
    private final By imdbPasswordField = By.id("ap_password");
    private final By imdbSigninButton = By.id("a-autoid-0");
    private final By authErrorWindow = By.id("auth-error-message-box");
    private final By warningErrorWindow = By.id("auth-warning-message-box");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean loginWithImdbAccount(String login, String password) throws Exception {
        webDriver.get(webDriver.findElement(imdbLoginAnchor).getAttribute("href"));
        new WebDriverWait(webDriver, 120)
                .until(driver -> webDriver.findElement(imdbLoginField)) ;
        webDriver.findElement(imdbLoginField).sendKeys(login);
        webDriver.findElement(imdbPasswordField).sendKeys(password);
        webDriver.findElement(imdbSigninButton).click();
        return webDriver.findElements(authErrorWindow).size() == 0 && webDriver.findElements(warningErrorWindow).size() == 0;
    }

}
