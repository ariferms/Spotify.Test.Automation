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
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//a//span[text()=\"Spotify Listem\"]"),10));
        methods.clickElement(By.xpath("//div[@class=\"AINMAUImkAYJd4ertQxy\"]"));
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
        methods.clickElement(By.xpath("//button[@data-testid=\"control-button-playpause\"]"));
        methods.waitBySeconds(1);
    }
    public void deleteToSong(int deleteSong){
        methods.hoverElement(By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + deleteSong + "]"));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + deleteSong + "]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + deleteSong + "]"),10));
        methods.clickElement(By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + deleteSong + "]" + "//button[@data-testid='more-button']"));
        methods.waitBySeconds(2);

        methods.hoverElement(By.xpath("//button//span[text() =\"Bu çalma listesinden kaldır\"]"));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button//span[text() =\"Bu çalma listesinden kaldır\"]"), 10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button//span[text() =\"Bu çalma listesinden kaldır\"]"), 10));
        methods.clickElement(By.xpath("//button//span[text() =\"Bu çalma listesinden kaldır\"]"));
        methods.waitBySeconds(2);
    }
    public void deleteToPlayList(){
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@aria-label=\"Spotify Listem için diğer seçenekler\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@aria-label=\"Spotify Listem için diğer seçenekler\"]"),10));
        methods.clickElement(By.xpath("//button[@aria-label=\"Spotify Listem için diğer seçenekler\"]"));

        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button//span[text()=\"Sil\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button//span[text()=\"Sil\"]"),10));
        methods.clickElement(By.xpath("//button//span[text()=\"Sil\"]"));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//button[@aria-label=\"Spotify Listem silinsin mi?\"]"),10));
        Assertions.assertTrue(methods.isElementClickable(By.xpath("//button[@aria-label=\"Spotify Listem silinsin mi?\"]"),10));
        methods.clickElement(By.xpath("//button[@aria-label=\"Spotify Listem silinsin mi?\"]"));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//div//div[text()=\"Kitaplığından çıkarıldı\"]"),10));
        methods.waitBySeconds(2);
    }

}
