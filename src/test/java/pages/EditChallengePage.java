package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.PageTools;

public class EditChallengePage extends PageTools {
    @FindBy(xpath = "//h1[text()='Edit Challenge']")
    private WebElement editChallengeHeader;

    @FindBy(xpath = "//*[@id='title']")
    private WebElement challengeTitleInputField;

    public void isHeaderDisplayed() {
        Assert.assertTrue(isElementDisplayed(editChallengeHeader));
    }

    public void clearChallengeTitleInputField() {
        jsClick(challengeTitleInputField);
        while (!challengeTitleInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(challengeTitleInputField, Keys.BACK_SPACE).perform();
        }
        getAction().sendKeys(Keys.ESCAPE).perform();
    }

    public void enterUpdatedChallengeTitle(String challengeTitleUpdated) {
        sendKeys(challengeTitleInputField,
                challengeTitleUpdated);
    }


}
