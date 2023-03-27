package pageObjectRepository;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomePageRepository {

    WebDriver driver;
    @FindBy(xpath="//img[@alt='Chat agent button']")
    public WebElement chatBot;
    @FindBy(xpath="//p[text()='Welcome to Pizza Shoppe']")
    public WebElement welcomeMessage;
    @FindBy(className = "get-started-link")
    public WebElement getStarted;

    public WelcomePageRepository(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void invokeChatBot(){
        chatBot.click();
    }
    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }
    public void clickGetStarted(){
        getStarted.click();
    }

    public void welcomeScreen(){
        this.invokeChatBot();
        this.getWelcomeMessage();
        this.clickGetStarted();
    }
}
