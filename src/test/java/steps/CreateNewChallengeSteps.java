package steps;

import entities.ChallengeEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateNewChallengePage;

public class CreateNewChallengeSteps {
    private final CreateNewChallengePage createNewChallengePage;
    private final ChallengeEntity challengeEntity;

    public CreateNewChallengeSteps() {
        createNewChallengePage = new CreateNewChallengePage();
        challengeEntity = new ChallengeEntity();
    }

    @Then("I should see Creating New Challenge page")
    public void iShouldSeeCreatingNewChallengePage() {
        Assert.assertTrue(createNewChallengePage.isCreateNewChallengeDisplayed(), "can't find Create New Challenge button");
    }

    @When("I enter Challenge Title")
    public void iEnterChallengeTitle() { createNewChallengePage.enterChallengeTitle(challengeEntity.getChallengeTitle()); }

    @And("I select Challenge Interest")
    public void iSelectChallengeInterest() {
        createNewChallengePage.selectChallengeInterest();
    }

    @And("I enter Challenge Hashtag")
    public void iEnterChallengeHashtag() {
        createNewChallengePage.enterChallengeHashTag(challengeEntity.getChallengeHashtag());
    }

    @And("I enter Challenge Description")
    public void iEnterChallengeDescription() {
        createNewChallengePage.enterChallengeDescription(challengeEntity.getChallengeDescription());
    }

    @And("I enter Challenge Start Date")
    public void iEnterChallengeStartDate() {
        createNewChallengePage.enterChallengeStartDate(challengeEntity.getChallengeStartDate());
    }

    @And("I enter Challenge End Date")
    public void iEnterChallengeEndDate() {
        createNewChallengePage.enterChallengeEndDate(challengeEntity.getChallengeEndDate());
    }

    @And("I enter Challenge Start Time")
    public void iEnterChallengeStartTime() {
        createNewChallengePage.enterChallengeStartTime(challengeEntity.getChallengeStartTime());
    }

    @And("I enter Challenge End Time")
    public void iEnterChallengeEndTime() {
        createNewChallengePage.enterChallengeEndTime(challengeEntity.getChallengeEndTime());
    }

    @And("I click on Save Draft button")
    public void iClickOnSaveDraftButton() {
        createNewChallengePage.clickSaveDraftButton();
    }

    @Then("I should see Challenge Details screen")
    public void iShouldSeeChallengeDetailsScreen() {
        Assert.assertTrue(createNewChallengePage.isChallengeTitleDisplayed(challengeEntity.getChallengeTitle()), "challenge title not found");
    }

    @And("I upload Challenge Image {string}")
    public void iUploadChallengeImage(String image) {
        createNewChallengePage.uploadChallengeImage(image);
    }
}

