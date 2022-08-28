package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class PlayListPage {
    Methods methods;

    public PlayListPage(){
        methods = new Methods();
    }

    public void playListControl(){
        Assertions.assertTrue(methods.isElementVisible(By.cssSelector("//h2[text()=\"Çalma listesi\"]"),10));
    }

}
