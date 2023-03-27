package pageObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseConfig;
import utils.data;
import org.testng.Reporter;
import utils.CommonSteps;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PizzaOrderPageRepository {
    static WebDriver driver;
    CommonSteps common = new CommonSteps(BaseConfig.driver);
    private final String pizza = "//a[text()='%s']";
    private final String toppings = "//span[text()='%s']";
    private final String crust="//a[text()='%s']";
    private final String pizzaSize="//a[text()='%s']";
    private final String order="//a[text()='%s']";
    private final String feedback = "//button[@class='%s']";
    @FindBy(id = "queryTextbox")
    public WebElement query;
    @FindBy(xpath = "//a[text()='veg']")
    public WebElement veg;
    @FindBy(xpath = "//button[@class='btn default_card_submit']")
    public WebElement submitTopping;
    @FindBy(xpath = "//p[text()='CONGRATS ! ORDER PLACED .']")
    public WebElement orderSuccess;
    @FindBy(xpath = "//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']")
    public WebElement modalContent;
    @FindBy(xpath = "//div[@id='custom_feedback_container']//div[@class='modal-dialog']//div[@class='modal-content']//button[@class='btn default_card_submit']")
    public WebElement selectSubmit;
    @FindBy(className = "thankyou")
    public WebElement feedbackStatus;
    public PizzaOrderPageRepository(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sendQuery(String ask)
    {
        query.sendKeys(ask);
        query.sendKeys(Keys.ENTER);
        Reporter.log(ask);
        System.out.println(ask);
    }
    public void selectPizza(String pizzaType){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(pizza,pizzaType)), pizzaType));
        driver.findElement(By.xpath(String.format(pizza,pizzaType))).click();
        Reporter.log("Select pizza type:"+ pizzaType);
        System.out.println("Select pizza type:"+ pizzaType);
    }
    public void selectToppings(String topping)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(toppings,topping)), topping));
        driver.findElement(By.xpath(String.format(toppings,topping))).click();
        submitTopping.click();
       Reporter.log("Select toppings type:" + topping);
        System.out.println("Select toppings type:" + topping);
    }
    public void selectCrust(String pizzaCrust)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(crust,pizzaCrust)), pizzaCrust));
        driver.findElement(By.xpath(String.format(crust,pizzaCrust))).click();
        Reporter.log("Select pizza crust:" + pizzaCrust);
        System.out.println("Select pizza crust:" + pizzaCrust);
    }
    public void selectPizzaSize(String size){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(pizzaSize,size)), size));
        driver.findElement(By.xpath(String.format(pizzaSize,size))).click();
        Reporter.log("Select pizza size:" + size);
        System.out.println("Select pizza size:" + size);
    }
    public void confirmOrder(String status){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(order,status)), status));
        driver.findElement(By.xpath(String.format(order,status))).click();
        Reporter.log("Confirm Order Status:" + status);
        System.out.println("Confirm Order Status:" + status);
    }
    public void submitFeedback(String subFeedback) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(feedback,subFeedback))));
        driver.findElement(By.xpath(String.format(feedback,subFeedback))).click();
        driver.findElement(data.MODAL_CONTENT);
       Thread.sleep(2000);
        WebElement option = driver.findElement(data.SELECT_COMBO_BOX);
        option.click();
        Thread.sleep(2000);
        common.clickRandomElement(data.LIST);
        Thread.sleep(2000);
        WebElement el = driver.findElement(data.SUBMIT);
        el.click();
    }


    public void OrderPizza(String ask,String pizzaType,String topping,String crust,String size,String status,String feeback) throws InterruptedException {
        Thread.sleep(2000);
        this.sendQuery(ask);
        this.selectPizza(pizzaType);
        this.selectToppings(topping);
        this.selectCrust(crust);
        this.selectPizzaSize(size);
        this.confirmOrder(status);
        this.submitFeedback(feeback);
    }

}
