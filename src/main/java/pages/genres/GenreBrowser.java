package pages.genres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenreBrowser {

    private final By firstGenreDivLocator = By.xpath("//*[@id=\"main\"]/div[1]/span/div/div/div/div/div/div[1]/div/div/div");

    private WebDriver webDriver;

    public GenreBrowser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public GenreResultsPage browseByFirstGenre() {
        WebElement firstGenreDiv = webDriver.findElement(firstGenreDivLocator);
        String genre = firstGenreDiv.findElement(By.tagName("a")).findElement(By.tagName("img")).getAttribute("title");
        firstGenreDiv.click();
        return new GenreResultsPage(webDriver, genre);
    }

}
