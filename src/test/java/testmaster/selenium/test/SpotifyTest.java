package testmaster.selenium.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;
    PlayListPage playListPage;
    SearchPage searchPage;

    @Test
    public void loginTest(){

        /**
        https://github.com/YunusBalaman/TestmasterSeleniumProject
         */
        System.out.println("Spotify");
        init();
        guestPage.controlGuestPage();
        guestPage.clickLoginButton();
        loginPage.controlLoginPage();
        loginPage.validLogin("arif.ermis@tetinium.com", "Agustos2022*");
        homePage.loginControl("arifermis");
        homePage.homePageControl();
        //playListPage.playListControl();
        //playListPage.changePlayList("Spotify Listem");
        searchPage.searchPlayList();
        searchPage.clickToSong();
        playListPage.clickPlayList();
        playListPage.clickSecondSong("Instant Crush", 10);
    }


    public void init(){

        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        playListPage = new PlayListPage();
        searchPage = new SearchPage();

    }
}
