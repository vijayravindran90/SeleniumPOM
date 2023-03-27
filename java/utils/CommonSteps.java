package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonSteps {
    static WebDriver driver;
    public CommonSteps(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Get URL
    public String getURL(){
        driver.get("https://www.browserstack.com");
        String url = driver.getCurrentUrl();
        return url;
    }
    //Navigation
    public String getNavigationURL(){
        driver.navigate().to("https://www.browserstack.com/selenium");
        String url = driver.getCurrentUrl();
        return url;
    }
    //Forward
    public void navigateForward(){
        driver.navigate().forward();
    }
    //Back
    public void navigateBack(){
        driver.navigate().back();
    }
    //Refresh the browser page
    public void pageRefresh(){
        driver.navigate().refresh();
    }

    //Click WebElement
    public void clickElement(String element){
        WebElement ele = driver.findElement(By.id(element));
                ele.click();
    }
    //Handle Iframe using Index
    public void switchFrameByIndex(int i){
        driver.switchTo().frame(i);
    }
    //Hanlde Iframe using ID
    public void switchFrameById(String id){
        driver.switchTo().frame(id);
    }
    //Implicit Waits
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Explicit Waits
    public void ExplicitWait(String s){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(s)));
    }
    //DropDown Selection
    public void dropDownSelection(String s,String value){
        WebElement element = driver.findElement((By.id(s)));
        Select option = new Select(element);
        option.selectByValue(value);
    }
    //Take Screenshot
    public void takeScreenshot(String destination) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File(destination));
    }
    //Mouse Hover
    public void mouseHover(String s){
        Actions actions = new Actions(driver);
            WebElement mouseHover = driver.findElement(By.xpath(s));
        actions.moveToElement(mouseHover).perform();
        }
    //drag and drop
    public void dragDrop(String source, String destination){
        WebElement sourceLocator = driver.findElement(By.xpath(source));
        WebElement destinationLocator = driver.findElement(By.xpath(destination));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(sourceLocator, destinationLocator).build().perform();
    }
    //switch To and alert and accept
    public void alertHandleAccept(String message){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
    }
    //switch To and alert and accept
    public void alertHandleDismiss(String message){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
        alert.dismiss();
    }
    //Scroll Down using coordinates
    public void scrollDown()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    //Scroll up using coordintates
    public void scrollUp()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
    }
    //Scroll to Element
    public void scrollToElement(String s){
        WebElement l=driver.findElement(By.xpath(s));
        // Javascript executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
    }
    public void clickRandomElement(By list){
        List<WebElement> itemsInDropdown = driver
                .findElements(list);

        // Getting size of options available
        int size = itemsInDropdown.size();
        System.out.println(size);

        // Generate a random number with in range
        Random r = new Random();
        int randomValue = r.nextInt(size);

        // Selecting random value
        itemsInDropdown.get(randomValue).click();
    }
    public void windowHandle(){
        String originalHandle = driver.getWindowHandle();

        for(String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        driver.switchTo().window(originalHandle);
    }
    public void javascriptClick(String s){
        WebElement closeButton = driver.findElement(By.id(s));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", closeButton);
    }

}
