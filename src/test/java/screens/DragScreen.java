package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import util.screens.BaseScreen;

public class DragScreen extends BaseScreen {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Drag and Drop\")")
    private AndroidElement screenText;

    public String getDragScreenText() {
        return getText(screenText);
    }

    public DragScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public void alertControl() {

    }
}
