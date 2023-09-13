package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import util.tests.BaseMobileTest;

public class GoToEachScreenTest extends BaseMobileTest {
    private MainScreen mainScreen;

    @BeforeMethod
    public void userOnHomeScreen () {
        mainScreen = loadMainScreen();
    }

    @Test
    public void testEachScreen () {
        String WEBVIEW_TEXT_RESULT = "Next-gen browser and mobile automation test framework for Node.js";
        String LOGIN_TEXT_RESULT = "Login / Sign up Form";
        String FORMS_TEXT_RESULT = "Form components";
        String SWIPE_TEXT_RESULT = "Swipe horizontal";
        String DRAG_TEXT_RESULT = "Drag and Drop";

        WebViewScreen webViewScreen = mainScreen.goToWebViewScreen();
        Assert.assertEquals(WEBVIEW_TEXT_RESULT, webViewScreen.getWebViewScreenText());

        LoginScreen loginScreen = webViewScreen.goToLoginScreen();
        Assert.assertEquals(LOGIN_TEXT_RESULT, loginScreen.getLoginScreenText());

        FormsScreen formsScreen = loginScreen.goToFormsScreen();
        Assert.assertEquals(FORMS_TEXT_RESULT, formsScreen.getFormsScreenText());

        SwipeScreen swipeScreen = formsScreen.goToSwipeScreen();
        Assert.assertEquals(SWIPE_TEXT_RESULT, swipeScreen.getSwipeScreenText());

        DragScreen dragScreen = swipeScreen.goToDragScreen();
        Assert.assertEquals(DRAG_TEXT_RESULT, dragScreen.getDragScreenText());
    }
}
