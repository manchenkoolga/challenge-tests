package pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import util.PageTools;
import util.Hooks;
import util.helpers.SeleniumHelper;

import java.util.stream.Collectors;
import java.util.List;



public class ChallengeListPage extends PageTools {
    @FindBy(xpath = "//a[@data-qa-id = 'create-new-challenge']")
    private WebElement createNewChallengeButton;

//    @FindBy(xpath = "//a[@data-qa-id='edit']")
//    private List<WebElement> editChallengeButton;

    @FindBy(xpath = "//tr[@data-row-key]")
    private List<WebElement> challengeRows;

    public boolean isCreateNewChallengeButtonDisplayed() {
        return isElementDisplayed(createNewChallengeButton);
    }

    public void clickOnCreateNewChallengeButton() { click(createNewChallengeButton); }

    public String getRandomChallenge() {
//        numberOfChallengeRows = RandomUtils.nextInt(0, challengeRows.size());
//        click(editChallengeButton.get(numberOfChallengeRows));
        List<String> challengeIdList = waitIsElementsVisible(challengeRows).stream().map(row -> row.getAttribute("data-row-key")).collect(Collectors.toList());
        return challengeIdList.get(RandomUtils.nextInt(0, challengeIdList.size()));
    }

    public void clickOnEditChallengeButton(String randomChallengeId) {
        WebElement editChallengeButton = waitIsElementVisible(Hooks.getDriver().findElement(By.xpath(String.format("//a[@data-qa-id='edit'][@href='/challenges/%s/edit']", randomChallengeId))));
//       By editChallengeButton = By.xpath(String.format("//a[@data-qa-id='edit'][@href='/challenges/%s/edit']", randomChallengeId));
        click(editChallengeButton);
    }


    public void clickOnChallengeTab(String tabTitle) {
        SeleniumHelper.delay(2);
        WebElement challengeTab = waitIsElementVisible(Hooks.getDriver().findElement(By.xpath(String.format("//*[@data-qa-id='%s-tab']", tabTitle))));
        click(challengeTab);
    }

    public void clickOnChallengeRow(int rowIndex) {
        click(challengeRows.get(rowIndex));
    }

    public List<WebElement> getNumberOfChallenges() {
        return getElementsList(waitIsElementsVisible(challengeRows));
    }
}
