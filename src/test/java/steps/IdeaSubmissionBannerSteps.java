package steps;

import entities.AdminUserEntity;
import entities.IdeaSubmissionBannerEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.IdeaSubmissionBannerPage;
import util.api.OperatorApiClient;
import util.helpers.Helper;

public class IdeaSubmissionBannerSteps {
    private final IdeaSubmissionBannerPage ideaSubmissionBannerPage;
    private final IdeaSubmissionBannerEntity ideaSubmissionBannerEntity;


    public IdeaSubmissionBannerSteps() {
        ideaSubmissionBannerEntity =  new IdeaSubmissionBannerEntity();
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

    @When("I enter Idea Reward")
    public void iEnterRewardInRewardInputField() {
        ideaSubmissionBannerPage.enterRewardInRewardInputField(ideaSubmissionBannerEntity.getIdeaReward());
    }

    @And("I Enter Submission Start Date")
    public void iEnterSubmissionStartDate() {
        ideaSubmissionBannerPage.enterSubmissionStartDate(ideaSubmissionBannerEntity.getSubmissionStartDate());
    }

    @And("I Enter Submission End Date")
    public void iEnterSubmissionEndDate() {
        ideaSubmissionBannerPage.enterSubmissionEndDate(ideaSubmissionBannerEntity.getSubmissionEndDate());
    }

    @And("I Enter Submission Start Time")
    public void iEnterSubmissionStartTime() {
        ideaSubmissionBannerPage.enterSubmissionStartTime(ideaSubmissionBannerEntity.getSubmissionStartTime());
    }

    @And("I Enter Submission End Time")
    public void iEnterSubmissionEndTime() {
        ideaSubmissionBannerPage.enterSubmissionEndTime(ideaSubmissionBannerEntity.getSubmissionEndTime());
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

//    @And("I select random value for Idea Reward")
//    public String selectRandomIdeaReward() {
//        return updatedIdeaReward = ideaSubmissionBannerPage.selectRandomIdeaReward();
//    }

    @And("I update Idea Reward in reward input field")
    public void iUpdateIdeaRewardInRewardInputField() {
        ideaSubmissionBannerPage.updateIdeaReward(ideaSubmissionBannerEntity.getUpdatedIdeaReward());
    }

    @And("I update Submission Start Date")
    public void iUpdateSubmissionStartDate() {
        ideaSubmissionBannerPage.updateSubmissionStartDate(ideaSubmissionBannerEntity.getUpdatedSubmissionStartDate());
    }

    @And("I update Submission End Date")
    public void iUpdateSubmissionEndDate() {
        ideaSubmissionBannerPage.updateSubmissionEndDate(ideaSubmissionBannerEntity.getUpdatedSubmissionEndDate());
    }

    @And("I update Submission Start Time")
    public void iUpdateSubmissionStartTime() {
        ideaSubmissionBannerPage.updateSubmissionStartTime(ideaSubmissionBannerEntity.getUpdatedSubmissionStartTime());
    }

    @And("I update Submission End Time")
    public void iUpdateSubmissionEndTime() {
        ideaSubmissionBannerPage.updateSubmissionEndTime(ideaSubmissionBannerEntity.getUpdatedSubmissionEndTime());
    }

    @Then("I should see Idea Reward is updated")
    public void iShouldSeeIdeaRewardIsUpdated() {
        Assert.assertEquals(ideaSubmissionBannerEntity.getUpdatedIdeaReward(), ideaSubmissionBannerPage.getUpdatedIdeaReward());
    }

    @And("I should see Submission Start Date is updated")
    public void iShouldSeeSubmissionStartDateIsUpdated() {
        Assert.assertEquals(ideaSubmissionBannerEntity.getUpdatedSubmissionStartDate(), ideaSubmissionBannerPage.getUpdatedSubmissionStartDate());
    }

    @And("I should see Submission End Date is updated")
    public void iShouldSeeSubmissionEndDateIsUpdated() {
        Assert.assertEquals(ideaSubmissionBannerEntity.getUpdatedSubmissionEndDate(), ideaSubmissionBannerPage.getUpdatedSubmissionEndDate());
    }

    @And("I should see Submission Start Time is updated")
    public void iShouldSeeSubmissionStartTimeIsUpdated() {
        Assert.assertTrue((ideaSubmissionBannerPage.getUpdatedSubmissionStartTime()).contains(ideaSubmissionBannerPage.getUpdatedSubmissionStartTime()));
    }

    @And("I should see Submission End Time is updated")
    public void iShouldSeeSubmissionEndTimeIsUpdated() {
        Assert.assertTrue((ideaSubmissionBannerPage.getUpdatedSubmissionEndTime()).contains(ideaSubmissionBannerEntity.getUpdatedSubmissionEndTime()));
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
