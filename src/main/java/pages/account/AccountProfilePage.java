package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private final WebDriver webDriver;
    private final By bioLocator = By.xpath("//*[@id=\"main\"]/div[1]/div/div[4]");

    public AccountProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getBio() {
        return webDriver.findElement(bioLocator).getText();
    }

}
