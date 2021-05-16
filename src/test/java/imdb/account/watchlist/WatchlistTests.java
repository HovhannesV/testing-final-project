package imdb.account.watchlist;

import imdb.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.account.AccountProfilePage;
import pages.account.AccountSettingsPage;
import pages.account.ProfileNavigator;
import pages.account.WatchListPage;
import pages.genres.GenreBrowser;
import pages.movie.MoviePage;
import pages.search.SearchResultsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class WatchlistTests extends BaseTest {
    @Test
    public void addToWatchListTest() throws Exception {
        HomePage homePage = new HomePage(this.webDriver);
        LoginPage loginPage = homePage.navigateLoginPage();
        Assert.assertTrue(loginPage.loginWithImdbAccount("hovo.test19@gmail.com", "hov88test"));

        GenreBrowser genreBrowser = homePage.getMenu().navigateToGenreBrowser();
        String movieUrl = genreBrowser.browseByFirstGenre().returnResultMovieUrls().get(0);

        this.webDriver.get(movieUrl);
        MoviePage moviePage = new MoviePage(this.webDriver);
        if(moviePage.isInWatchList()) {
            moviePage.removeFromWatchList();
        }
        moviePage.addToWatchList();

        WatchListPage watchListPage = new ProfileNavigator(webDriver).navigateToWatchListPage();
        Assert.assertTrue(
            watchListPage.returnMoviesOfWatchList()
                    .stream()
                    .map(
                        url -> {
                                try {
                                    return new URL(url).getPath();
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                    return null;
                                }
                        }
                    )
                    .collect(Collectors.toList())
                    .contains(new URL(movieUrl).getPath())
        );
    }
    @Test
    public void removeFromWatchListTest() throws Exception {
        HomePage homePage = new HomePage(this.webDriver);
        LoginPage loginPage = homePage.navigateLoginPage();
        Assert.assertTrue(loginPage.loginWithImdbAccount("hovo.test19@gmail.com", "hov88test"));

        GenreBrowser genreBrowser = homePage.getMenu().navigateToGenreBrowser();
        String movieUrl = genreBrowser.browseByFirstGenre().returnResultMovieUrls().get(0);

        this.webDriver.get(movieUrl);
        MoviePage moviePage = new MoviePage(this.webDriver);
        if(!moviePage.isInWatchList()) {
            moviePage.addToWatchList();
        }
        moviePage.removeFromWatchList();
        WatchListPage watchListPage = new ProfileNavigator(webDriver).navigateToWatchListPage();
        Assert.assertTrue(
                !watchListPage.returnMoviesOfWatchList()
                        .stream()
                        .map(
                                url -> {
                                    try {
                                        return new URL(url).getPath();
                                    } catch (Exception ex) {
                                        System.out.println(ex);
                                        return null;
                                    }
                                }
                        )
                        .collect(Collectors.toList())
                        .contains(new URL(movieUrl).getPath())
        );


    }

}
