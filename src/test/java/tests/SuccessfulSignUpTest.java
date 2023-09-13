package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.MainScreen;
import screens.LoginScreen;
import util.tests.BaseMobileTest;

public class SuccessfulSignUpTest extends BaseMobileTest {
    private LoginScreen loginScreen;
    private MainScreen mainScreen;

    @BeforeMethod
    public void userOnLoginScreen () {
        mainScreen = loadMainScreen();
        loginScreen =  mainScreen.goToLoginScreen();
    }

    @Test
    public void signUpTest () {
        String SIGN_UP_OK_MSG = "You successfully signed up!";

        loginScreen.submitSignUpForm();
        Assert.assertEquals(loginScreen.getSignUpFormMessage(), SIGN_UP_OK_MSG);
        loginScreen.clickOnOkButton();
    }
}
