package pages.genres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class GenreResultsPage {
    private final WebDriver webDriver;
    private final String genre;
    private By resultsDiv = By.xpath("//*[@id=\"main\"]/div/div[3]/div");

    public GenreResultsPage(WebDriver webDriver, String genre) {
        this.webDriver = webDriver;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> returnResultMovieUrls() {
        return webDriver.findElement(resultsDiv)
                .findElements(By.className("lister-item"))
                .stream()
                .map(
                    itemDiv -> itemDiv.findElement(By.className("lister-item-content"))
                        .findElement(By.className("lister-item-header"))
                        .findElement(By.tagName("a"))
                        .getAttribute("href")
                )
                .collect(Collectors.toList());
    }


}
