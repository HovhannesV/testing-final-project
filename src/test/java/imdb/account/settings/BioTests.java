package imdb.account.settings;

import imdb.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.AccountProfilePage;
import pages.account.AccountSettingsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.account.ProfileNavigator;

import java.util.UUID;

public class BioTests extends BaseTest {
    @Test
    public void changeBioTests() throws Exception {
        HomePage homePage = new HomePage(this.webDriver);
        LoginPage loginPage = homePage.navigateLoginPage();
        Assert.assertTrue(loginPage.loginWithImdbAccount("hovo.test19@gmail.com", "hov88test"));
        AccountSettingsPage accountSettingsPage = new ProfileNavigator(webDriver).navigateToAccountSettingsPage();
        String newBio = UUID.randomUUID().toString();
        accountSettingsPage.editBio(newBio);
        AccountProfilePage accountProfilePage = new ProfileNavigator(webDriver).navigateToProfile();
        Assert.assertEquals(accountProfilePage.getBio(), newBio);
    }

}
