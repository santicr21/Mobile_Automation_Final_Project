package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import util.screens.BaseScreen;

public class MainScreen extends BaseScreen {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */

    /** Button */

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Webview\")")
    private AndroidElement webViewButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Login\")")
    private AndroidElement loginScreenButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().descriptionContains(\"Swipe\")")
    private AndroidElement swipeScreenButton;

    public MainScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public void alertControl() {}

    public WebViewScreen goToWebViewScreen() {
        click (webViewButton, 10);
        return new WebViewScreen(driver);
    }

    public LoginScreen goToLoginScreen() {
        click (loginScreenButton, 10);
        return new LoginScreen(driver);
    }

    public SwipeScreen goToSwipeScreen () {
        click (swipeScreenButton);
        return new SwipeScreen(super.driver);
    }
}
