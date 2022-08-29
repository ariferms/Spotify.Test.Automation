package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class SearchPage {
    Methods methods;
    public SearchPage(){
        methods = new Methods();
    }

    public void searchPlayList(){
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//a[@href=\"/search\"]"),10));
        methods.clickElement(By.xpath("//a[@href=\"/search\"]"));

        methods.sendKeys(By.xpath("//input[@class=\"Type__TypeElement-goli3j-0 cPwEdQ QO9loc33XC50mMRUCIvf\"]"), "Daft Punk" );
        methods.waitBySeconds(2);
    }
    public void clickToSong(){
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@class=\"Chip__ChipComponent-ry3uox-0 khIziI\"]"),7));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button//span[contains(text(),\"Şarkılar\")]"),7));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button//span[contains(text(),\"Şarkılar\")]"),7));
        methods.clickElement(By.xpath("//button//span[contains(text(),\"Şarkılar\")]"));
        methods.waitBySeconds(2);

        for (int i = 2; i < 5; i++) {
            methods.hoverElement(By.xpath("//div[@aria-rowindex="+ i +"]"));
            //Assertions.assertTrue(methods.isElementVisible(By.xpath("//div[@aria-rowindex="+ i +"]"),10));
            //Assertions.assertTrue(methods.isElementClickable(By.xpath("//div[@aria-rowindex="+ i +"]"),10));
            methods.clickElement(By.xpath("//button[@aria-label=\"Daft Punk, Pharrell Williams, Nile Rodgers - Get Lucky (feat. Pharrell Williams & Nile Rodgers) - Radio Edit için diğer seçenekler\"]"));
            methods.waitBySeconds(2);

            methods.hoverElement(By.xpath("//button//span[text() =\"Çalma listesine ekle\"]"));
            Assertions.assertTrue(methods.isElementVisible(By.xpath("//button//span[text() =\"Çalma listesine ekle\"]"),10));
            methods.hoverElement(By.xpath("//button//span[text() =\"Çalma listesine ekle\"]"));

            Assertions.assertTrue(methods.isElementVisible(By.xpath("//button//span[text()=\"Spotify Listem\"]"),10));
            Assertions.assertTrue(methods.isElementClickable(By.xpath("//button//span[text()=\"Spotify Listem\"]"),10));
            methods.clickElement(By.xpath("//button//span[text()=\"Spotify Listem\"]"));
        }
    }

}
