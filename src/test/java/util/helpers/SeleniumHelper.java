package util.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Hooks;

public class SeleniumHelper {
    private static final Logger LOG = LoggerFactory.getLogger(SeleniumHelper.class);

    public static void navigateToUrl(String url) {
        LOG.info("Navigate to URL: -> " + url);
        Hooks.getDriver().navigate().to(url);
    }

    public static void refresh() {
        LOG.info("Refresh page");
        Hooks.getDriver().navigate().refresh();
    }

    public static void navigateBack() {
        LOG.info("Navigate back");
        Hooks.getDriver().navigate().back();
    }

    public static void delay(int seconds) {
        LOG.info("Wait - {} - seconds", seconds);
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
