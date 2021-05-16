package pages.movie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MoviePage {
    private final WebDriver webDriver;
    private final By genreListDivLocatior = By.className("see-more");
    private final By watchListButtonTextLocator = By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/button[2]/div");
    private final By addToWatchListButtonLocator = By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/button[2]");
    private final By removeFromWatchListButtonLocator = By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[2]/button[1]");
    private final By movieTitleLocator = By.xpath("//*[@id=\"title-overview-widget\"]/div[1]/div[2]/div/div[2]/div[2]/h1");

    public MoviePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<String> getMovieGenres() {
        List<WebElement> genreElements =webDriver.findElements(genreListDivLocatior).stream()
                 .filter(div -> div.findElements(By.tagName("h4")).size() > 0 &&  div.findElement(By.tagName("h4")).getText().equals("Genres:"))
                 .collect(Collectors.toList())
                 .get(0)
                 .findElements(By.tagName("a"));
        return genreElements.stream()
                .map(genreElement -> genreElement.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public String getMovieTitle() {
        return webDriver.findElement(movieTitleLocator).getText();
    }

    public boolean isInWatchList() {
        return !webDriver.findElement(watchListButtonTextLocator).getText().toLowerCase().equals("add to watchlist");
    }

    public void addToWatchList() {
        new WebDriverWait(webDriver, 120)
                .until(driver -> !this.isInWatchList());
        webDriver.findElement(addToWatchListButtonLocator).click();
    }

    public void removeFromWatchList() {
        new WebDriverWait(webDriver, 120)
                .until(driver -> this.isInWatchList());
        webDriver.findElement(removeFromWatchListButtonLocator).click();
    }

}
