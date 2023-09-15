package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.openqa.selenium.Point;
import util.screens.BaseScreen;

public class SwipeScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Swipe horizontal\")")
    private AndroidElement screenText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Drag\")")
    private AndroidElement dragScreenButton;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"GREAT COMMUNITY\")")
    private AndroidElement secondCardText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[1]")
    AndroidElement firstCard;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]")
    AndroidElement secondCard;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]/android.widget.TextView")
    AndroidElement secondCardImage;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"FULLY OPEN SOURCE\")")
    AndroidElement firstCardText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[1]/android.widget.TextView")
    AndroidElement firstCardImage;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    AndroidElement firstCardDot;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    AndroidElement secondCardDot;

    public DragScreen goToDragScreen() {
        click (dragScreenButton);
        return new DragScreen(super.driver);
    }

    public String getSwipeScreenText() {
        return getText(screenText);
    }

    public SwipeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void swipeCardToRight() {
        swipeHorizontal(firstCard, new Point(280, 1660));
    }

    public void swipeCardToLeft() {
        swipeHorizontal(secondCard, new Point(1224, 1660));
    }

    public String getSecondCardText () {
        return getText(secondCardText);
    }
    public String getFirstCardText () {
        return getText(firstCardText);
    }

    public boolean isFirstCardImageVisible() {
        return isElementAvailable(firstCardImage);
    }

    public boolean isSecondCardImageVisible() {
        return isElementAvailable(secondCardImage);
    }

    public int getFirstDotWidth () {
        return getWidth(firstCardDot);
    }

    public int getFirstDotHeight () {
        return getHeight(firstCardDot);
    }

    public int getSecondDotWidth () {
        return getWidth(secondCardDot);
    }

    public int getSecondDotHeight () {
        return getHeight(secondCardDot);
    }

    @Override
    public void alertControl() {

    }
}
