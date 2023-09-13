package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

/**
 * DashBoard screen.
 * 
 * @author Hans.Marquez
 *
 */
public class DashBoardScreen extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * @author Hans.Marquez
	 * 
	 * @param androidDriver
	 *            : AndroidDriver
	 */
	public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\")")
	@AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*button1.*\").textContains(\"OK\")")
    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*permission.*allow.*button.*\")")
    private AndroidElement alertsPopUps;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement signInButton;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement userTextBox;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tmpsubacts_primary\")")
    private AndroidElement passwordTextBox;
	
	
	/**
	 * @author Hans.Marquez
	 *
	 * @description: Handle with random PopUps available in DashBoard Screen.
	 *
	 */
	public LoginScreen goToLoginScreen() {
		alertControl();
		click(signInButton);
		return new LoginScreen(driver);
	}
	

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		int retries = 0;
		while(retries < 3) {
			if(alertsPopUps.isDisplayed() == true) {
				click(alertsPopUps,3);
				retries++;
			}
		}	
	}
}
