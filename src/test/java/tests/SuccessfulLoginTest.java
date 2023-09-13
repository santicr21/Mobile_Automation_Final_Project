package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.MainScreen;
import screens.LoginScreen;
import util.tests.BaseMobileTest;

public class SuccessfulLoginTest extends BaseMobileTest {
    private LoginScreen loginScreen;

    @BeforeMethod
    public void userOnLoginScreen() {
        MainScreen mainScreen = loadMainScreen();
        loginScreen = mainScreen.goToLoginScreen();
    }

    @Test
    public void loginSuccessfulTest() {
        String LOGIN_OK_MSG = "You are logged in!";

        loginScreen.submitLoginForm("5afix8Xr@test.com", "NewPassword12345");
        loginScreen.getLoginFormMessage();
        Assert.assertEquals(loginScreen.getLoginFormMessage(), LOGIN_OK_MSG);
        loginScreen.clickOnOkButton();
    }
}
