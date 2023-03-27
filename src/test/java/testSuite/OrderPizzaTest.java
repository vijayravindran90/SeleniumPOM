package testSuite;

import org.testng.annotations.*;
import pageObjectRepository.LoginPageRepository;
import pageObjectRepository.PizzaOrderPageRepository;
import pageObjectRepository.WelcomePageRepository;
import setup.BaseConfig;

public class OrderPizzaTest extends BaseConfig {
    WelcomePageRepository objWelcomePage;
    LoginPageRepository objLoginPage;
    PizzaOrderPageRepository objOrderPage;

    @Test(description = "This test is to order pizza successfully using Chat Bot AI")
    public void OrderTest() throws InterruptedException {
        objWelcomePage = new WelcomePageRepository(BaseConfig.driver);
        objLoginPage = new LoginPageRepository(BaseConfig.driver);
        objOrderPage = new PizzaOrderPageRepository(BaseConfig.driver);
        objWelcomePage.welcomeScreen();
        objLoginPage.login();
        objOrderPage.OrderPizza("I want to order pizza","veg","Cheese","Thick Crust","Medium",
                "Yes","thumbs-up");
        Thread.sleep(2000);
    }
}
