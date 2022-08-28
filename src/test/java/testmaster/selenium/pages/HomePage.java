package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class HomePage {
    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public void loginControl(String username){

        String usernameElement = "figure[data-testid=\"user-widget-avatar\"]" + "[title=\""+ username + "\"]";

        Assertions.assertTrue(methods.isElementVisible(By.cssSelector(usernameElement),10));
        String usernameTitle = methods.getAttribute(By.cssSelector("figure[data-testid=\"user-widget-avatar\"]"),"title");
        Assertions.assertEquals(username, usernameTitle);
        String actualUserName = methods.getText(By.cssSelector("figure[data-testid=\"user-widget-avatar\"][title=\"arifermis\"]" +
                " ~ span[data-testid=\"user-widget-name\"]"));
        Assertions.assertEquals(username, actualUserName);
    }
    public void homePageControl(){
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Ana sayfa\"]"), 7));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//span[text()=\\\"Ara\\\"]\""), 7));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Kitaplığın\"]"),7));
        Assertions.assertTrue(methods.isElementVisible(By.id("create-playlist-button"),7));
    }
    public void clickCreatPlayList(){
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@data-testid=\"create-playlist-button\"]"),10));
        methods.clickElement(By.xpath("//button[@data-testid=\"create-playlist-button\"]"));
    }
}
