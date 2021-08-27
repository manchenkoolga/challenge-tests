package steps;

import io.cucumber.java.en.Given;
import util.config.ReadConfig;
import util.helpers.SeleniumHelper;

public class BaseSteps {

    @Given ("I navigate to the Home Page")
    public void iNavigateToHomePage(){
        SeleniumHelper.navigateToUrl(ReadConfig.loadPropertiesFile("config.properties").getProperty("url"));
    }
}
