package automation.core.test.program;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.core.reporting.Logger;
import automation.core.runner.Config.Group;
import automation.core.test.BaseTest;
import automation.core.ui.page.ProgramPage;
import io.qameta.allure.Description;

public class ProgramContentTest extends BaseTest {

    private static final Logger LOGGER = new Logger(ProgramContentTest.class);

    private ProgramPage programPage;

    @Test(groups = { Group.FULL })
    @Description("Check content of program page.")
    public void contentTest() {

        welcomePage.open();

        programPage = welcomePage.clickExploreNewBtn();
        Assert.assertFalse(programPage.isTitleVisible(), "Incorrect page title.");
    }
}
