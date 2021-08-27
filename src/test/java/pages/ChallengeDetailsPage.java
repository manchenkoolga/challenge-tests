package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageTools;

public class ChallengeDetailsPage extends PageTools {
    @FindBy (xpath = "//h1")
    private WebElement challengeTitle;

    @FindBy (xpath="//*[@data-qa-id='status']")
    private WebElement challengeStatus;

    public String getChallengeTitle() {
        return getElementText(challengeTitle);
    }

    public String getChallengeStatus() {
        return waitIsElementVisible(challengeStatus).getText();
    }
}
