package pages;

import org.openqa.selenium.By;
import util.PageTools;


public class NavigationMenuPage  extends PageTools {

    public void openChallengeSectionByName(String challengeSectionText) {
        By challengeSection = By.xpath((String.format("//a[@href='/%s']",challengeSectionText)));
        click(challengeSection);
    }
}
