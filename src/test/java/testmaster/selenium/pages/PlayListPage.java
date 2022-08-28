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
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@data-testid=\"create-playlist-button\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@data-testid=\"create-playlist-button\"]"),10));
        methods.clickElement(By.xpath("//button[@data-testid=\"create-playlist-button\"]"));
    }
    public void changePlayList(String newPlayListName){

        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@class=\"wCkmVGEQh3je1hrbsFBY\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@class=\"wCkmVGEQh3je1hrbsFBY\"]"),10));
        methods.clickElement(By.xpath("//button[@class=\"wCkmVGEQh3je1hrbsFBY\"]"));

        Assertions.assertTrue(methods.isElementVisible(By.xpath("//input[@data-testid=\"playlist-edit-details-name-input\"]"),10));
        methods.sendKeys(By.xpath("//input[@data-testid=\"playlist-edit-details-name-input\"]"),newPlayListName);

        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@data-testid=\"playlist-edit-details-save-button\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@data-testid=\"playlist-edit-details-save-button\"]"),10));
        methods.clickElement(By.xpath("//button[@data-testid=\"playlist-edit-details-save-button\"]"));
        methods.waitBySeconds(3);

    }

}
