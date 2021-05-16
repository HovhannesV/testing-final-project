package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class WatchListPage {
    private final WebDriver webDriver;
    private final By movieItemLocator = By.className("lister-item");

    public WatchListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<String> returnMoviesOfWatchList() {
        return webDriver.findElements(movieItemLocator)
                .stream()
                .map(item ->
                        item.findElement(By.className("lister-item-header"))
                            .findElement(By.tagName("a"))
                            .getAttribute("href")
                )
                .collect(Collectors.toList());
    }
}
