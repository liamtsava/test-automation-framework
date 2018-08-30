package automation.core.guice.module;

import org.openqa.selenium.WebDriver;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import automation.core.guice.module.provider.WebDriverProvider;
import automation.core.ui.page.WelcomePage;

public class FunctionalTestModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
    }
    
    @Provides
    public WelcomePage provideAbstractHomepage(WebDriver driver) {
        return new WelcomePage(driver);
    }

}
