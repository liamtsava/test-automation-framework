package automation.core.test.welcome;

import org.testng.annotations.Test;

import automation.core.reporting.Logger;
import automation.core.runner.Config.Group;
import automation.core.test.BaseTest;
import automation.core.ui.page.WelcomePage;

public class WelcomeContentTest extends BaseTest {
    
    private static final Logger LOGGER = new Logger(WelcomeContentTest.class);

    @Test(groups = { Group.FULL })
    public void contentTest() {
        welcomePage.open();

        softAssert.assertEquals(welcomePage.getTitle(), WelcomePage.TITLE, "Incorrect title.");
        softAssert.assertTrue(welcomePage.isExploreNewButtonVisible(), "Explore button wasn't found.");
        softAssert.assertAll();
    }
}
