package automation.core.test.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import automation.core.guice.module.FunctionalTestModule;
import automation.core.runner.Config.Group;
import automation.core.test.BaseTest;
import automation.core.ui.page.ProgramPage;
import automation.core.ui.page.WelcomePage;

@Guice(modules = FunctionalTestModule.class)
public class ProgramContentTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ProgramContentTest.class);

    @Inject
    private WelcomePage welcomePage;
    private ProgramPage programPage;

    @Test(groups = { Group.FULL })
    public void contentTest() {

        welcomePage.open();
        programPage = welcomePage.clickExploreNewBtn();

        Assert.assertTrue(programPage.isTitleVisible(), "Incorrect wasn't found.");
    }
}
