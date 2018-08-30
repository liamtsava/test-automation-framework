package automation.core.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    public void onStart(ISuite suite) {
        System.out.println("Start suite.");

    }

    public void onFinish(ISuite suite) {
        System.out.println("Finish suite");

    }

}
