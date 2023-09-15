package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import util.screens.BaseScreen;

import java.util.Random;

public class LoginScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login / Sign up Form\")")
    private AndroidElement screenText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Forms\")")
    private AndroidElement formsScreenButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"button-sign-up-container\")")
    private AndroidElement signUpButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "input-email")
    private AndroidElement emailInput;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "input-password")
    private AndroidElement passwordInput;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "input-repeat-password")
    private AndroidElement confirmPasswordInput;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"button-SIGN UP\")")
    private AndroidElement signUpFormButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/message")
    private AndroidElement signUpFormMessage;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement signUpFormOkButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
    private AndroidElement loginButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/message")
    private AndroidElement loginFormMessage;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement loginFormOkButton;

    public static String generateRandomEmail() {
        Random random = new Random();
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "test.com"};
        StringBuilder username = new StringBuilder();
        int usernameLength = 8;

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }

        String domain = domains[random.nextInt(domains.length)];

        return username.toString() + "@" + domain;
    }

    public String getLoginScreenText() {
        return getText(screenText);
    }

    public FormsScreen goToFormsScreen() {
        click(formsScreenButton);
        return new FormsScreen(super.driver);
    }

    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void submitSignUpForm () {
        click (signUpButton);
        sendKeys (emailInput, generateRandomEmail());
        sendKeys (passwordInput, "NewPassword12345");
        sendKeys (confirmPasswordInput, "NewPassword12345");
        click (signUpFormButton);
    }

    public void submitLoginForm(String email, String password) {
        sendKeys (emailInput, email);
        sendKeys (passwordInput, password);
        click (loginButton);
    }

    public String getSignUpFormMessage () {
        return getText (signUpFormMessage);
    }

    public String getLoginFormMessage () {
        return getText (loginFormMessage);
    }

    public void clickOnOkButton() {
        click (signUpFormOkButton);
    }

    @Override
    public void alertControl() {

    }
}
