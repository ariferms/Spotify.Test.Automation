package testmaster.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class GuestPage {

    private static String pageUrl = "https://open.spotify.com/";
    private static String pageName = "Spotify - Web Player";
    private static String buttonSingup = "//button[text()=\"Kaydol\"]";
    private static String buttonlogin = "button[data-testid=\"login-button\"";
    private static String buttonSearch = "a[href=\"/search\"]";
    private static String buttonMyBookshelf = "a[href=\"/collection\"]";
    private static String buttonHomePage = "//a[@aria-current=\"page\" and ./span[text()=\"Ana sayfa\"]]";

    Methods methods;

    public GuestPage(){

        methods = new Methods();
    }

    public void controlGuestPage(){

        assertTrue(methods.isElementVisible(By.xpath(buttonHomePage),10));
        assertTrue(methods.isElementVisible(By.cssSelector(buttonSearch),10));
        assertTrue(methods.isElementVisible(By.cssSelector(buttonMyBookshelf),10));
        assertTrue(methods.isElementVisible(By.xpath(buttonSingup),10));
        assertTrue(methods.isElementVisible(By.cssSelector(buttonlogin),10));
    }

    public void clickLoginButton(){

        By loginButton = By.cssSelector(buttonlogin);
        assertTrue(methods.isElementClickable(loginButton,10));
        methods.clickElement(loginButton);
    }
    /**
     a[href="/search"]
     a[href="/collection"]
     button[data-testid="login-button"]
     //button[text()="Kaydol"]
     */
    //a[@aria-current="page" and ./span[text()="Ana sayfa"]]
}
