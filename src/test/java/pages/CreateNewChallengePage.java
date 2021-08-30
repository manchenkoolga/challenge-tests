package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Hooks;
import util.PageTools;
import util.helpers.Helper;


public class CreateNewChallengePage extends PageTools {
    @FindBy(xpath = "//h1[text()='Creating New Challenge']")
    private WebElement createNewChallengeHeader;

    @FindBy(xpath = "//*[@id='title']")
    private WebElement challengeTitleInputField;

    @FindBy(xpath = "//span[input[@id='interestId']]")
    private WebElement challengeInterestInputDropdown;

    @FindBy(xpath = "//div[@class='ant-select-item-option-content'][text()='DIY']")
    private WebElement challengeInterestSelection;

    @FindBy(xpath = "//*[@id='hashtag']")
    private WebElement challengeHashTagInputField;

    @FindBy(xpath = "//*[@id='description']")
    private WebElement challengeDescriptionInputField;

    @FindBy(xpath = "//*[@id='dateStart']")
    private WebElement challengeStartDateInputField;

    @FindBy(xpath = "//*[@id='dateEnd']")
    private WebElement challengeEndDateInputField;

    @FindBy(xpath="//*[@id='timeStart']")
    private WebElement challengeStartTimeInputField;

    @FindBy(xpath="//*[@id='timeEnd']")
    private WebElement challengeEndTimeInputField;

    @FindBy(xpath="//button[@data-qa-id='save-draft']")
    private WebElement saveDraftButton;

    @FindBy(xpath="//input[@type='file']")
    private  WebElement browseCoverImageInput;

    @FindBy(xpath = "//*[@data-qa-id='browse-idea-cover-image']")
    private WebElement browsLink;

    String challengeHashtag;
    String challengeDescription;



    public boolean isCreateNewChallengeDisplayed(){
        return isElementDisplayed(createNewChallengeHeader);
    }

    public void enterChallengeTitle(String challengeTitle) {
        sendKeys(challengeTitleInputField, challengeTitle);
    }

    public void selectChallengeInterest() {
        click(challengeInterestInputDropdown);
        click(challengeInterestSelection);
    }

    public void enterChallengeHashTag(String challengeHashtag) {
        sendKeys(challengeHashTagInputField, challengeHashtag);
    }

    public void enterChallengeDescription(String challengeDescription) {
        sendKeys(challengeDescriptionInputField, challengeDescription);
    }

    public void enterChallengeStartDate(String challengeStartDate) {
        click(challengeStartDateInputField);
        sendKeys(challengeStartDateInputField, challengeStartDate);
    }

    public void enterChallengeEndDate(String challengeEndDate) {
        click(challengeEndDateInputField);
        sendKeys(challengeEndDateInputField, challengeEndDate );
    }

    public void enterChallengeStartTime(String challengeStartTime) {
        click(challengeStartTimeInputField);
        sendKeys(challengeStartTimeInputField, challengeStartTime);
        challengeStartTimeInputField.sendKeys(Keys.ENTER);
    }

    public void enterChallengeEndTime(String challengeEndTime) {
        click(challengeEndTimeInputField);
        sendKeys(challengeEndTimeInputField, challengeEndTime);
        challengeEndTimeInputField.sendKeys(Keys.ENTER);
    }

    public void clickSaveDraftButton() {
        click(saveDraftButton);
    }

    public boolean isChallengeTitleDisplayed(String challengeTitle) {
        return isElementDisplayed(By.xpath("//h1[text()='"+challengeTitle+"']"));
    }

    public void uploadChallengeImage(String image) {
        sendKeys(browseCoverImageInput,Helper.getImagesPath(image) );
    }

    public String storeChallengeTitle() {
        return challengeTitleInputField.getAttribute("value");
    }
}
