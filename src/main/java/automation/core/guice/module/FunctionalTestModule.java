package automation.core.guice.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import automation.core.driver.DriverManager;
import automation.core.guice.module.provider.DriverManagerProvider;

public class FunctionalTestModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(DriverManager.class).toProvider(DriverManagerProvider.class).in(Singleton.class);;
    }

}
