package testSuite;

import org.testng.annotations.*;
import pageObjectRepository.LoginPageRepository;
import pageObjectRepository.WelcomePageRepository;
import setup.BaseConfig;

public class LoginTest extends BaseConfig {
    LoginPageRepository objLoginpage;
    WelcomePageRepository objWelcomePage;

    @Test(description = "This test is to verify the Login on Chat AI")
    public void loginTest() {
        objLoginpage = new LoginPageRepository(BaseConfig.driver);
        objWelcomePage = new WelcomePageRepository(BaseConfig.driver);
        objWelcomePage.welcomeScreen();
        objLoginpage.login();

    }
}
