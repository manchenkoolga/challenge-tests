package util;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import util.allure.AllureLogger;
import util.allure.AllureTools;
import util.config.DriverManager;

public class Hooks extends AllureLogger {
    private static final ThreadLocal<WebDriver> concurrentDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return concurrentDriver.get();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        logInfo("Starting web driver ...");
        concurrentDriver.set(DriverManager.startDriver(
                System.getProperty("browser", "local_chrome"),
                scenario.getName(),
                scenario.getName().replaceAll("\\s", "")));

        concurrentDriver.get().manage().window().maximize();
        logInfo("STARTED Scenario: -> " + scenario.getName() + ", " + scenario.getUri());
    }

    @After
    public void afterScenario(Scenario scenario) {
        logInfo(scenario.getStatus() + " Scenario: -> " + scenario.getName() + ", " + scenario.getUri());
        AllureTools.checkScenario(scenario);

        getDriver().close();
        logInfo("Web driver closed.");

        getDriver().quit();
        logInfo("Web driver quit.");
    }
}


