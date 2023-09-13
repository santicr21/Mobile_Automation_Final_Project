package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class UpdateScreen extends BaseScreen {


  /**
   * Constructor method.
   *
   * @author david.rd
   * @param driver the driver
   */
  public UpdateScreen(AndroidDriver<AndroidElement> driver){
    super(driver);
  }


  /** The sign in button. */
  @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
  @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"dismiss-icon\"]/android.view.View/android.widget.TextView")
  private AndroidElement dismissButton;

  public DashBoardScreen dismissUpdate(){
    click(dismissButton);
    return new DashBoardScreen(driver);
  }


  @Override
  public void alertControl() {

  }
}
