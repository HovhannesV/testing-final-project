package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileNavigator {
    private final WebDriver webDriver;

    private final By accountButton = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]");
    private final By accountProfileButton = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[2]");
    private final By accountSettingsItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[6]");
    private final By accountWatchlistItem = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[3]");


    public ProfileNavigator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AccountProfilePage navigateToProfile() {
        webDriver.findElement(accountButton).click();
        webDriver.get(webDriver.findElement(accountProfileButton).getAttribute("href"));
        return new AccountProfilePage(webDriver);
    }

    public AccountSettingsPage navigateToAccountSettingsPage() {
        webDriver.findElement(accountButton).click();
        webDriver.get(webDriver.findElement(accountSettingsItem).getAttribute("href"));
        return new AccountSettingsPage(webDriver);
    }

    public WatchListPage navigateToWatchListPage() {
        webDriver.findElement(accountButton).click();
        webDriver.get(webDriver.findElement(accountWatchlistItem).getAttribute("href"));
        return new WatchListPage(webDriver);
    }
}
