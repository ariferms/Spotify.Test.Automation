package testmaster.selenium.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.GuestPage;
import testmaster.selenium.pages.HomePage;
import testmaster.selenium.pages.LoginPage;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;

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
        homePage.clickCreatPlayList();
    }


    public void init(){

        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
}
