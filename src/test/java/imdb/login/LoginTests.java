package imdb.login;

import imdb.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.UUID;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLoginTest() throws Exception {
        HomePage page = new HomePage(this.webDriver);
        LoginPage loginPage = page.navigateLoginPage();

        Assert.assertTrue(loginPage.loginWithImdbAccount("hovo.test19@gmail.com", "hov88test", true));
    }

    @Test
    public void failedLoginTest() throws Exception {
        HomePage page = new HomePage(this.webDriver);
        LoginPage loginPage = page.navigateLoginPage();

        Assert.assertFalse(loginPage.loginWithImdbAccount("hovo.test19@gmail.com", UUID.randomUUID().toString(), false));
    }

}
