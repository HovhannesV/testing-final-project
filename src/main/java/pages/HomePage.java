package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.account.AccountSettingsPage;
import pages.genres.GenreBrowser;
import pages.search.SearchResultsPage;

public class HomePage {
    private final WebDriver webDriver;
    private final By menuButton = By.xpath("//*[@id=\"imdbHeader-navDrawerOpen--desktop\"]/div");
    private final By signinButton = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]");


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchBar getSearchBar() {
        return new SearchBar();
    }

    public LoginPage navigateLoginPage() {
        webDriver.findElement(signinButton).click();
        return new LoginPage(webDriver);
    }

    public HomeMenu getMenu() {
        new WebDriverWait(webDriver, 120).until(driver -> webDriver.findElements(menuButton).size() > 0);
        WebElement webElement = webDriver.findElement(menuButton);
        webElement.click();
        return new HomeMenu();
    }


    public class HomeMenu {
        private final By genreBrowserSection = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside/div/div[2]/div/div[1]/span/div/div/ul/a[5]");

        public GenreBrowser navigateToGenreBrowser() {
            webDriver.get(webDriver.findElement(genreBrowserSection).getAttribute("href"));
            return new GenreBrowser(webDriver);
        }

    }


    public class SearchBar {
        public void insertSearchQuery(String text) {
            webDriver.findElement(By.id("suggestion-search")).sendKeys(text);
        }
        public SearchResultsPage performSearchQuery() {
            webDriver.findElement(By.cssSelector("#suggestion-search-button")).click();
            return new SearchResultsPage(webDriver);
        }
        private boolean isSearchTextAreaPresent() {
            return !webDriver.findElements(By.id("suggestion-search")).isEmpty();

        }
        public void waitForLoad() {
            new WebDriverWait(webDriver, 120)
                    .until(driver -> isSearchTextAreaPresent());
        }
    }

}
