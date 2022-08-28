package testmaster.selenium.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import testmaster.selenium.driver.Driver;

import java.time.Duration;


public class Methods {

    private static final Logger logger = LogManager.getLogger(Methods.class);
    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;
    public Methods(){

        this.driver = Driver.driver;
        jsDriver = (JavascriptExecutor) driver;
        fluentWait = setFluentWait(30);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

         return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by){

        return driver.findElement(by);
    }

    public WebElement findElementWait(By by){

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by){

        findElementWait(by).click();
        logger.info(by.toString() + " elementine tıklandı");
    }

    public void sendKeys(By by, String text){

        findElementWait(by).sendKeys(text);
        logger.info(by.toString() + " elementine " + text + " texti yazıldı");
    }

    public String getText(By by){

        return findElementWait(by).getText();
    }

    public String getAttribute(By by, String attribute){

        return findElementWait(by).getAttribute(attribute);
    }

    public void hoverElement(By by){

        WebElement webElement = findElementWait(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(by.toString() + " elementine hover işlemi yapıldı");
    }

    public String getValue(By by){

        WebElement webElement = findElementWait(by);
        return jsDriver.executeScript("return arguments[0].value;", webElement).toString();
    }

    public void clear(By by){

        findElementWait(by).clear();
        logger.info(by.toString() + " elementin texti temizlendi");
    }

    public Select getSelect(By by){

        return new Select(findElementWait(by));
    }

    public void selectByValue(By by, String value){

        getSelect(by).selectByValue(value);
    }

    public void clickElementJs(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].click();", webElement);
        logger.info(by.toString() + " elemente js ile tıklandı");
    }

    public void scrollElementCenter(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
        logger.info(by.toString() + " scrollElementCenter");
    }

    public void scrollElement(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
        logger.info(by.toString() + " scrollElement");
    }

    public void scrollElementIfNeeded(By by){

        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoViewIfNeeded();", webElement);
        logger.info(by.toString() + " scrollElementIfNeeded");
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(by.toString() + " true");
            return true;
        }catch (Exception e){
            logger.info(by.toString() + " false");
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            logger.info(by.toString() + " true");
            return true;
        }catch (Exception e){
            logger.info(by.toString() + " false");
            logger.error(e.getMessage());
            return false;
        }
    }

    public void waitBySeconds(long seconds){

        waitByMilliSeconds(1000*seconds);
        logger.info(seconds + " saniye beklendi");
    }
    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (milliSeconds % 1000 != 0)
            logger.info(milliSeconds + " milisaniye beklendi");
    }

    // //button[text()="Kaydol"]

    //header[@aria-label="Üst çubuk ve kullanıcı menüsü"]//button[text()="Kaydol"]
//css
   //  header[aria-label*="kullanıcı"]
    // header[aria-label$="kullanıcı menüsü"]
    // header[aria-label^="Üst çubuk"]
    // header[aria-label="Üst çubuk ve kullanıcı menüsü"] button:nth-child(5)
    //  header[aria-label="Üst çubuk ve kullanıcı menüsü"] > button:nth-of-type()

    // header[aria-label="Üst çubuk ve kullanıcı menüsü"] > div:nth-child(9) > button

    // button[data-testid='login-button']
}
