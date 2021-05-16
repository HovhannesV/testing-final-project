package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver webDriver;
    private final By firstResultByTitle = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]");
    private final By firstResultByName = By.xpath("//*[@id=\"main\"]/div/div[3]/table/tbody/tr");
    private final By firstResultByKeyword = By.xpath("//*[@id=\"main\"]/div/div[4]/table/tbody/tr");
    private final By firstResultByCompany = By.xpath("//*[@id=\"main\"]/div/div[5]/table/tbody/tr");
    private final By noResultsComponent = By.xpath("//*[@id=\"main\"]/div/div");

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForLoadAndVerifyResults() {
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnTitlePresent() ) ;
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnNamePresent());
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnKeywordPresent());
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnCompanyPresent());
    }

    public void waitForLoadAndVerifyNoResult() {
        new WebDriverWait(webDriver, 120)
                .until(driver -> isNoResultComponentRendered());
    }

    private boolean isNoResultComponentRendered() {
        WebElement noResultDiv = webDriver.findElement(noResultsComponent);
        Actions action = new Actions(webDriver);
        action.moveToElement(noResultDiv).perform();
        return noResultDiv.isDisplayed();
    }

    private boolean isResultBasedOnTitlePresent() {
        WebElement trOfTitleResult = webDriver.findElement(firstResultByTitle);
        Actions action = new Actions(webDriver);
        action.moveToElement(trOfTitleResult).perform();
        return trOfTitleResult.isDisplayed();
    }

    private boolean isResultBasedOnNamePresent() {
        WebElement trOfNameResult = webDriver.findElement(firstResultByName);
        Actions action = new Actions(webDriver);
        action.moveToElement(trOfNameResult).perform();
        return trOfNameResult.isDisplayed();
    }

    private boolean isResultBasedOnKeywordPresent() {
        WebElement trOfKeywordResult = webDriver.findElement(firstResultByKeyword);
        Actions action = new Actions(webDriver);
        action.moveToElement(trOfKeywordResult).perform();
        return trOfKeywordResult.isDisplayed();
    }

    private boolean isResultBasedOnCompanyPresent() {
        WebElement trOfCompanyResult = webDriver.findElement(firstResultByCompany);
        Actions action = new Actions(webDriver);
        action.moveToElement(trOfCompanyResult).perform();
        return trOfCompanyResult.isDisplayed();
    }

}
