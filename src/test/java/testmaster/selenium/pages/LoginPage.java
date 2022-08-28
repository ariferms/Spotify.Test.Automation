package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.test.SpotifyTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    Methods methods;
    private  String loginUserName = "arif.ermis@testinium.com";
    private  String loginPassword = "Agustos2022*";

    public LoginPage(){

        methods = new Methods();
    }

    public void controlLoginPage(){

        assertTrue(methods.isElementVisible(By.id("login-username"),10));
        assertTrue(methods.isElementVisible(By.id("login-password"),10));
        assertTrue(methods.isElementVisible(By.id("reset-password-link"),10));
        assertTrue(methods.isElementVisible(By.id("login-button"),10));
        /**
         login-button
         reset-password-link
         login-password
         login-username
          */

    }

    public void validLogin(String username, String password){

        methods.sendKeys(By.id("login-username"), loginUserName);
        methods.sendKeys(By.id("login-password"), loginPassword);
        assertTrue(methods.isElementClickable(By.id("login-button"),10));
        methods.clickElement(By.id("login-button"));
    }
}
