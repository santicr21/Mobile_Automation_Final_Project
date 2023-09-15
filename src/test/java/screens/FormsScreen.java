package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import util.screens.BaseScreen;

public class FormsScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Form components\")")
    private AndroidElement screenText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Swipe\")")
    private AndroidElement swipeScreenButton;

    public String getFormsScreenText() {
        return getText(screenText);
    }

    public SwipeScreen goToSwipeScreen() {
        click (swipeScreenButton);
        return new SwipeScreen(super.driver);
    }

    public FormsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public void alertControl() {

    }
}
