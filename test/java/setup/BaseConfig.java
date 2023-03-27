package setup;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseConfig {
    public static WebDriver driver;
    public static final String BASE_URL = "https://c0.avaamo.com/web_channels/d0880907-3408-4c8d-9226-7648880a94fa/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up";
    String chromeDriverPath = "chromedriver";
    String firefoxDriverPath = "geckodriver";

    @BeforeMethod
    public WebDriver setup() throws IOException, InterruptedException {
        //report = new ExtentReports(System.getProperty("user.dir")+"/output-tests/report.html");
        //test = report.startTest("ExtentDemo");
        // Load the properties File
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/application.properties");
        obj.load(objfile);
        /*if(Objects.equals(obj.getProperty("browser"), "chrome"))
        {
            System.setProperty("webdriver.chrome.driver", obj.getProperty("chrome_driver"));
            driver = new ChromeDriver();
        }
        else if(Objects.equals(obj.getProperty("browser"), "firefox"))
        {
            System.setProperty("webdriver.firefox.driver", obj.getProperty("firefox_driver"));
            driver = new FirefoxDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(BASE_URL, currentUrl);
        Reporter.log("browser launched");
        return driver;
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //report.endTest(test);
        //report.flush();
        Reporter.setCurrentTestResult(result);
        File img = new File(System.getProperty("user.dir") + "/test-output/screenshots/test_" + result.getMethod().getMethodName() + ".png");

        if (result.getStatus() == 2) { //failed scenaario
            Reporter.log("This is failed step", true);

            FileOutputStream screenshotStream = new FileOutputStream(img);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();

            Reporter.log(" <a href='" + img.getAbsolutePath() + "'> <img src='" + img.getAbsolutePath() + "' height='200' width='200'/> </a>  ");

        }
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
