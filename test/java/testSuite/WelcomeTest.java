package testSuite;

import org.testng.annotations.*;
import pageObjectRepository.WelcomePageRepository;
import setup.BaseConfig;

public class WelcomeTest extends BaseConfig {
    WelcomePageRepository objWelcomePage;

    @Test(description = "This test is to verify the Welcome Chat screen on Chat AI")
    public void welcomeTest() {
        objWelcomePage = new WelcomePageRepository(BaseConfig.driver);
        objWelcomePage.welcomeScreen();

    }
}
