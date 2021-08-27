package util.allure;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Hooks;

public class AllureTools extends AllureLogger {
    private static final Logger LOG = LoggerFactory.getLogger(AllureTools.class);

    public static void checkScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            LOG.error("FAILED Scenario: -> '{}'", scenario.getName());
            attachScreenshot(scenario);
        }
    }

    private static void attachScreenshot(Scenario scenario) {
        LOG.info("Attach screenshot to failed scenario -> '{}'", scenario.getName());
        final byte[] screenshot = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
