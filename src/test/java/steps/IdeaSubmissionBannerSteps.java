package steps;

import entities.AdminUserEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.IdeaSubmissionBannerPage;
import util.api.OperatorApiClient;
import util.helpers.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdeaSubmissionBannerSteps {
    private final IdeaSubmissionBannerPage ideaSubmissionBannerPage;
    private String updatedIdeaReward;

    private final String submissionStartDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    private final String updatedSubmissionStartDate = LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

    private final String submissionEndDate = LocalDateTime.now().plusDays(2).format(DateTimeFormatter.ofPattern("MM/dd/yyy"));
    private final String updatedSubmissionEndDate = LocalDateTime.now().plusDays(9).format(DateTimeFormatter.ofPattern("MM/dd/yyy"));

    private final String submissionStartTime = "11:00 A";
    private final String updatedSubmissionStartTime = "12:00 A";

    private final String submissionEndTime = "11:00 A";
    private final  String updatedSubmissionEndTime = "12:00 A";


    public IdeaSubmissionBannerSteps() {
        ideaSubmissionBannerPage = new IdeaSubmissionBannerPage();
    }

    @When("I change Idea Submission Banner Status")
    public void iChangeIdeaSubmissionBannerStatus() {
        ideaSubmissionBannerPage.changeIdeaSubmissionBannerStatus();
    }

    @Then("I should see Submission Banner details are visible")
    public void iShouldSeeSubmissionBannerDetailsAreVisible() {
        Assert.assertTrue(ideaSubmissionBannerPage.isRewardInoputFieldVisisble());
    }

    @And("I should see Save button is disabled")
    public void iShouldSeeSaveButtonIsDisabled() {
        ideaSubmissionBannerPage.isSaveButtonDisabled();
    }

    @Given("I deactivate Idea Submission banner via API")
    public void iDeactivateIdeaSubmissionBannerViaAPI() {
        AdminUserEntity adminUserEntity = Helper.getUserCredentials("15sofAdmin");
        OperatorApiClient.iTurnOffIdeaSubmissionBanner(adminUserEntity.getEmail(), adminUserEntity.getPassword());
    }

    @When("I enter {string} as a reward in reward input field")
    public void iEnterRewardInRewardInputField(String reward) {
        ideaSubmissionBannerPage.enterRewardInRewardInputField(reward);
    }

    @And("I Enter Submission Start Date")
    public void iEnterSubmissionStartDate() {
        ideaSubmissionBannerPage.enterSubmissionStartDate(submissionStartDate);
    }

    @And("I Enter Submission End Date")
    public void iEnterSubmissionEndDate() {
        ideaSubmissionBannerPage.enterSubmissionEndDate(submissionEndDate);
    }

    @And("I Enter Submission End Time")
    public void iEnterSubmissionEndTime() {
        ideaSubmissionBannerPage.enterSubmissionEndTime(submissionEndTime);
    }

    @And("I Enter Submission Start Time")
    public void iEnterSubmissionStartTime() {
        ideaSubmissionBannerPage.enterSubmissionStartTime(submissionStartTime);

    }

    @And("I click on Save button on Idea Submission Banner status page")
    public void iClickOnSaveButton() {
        ideaSubmissionBannerPage.clickOnSaveButton();
    }

    @Then("I should see Edit button is displayed on Idea Submission Banner status page")
    public void iShouldSeeEditButtonIsDisplayed() {
        Assert.assertTrue(ideaSubmissionBannerPage.editButtonIsDisplayed());
    }

    @And("I click on Edit button on Idea Submission Banner status page")
    public void iClickOnEditButtonOn() {
        ideaSubmissionBannerPage.clickOnEditButton();
    }

    @And("I select random value for Idea Reward")
    public String selectRandomIdeaReward() {
        return updatedIdeaReward = ideaSubmissionBannerPage.selectRandomIdeaReward();
    }

    @And("I update Idea Reward in reward input field")
    public void iUpdateIdeaRewardInRewardInputField() {
        ideaSubmissionBannerPage.updateIdeaReward(updatedIdeaReward);
    }

    @And("I update Submission Start Date")
    public void iUpdateSubmissionStartDate() {
        ideaSubmissionBannerPage.updateSubmissionStartDate(updatedSubmissionStartDate);
    }

    @And("I update Submission End Date")
    public void iUpdateSubmissionEndDate() {
        ideaSubmissionBannerPage.updateSubmissionEndDate(updatedSubmissionEndDate);
    }

    @And("I update Submission Start Time")
    public void iUpdateSubmissionStartTime() {
        ideaSubmissionBannerPage.updateSubmissionStartTime(updatedSubmissionStartTime);
    }

    @And("I update Submission End Time")
    public void iUpdateSubmissionEndTime() {
        ideaSubmissionBannerPage.updateSubmissionEndTime(updatedSubmissionEndTime);
    }

    @Then("I should see Idea Reward is updated")
    public void iShouldSeeIdeaRewardIsUpdated() {
        Assert.assertEquals(updatedIdeaReward, ideaSubmissionBannerPage.getUpdatedIdeaReward());
    }

    @And("I should see Submission Start Date is updated")
    public void iShouldSeeSubmissionStartDateIsUpdated() {
        Assert.assertEquals(updatedSubmissionStartDate, ideaSubmissionBannerPage.getUpdatedSubmissionStartDate());
    }

    @And("I should see Submission End Date is updated")
    public void iShouldSeeSubmissionEndDateIsUpdated() {
        Assert.assertEquals(updatedSubmissionEndDate, ideaSubmissionBannerPage.getUpdatedSubmissionEndDate());
    }

    @And("I should see Submission Start Time is updated")
    public void iShouldSeeSubmissionStartTimeIsUpdated() {
        Assert.assertTrue((ideaSubmissionBannerPage.getUpdatedSubmissionStartTime()).contains(updatedSubmissionStartTime));
    }

    @And("I should see Submission End Time is updated")
    public void iShouldSeeSubmissionEndTimeIsUpdated() {
        Assert.assertTrue((ideaSubmissionBannerPage.getUpdatedSubmissionEndTime()).contains(updatedSubmissionEndTime));
    }

    @And("I should see Submission Banner {string} active")
    public void iShouldSeeSubmissionBannerActive(String submissionActivityStatus) {
        switch (submissionActivityStatus) {
            case "is":
                Assert.assertTrue(Boolean.parseBoolean(ideaSubmissionBannerPage.getSubmissionActivityStatus()));
                break;
            case "is not":
                Assert.assertFalse(Boolean.parseBoolean(ideaSubmissionBannerPage.getSubmissionActivityStatus()));
                break;
            default:
                throw new IllegalArgumentException("provide valid criteria");
        }
    }
}
