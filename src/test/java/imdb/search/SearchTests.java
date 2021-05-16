package imdb.search;

import imdb.base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.search.SearchResultsPage;

public class SearchTests extends BaseTest {
    @Test
    private void searchByKeywordShouldDisplayAppropriatePage() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SearchBar searchBar = page.getSearchBar();
        searchBar.insertSearchQuery("Matrix");
        SearchResultsPage searchResultsPage = searchBar.performSearchQuery();
        searchResultsPage.waitForLoadAndVerifyResults();
    }

    @Test
    private void searchByNonExistentKeyword() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SearchBar searchBar = page.getSearchBar();
        searchBar.insertSearchQuery("InvalidMovieName");
        SearchResultsPage searchResultsPage = searchBar.performSearchQuery();
        searchResultsPage.waitForLoadAndVerifyNoResult();
    }

}
