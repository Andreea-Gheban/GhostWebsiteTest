package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static common.BaseClass.*;

public class Hooks {

    @Before
    public static void setup() {
        initializeDriver();
    }

    @After
    public static void quitApp() {
        driver.quit();
    }

}
