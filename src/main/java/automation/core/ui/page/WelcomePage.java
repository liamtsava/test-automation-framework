package automation.core.ui.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.core.driver.DriverManager;
import automation.core.reporting.Logger;
import automation.core.runner.TestRunParameters;
import automation.core.ui.AbstractPage;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class WelcomePage extends AbstractPage {

    private static final Logger LOGGER = new Logger(WelcomePage.class);

    public static final String TITLE = "TEST AUTOMATION MENTORING PORTAL";

    public WelcomePage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),
                this);
    }

    @FindBy(tagName = "h1")
    private TextBlock title;

    @FindBy(css = "#toProgram")
    private Button exploreNewBtn;

    @Step("Open welcome page.")
    public void open() {
        driver.get(TestRunParameters.getUrl());
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean isExploreNewButtonVisible() {
        return exploreNewBtn.isDisplayed();
    }

    @Step("Open program page.")
    public ProgramPage clickExploreNewBtn() {
        exploreNewBtn.click();
        return new ProgramPage(driverManager);
    }
}
