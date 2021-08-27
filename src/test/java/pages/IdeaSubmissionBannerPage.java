package pages;

import com.fasterxml.jackson.databind.DatabindContext;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.PageTools;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import static util.helpers.SeleniumHelper.refresh;

public class IdeaSubmissionBannerPage extends PageTools {
    @FindBy(xpath = "//button[@data-qa-id = 'show-banner']")
    private WebElement showBannerStatus;

    @FindBy(xpath="//input[@id='reward']")
    private WebElement ideaRewardInputField;

    @FindBy(xpath = "//button[@data-qa-id='save']")
    private WebElement saveIdeaSubmissionButton;

    @FindBy(xpath = "//button[@data-qa-id = 'edit']")
    private WebElement editIdeaSubmissionButton;

    @FindBy(xpath = "//input[@id='dateStart']")
    private WebElement submissionStartDateInputField;

    @FindBy(xpath = "//input[@id='dateEnd']")
    private WebElement submissionEndDateInputField;

    @FindBy(xpath = "//input[@id='timeStart']")
    private WebElement submissionStartTimeInputField;

    @FindBy(xpath = "//input[@id='timeEnd']")
    private WebElement submissionEndTimeInputField;

    @FindBy(xpath = "//button[@data-qa-id='show-banner']")
    private WebElement submissionActivityStatus;

    public void changeIdeaSubmissionBannerStatus() {
        refresh();
        click(showBannerStatus);
    }

    public boolean isRewardInoputFieldVisisble() {
        return isElementVisible(ideaRewardInputField);
    }

    public void isSaveButtonDisabled() {
       Assert.assertNotNull(saveIdeaSubmissionButton.getAttribute("disabled"));

    }

    public void enterRewardInRewardInputField(String reward) {
        sendKeys(ideaRewardInputField, reward);
    }

    public void enterSubmissionStartDate(String submissionStartDate) {
        click(submissionStartDateInputField);
        sendKeys(submissionStartDateInputField, submissionStartDate);
        submissionStartDateInputField.sendKeys(Keys.ENTER);
    }

    public void enterSubmissionEndDate(String submissionEndDate) {
        click(submissionEndDateInputField);
        sendKeys(submissionEndDateInputField, submissionEndDate);
        submissionEndDateInputField.sendKeys(Keys.ENTER);
    }

    public void enterSubmissionEndTime(String submissionEndTime ) {
        click(submissionEndTimeInputField);
        sendKeys(submissionEndTimeInputField, submissionEndTime);
        submissionEndTimeInputField.sendKeys(Keys.ENTER);
    }

    public void enterSubmissionStartTime(String submissionStartTime) {
        click(submissionStartTimeInputField);
        sendKeys(submissionStartTimeInputField, submissionStartTime);
        submissionStartTimeInputField.sendKeys(Keys.ENTER);
    }

    public void clickOnSaveButton() {
        click(saveIdeaSubmissionButton);
    }

    public boolean editButtonIsDisplayed() {
        return waitIsElementVisible(editIdeaSubmissionButton).isDisplayed();
    }

    public void clickOnEditButton() {
        click(editIdeaSubmissionButton);
    }

    public String selectRandomIdeaReward() {
        return String.valueOf(RandomUtils.nextInt(1,99));
    }

    public void updateIdeaReward(String updatedIdeaReward) {
        jsClick(ideaRewardInputField);
        while (!ideaRewardInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(ideaRewardInputField, Keys.BACK_SPACE).perform();
        }
        sendKeys(ideaRewardInputField, updatedIdeaReward );
    }

    public void updateSubmissionStartDate(String updatedSubmissionStartDate) {
        jsClick(submissionStartDateInputField);
        while (!submissionStartDateInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(submissionStartDateInputField, Keys.BACK_SPACE).perform();
        }
        sendKeys(submissionStartDateInputField, updatedSubmissionStartDate);
        getAction().sendKeys(submissionStartDateInputField, Keys.ENTER).perform();
    }

    public void updateSubmissionEndDate(String updatedSubmissionEndDate) {
        jsClick(submissionEndDateInputField);
        while (!submissionEndDateInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(submissionEndDateInputField, Keys.BACK_SPACE).perform();
        }
        sendKeys(submissionEndDateInputField,updatedSubmissionEndDate);
        getAction().sendKeys(submissionEndDateInputField, Keys.ENTER).perform();
    }

    public void updateSubmissionStartTime(String updatedSubmissionStartTime) {
        jsClick(submissionStartTimeInputField);
        while (!submissionStartTimeInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(submissionStartTimeInputField, Keys.BACK_SPACE).perform();
        }

        sendKeys(submissionStartTimeInputField,updatedSubmissionStartTime);
        getAction().sendKeys(submissionStartTimeInputField, Keys.ENTER).perform();

    }

    public void updateSubmissionEndTime(String updatedSubmissionEndTime) {
        jsClick(submissionEndTimeInputField);
        while (!submissionEndTimeInputField.getAttribute("value").equals("")) {
            getAction().sendKeys(submissionEndTimeInputField, Keys.BACK_SPACE).perform();
        }
        sendKeys(submissionEndTimeInputField, updatedSubmissionEndTime);
        getAction().sendKeys(submissionEndTimeInputField, Keys.ENTER).perform();
    }

    public String getUpdatedIdeaReward() {
        return ideaRewardInputField.getAttribute("value");
    }

    public String getUpdatedSubmissionStartDate() {
        return (submissionStartDateInputField.getAttribute("value"));
    }

    public String getUpdatedSubmissionEndDate() {
        return (submissionEndDateInputField.getAttribute("value"));
    }

    public String getUpdatedSubmissionStartTime() {
        return (submissionStartTimeInputField.getAttribute("value"));
    }

    public String getUpdatedSubmissionEndTime() {
        return (submissionEndTimeInputField.getAttribute("value"));
    }

    public String getSubmissionActivityStatus() {
        return (submissionActivityStatus.getAttribute("aria-checked"));
    }
}
