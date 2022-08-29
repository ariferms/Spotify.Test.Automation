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
    public void clickPlayList(){
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//div//a[@href=\"/playlist/4EvMGTjQzmbWIddom3DfQm\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//div//a[@href=\"/playlist/4EvMGTjQzmbWIddom3DfQm\"]"),10));
        methods.clickElement(By.xpath("//div//a[@href=\"/playlist/4EvMGTjQzmbWIddom3DfQm\"]"));
    }
    public void clickSecondSong(String songName, long duration){
        String item = "//div[contains(text(),'" + songName + "')]";
        By menuItemBy = By.xpath(item);
        methods.scrollElementIfNeeded(menuItemBy);
        methods.hoverElement(menuItemBy);

        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@class='RfidWIoz8FON2WhFoItU' and contains(@aria-label,'" + songName + "')]"),10));
        methods.clickElement(By.xpath("//button[@class='RfidWIoz8FON2WhFoItU' and contains(@aria-label,'" + songName + "')]"));
        methods.waitBySeconds(duration);
        methods.hoverElement(menuItemBy);
        methods.clickElement(By.xpath("//button[@class='RfidWIoz8FON2WhFoItU' and contains(@aria-label,'" + songName + "')]\""));
    }

}
