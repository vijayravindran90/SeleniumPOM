package config;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import com.google.common.collect.Sets;
public class CommonAppiumTest {
    public WebDriver driver;

    public CommonAppiumTest(WebDriver driver)
    {
        this.driver = driver;
    }
    public void sendKeys(String id, String keys)
    {
        WebElement el = driver.findElement(By.id(id));
        el.sendKeys(keys);
    }
    public void hanleIframe(){

    }
}
