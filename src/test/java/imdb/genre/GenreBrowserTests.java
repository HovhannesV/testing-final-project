package imdb.genre;

import imdb.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.movie.MoviePage;
import pages.genres.GenreBrowser;
import pages.HomePage;
import pages.genres.GenreResultsPage;

public class GenreBrowserTests extends BaseTest {
    @Test
    private void browseByGenre() {
        System.out.println("THIS MAY TAKE LONG AS WE CHECK ALL MOVIES' GENRES");
        HomePage page = new HomePage(this.webDriver);
        GenreBrowser genreBrowser = page.getMenu().navigateToGenreBrowser();
        GenreResultsPage genreResultsPage = genreBrowser.browseByFirstGenre();
        for(String movieUrl : genreResultsPage.returnResultMovieUrls()) {
            webDriver.get(movieUrl);
            MoviePage moviePage = new MoviePage(webDriver);
            System.out.println(movieUrl + " -> " + moviePage.getMovieGenres());
            Assert.assertTrue(moviePage.getMovieGenres().contains(genreResultsPage.getGenre().toLowerCase()));
        }
    }
}
