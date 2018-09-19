package automation.core.test.welcome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import automation.core.runner.Config.Group;
import automation.core.test.BaseTest;
import automation.core.ui.page.WelcomePage;

public class WelcomeContentTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(WelcomeContentTest.class);

    @Test(groups = { Group.FULL })
    public void contentTest() {
        welcomePage.open();

        softAssert.assertEquals(welcomePage.getTitle(), WelcomePage.TITLE, "Incorrect title.");
        softAssert.assertTrue(welcomePage.isExploreNewButtonVisible(), "Explore button wasn't found.");
        softAssert.assertAll();
    }
}
