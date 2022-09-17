package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class Cookies {
    Methods methods;

    public Cookies(){

        methods = new Methods();
    }

    public void closeCookies(){
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//div[@class=\"otFlat bottom ot-wo-title vertical-align-content\"]"),10));
        methods.clickElement(By.xpath("//div//button[@aria-label=\"Kapat\" and @class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]"));


    }
}
