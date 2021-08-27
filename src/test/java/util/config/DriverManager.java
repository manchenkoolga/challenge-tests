package util.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

    public static WebDriver startDriver(String browser, String testName, String videoName) {
        switch (browser) {
            case "chrome":
                RemoteWebDriver remoteWebDriver = null;
                try {
                    remoteWebDriver = new RemoteWebDriver(
                            new URL(System.getProperty("selenoid.url", ReadConfig.getConfigProperty("selenoid_url"))), chromeCapabilities(testName, videoName));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Objects.requireNonNull(remoteWebDriver).setFileDetector(new LocalFileDetector());
                return remoteWebDriver;
            case "local_chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(Boolean.parseBoolean(System.getProperty("headless", "false")));
                chromeOptions.setUnhandledPromptBehaviour((UnexpectedAlertBehaviour.ACCEPT));
                chromeOptions.addArguments("--window-size=1920,1080");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                Logger.getLogger("org.openqa.selenium").setLevel(Level.INFO);

                return new ChromeDriver(chromeOptions);
            default:
                throw new WebDriverException(String.format("Browser: %s is invalid or not supported by project yet", browser));
        }
    }

    private static DesiredCapabilities chromeCapabilities(String testName, String videoName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", "true",
                "enableVideo", "false",
                "videoName", "video_" + videoName + ".mp4",
                "name", testName,
                "sessionTimeout", "3m",
                "timeZone", "America/Los_Angeles")
        );

        capabilities.setCapability("unhandledPromptBehavior", UnexpectedAlertBehaviour.ACCEPT);
        capabilities.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.ACCEPT);
        return capabilities;
    }
}
