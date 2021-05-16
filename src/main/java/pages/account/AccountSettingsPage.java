package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettingsPage {
    private final WebDriver webDriver;
    private final By editProfileLocator = By.xpath("//*[@id=\"main\"]/div/div[1]/ul/li[1]/a");
    private final By editBioTextAreaLocator = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/textarea");
    private final By profileSaveButtonLocator = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div[1]");



    public AccountSettingsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void editBio(String newBio) {
        webDriver.get(webDriver.findElement(editProfileLocator).getAttribute("href"));
        webDriver.findElement(editBioTextAreaLocator).clear();
        webDriver.findElement(editBioTextAreaLocator).sendKeys(newBio);
        webDriver.findElement(profileSaveButtonLocator).click();
        new WebDriverWait(webDriver, 120)
                .until(driver -> webDriver.findElements(editProfileLocator).size() > 0);
    }

}
