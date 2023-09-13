package util.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import screens.DashBoardScreen;
import screens.MainScreen;
import screens.TutorialScreen;
import util.ConfigCapabilities;

/**
 * Base class for Test classes.
 * 
 * @author helberth.bolivar
 *
 */
public abstract class BaseMobileTest {

	protected TutorialScreen tutorialScreen;
	public static AndroidDriver<AndroidElement> driver;
	public Logger log = Logger.getLogger(BaseMobileTest.class);

	public void setUpStartApp() {
		tutorialScreen = new TutorialScreen(getDriver());
	}

	/**
	 * SetUp before to run suite of test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@BeforeClass(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		}
		setUpStartApp();
	}

	/**
	 * Close the application after completing the test.
	 * 
	 * @author Arley.Bolivar
	 * 
	 */
	@AfterClass(alwaysRun = true)
	public void mobileApplicationEnd() {
		driver.quit();
	}

	/**
	 * return the driver.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return driver
	 */
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	/**
	 * return SignUpOrLogInScreen after close the alerts.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return SignUpOrLogInScreen
	 */
	protected DashBoardScreen loadDashBoardScreen() {
		return tutorialScreen.handleAlerts();
	}

	protected MainScreen loadMainScreen() {
		return new MainScreen(getDriver());
	}
	
	/**
	 * Scroll Over Tutorial Screen
	 * 
	 * @author Hans.Marquez
	 * 
	 */
	protected void scrollOverTutorial() {
		tutorialScreen.scrollOverTutorial();
	}

}
