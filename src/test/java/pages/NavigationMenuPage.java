package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageTools;
import util.helpers.SeleniumHelper;

public class NavigationMenuPage  extends PageTools {

    public void openChallengeSectionByName(String challengeSectionText) {
        By challengeSection = By.xpath((String.format("//a[@href='/%s']",challengeSectionText)));
        click(challengeSection);
    }
}
