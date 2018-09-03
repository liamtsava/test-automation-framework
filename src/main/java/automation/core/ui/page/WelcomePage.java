package automation.core.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.core.runner.TestRunParameters;
import automation.core.ui.AbstractPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class WelcomePage extends AbstractPage {

    public static final String TITLE = "TEST AUTOMATION MENTORING PORTAL";

    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @FindBy(tagName = "h1")
    private TextBlock title;

    @FindBy(css = "#toProgram")
    private Button exploreNewBtn;

    public void open() {
        driver.get(TestRunParameters.getUrl());
    }
    
    public String getTitle() {
        return title.getText();
    }

    public boolean isExploreNewButtonVisible() {
        return exploreNewBtn.isDisplayed();
    }
    
    public ProgramPage clickExploreNewBtn() {
        exploreNewBtn.click();
        return new ProgramPage(driver);
    }
}
