package automation.core.ui.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.core.driver.DriverManager;
import automation.core.ui.AbstractPage;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ProgramPage extends AbstractPage {

    public static final String TITLE = "MENTORING PROGRAM";

    public ProgramPage(DriverManager driverManager) {
        super(driverManager);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @FindBy(tagName = "h4")
    private TextBlock title;

    public boolean isTitleVisible() {
        return title.isDisplayed();
    }

}
