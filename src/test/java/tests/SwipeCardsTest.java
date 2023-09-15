package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.MainScreen;
import screens.SwipeScreen;
import util.tests.BaseMobileTest;

public class SwipeCardsTest extends BaseMobileTest {
    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void MainScreen() {
        MainScreen mainScreen = loadMainScreen();
        swipeScreen = mainScreen.goToSwipeScreen();
    }

    @Test
    public void swipeCardsOnSwipeSectionTest () {
        String SECOND_CARD_TEXT_RESULT = "GREAT COMMUNITY"; // Getting the text of the second card
        String FIRST_CARD_TEXT_RESULT = "FULLY OPEN SOURCE"; // Getting the text of the first card

        // Getting the size (height and width) of the first card dot when user is on the first card
        int firstCardDotHighlightedHeight = swipeScreen.getFirstDotHeight();
        int firstCardDotHighlightedWidth = swipeScreen.getFirstDotWidth();

        swipeScreen.swipeCardToRight(); // Just swipe to the right from the first card

        // Getting the size (height and width) of the first card dot when user is not on the first card
        int firstCardDotHeight = swipeScreen.getFirstDotHeight();
        int firstCardDotWidth = swipeScreen.getFirstDotWidth();

        // Getting the size (height and width) of the second card dot when user is on the second card
        int secondCardDotHighlightedHeight = swipeScreen.getSecondDotHeight();
        int secondCardDotHighlightedWidth = swipeScreen.getSecondDotWidth();

        // Comparing the the text,
        Assert.assertEquals(swipeScreen.getSecondCardText(), SECOND_CARD_TEXT_RESULT);
        Assert.assertFalse(swipeScreen.isFirstCardImageVisible());
        Assert.assertTrue(firstCardDotHighlightedHeight > firstCardDotHeight);
        Assert.assertTrue(firstCardDotHighlightedWidth > firstCardDotWidth);

        swipeScreen.swipeCardToLeft();
        int secondCardDotHeight = swipeScreen.getSecondDotHeight();
        int secondCardDotWidth = swipeScreen.getSecondDotWidth();

        Assert.assertEquals(swipeScreen.getFirstCardText(), FIRST_CARD_TEXT_RESULT);
        Assert.assertFalse(swipeScreen.isSecondCardImageVisible());
        Assert.assertTrue(secondCardDotHighlightedWidth > secondCardDotWidth);
        Assert.assertTrue(secondCardDotHighlightedHeight > secondCardDotHeight);
    }
}
