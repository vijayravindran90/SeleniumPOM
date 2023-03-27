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


public class LoginPageRepository {
    Faker faker = new Faker();
    WebDriver driver;
    String fname = faker.name().firstName();
    String lname = faker.name().lastName();
    String femail = faker.internet().emailAddress();

    @FindBy(id = "first_name")
    public WebElement firstUserName;
    @FindBy(id = "last_name")
    public WebElement lastUserName;
    @FindBy(id="email")
    public WebElement email;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement next;
    @FindBy(xpath="//h2[@class='title']")
    public WebElement title;

    public LoginPageRepository(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterFirstName(){
        driver.switchTo().frame("avaamoIframe");
        firstUserName.sendKeys(fname);
    }
    public void enterLastName(){
        lastUserName.sendKeys(lname);
    }
    public void enterEmail(){
        email.sendKeys(femail);
    }
    public void clickSubmit(){
        next.click();
    }
    public String getTitle(){
        return  title.getText();
    }
    public void login(){
        this.enterFirstName();
        this.enterLastName();
        this.enterEmail();
        this.clickSubmit();
        Assert.assertEquals(this.getTitle(),"McPizza");
    }
}
