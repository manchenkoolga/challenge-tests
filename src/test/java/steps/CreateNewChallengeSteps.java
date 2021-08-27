package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateNewChallengePage;
import util.helpers.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateNewChallengeSteps {
    private final CreateNewChallengePage createNewChallengePage;
    private final String  challengeTitle = Helper.generateRandomChallengeTitle(5);
    private final String challengeHashtag = Helper.generateRandomChallengeHashTag(3);
    private final String challengeDescription = Helper.generateRandomChallengeDescription(3);
    private final String challengeStartDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
    private final String challengeEndDate=LocalDateTime.now().plusDays(10).format(DateTimeFormatter.ofPattern("MMddyyyy"));
    private final String challengeStartTime="12:00 A";

    public CreateNewChallengeSteps() {
        createNewChallengePage = new CreateNewChallengePage();
    }

    @Then("I should see Creating New Challenge page")
    public void iShouldSeeCreatingNewChallengePage() {
        Assert.assertTrue(createNewChallengePage.isCreateNewChallengeDisplayed(), "can't find Create New Challenge button");
    }

    @When("I enter Challenge Title")
    public void iEnterChallengeTitle() {
        createNewChallengePage.enterChallengeTitle(challengeTitle);
    }

    @And("I select Challenge Interest")
    public void iSelectChallengeInterest() {
        createNewChallengePage.selectChallengeInterest();
    }

    @And("I enter Challenge Hashtag")
    public void iEnterChallengeHashtag() {
        createNewChallengePage.enterChallengeHashTag(challengeHashtag);
    }

    @And("I enter Challenge Description")
    public void iEnterChallengeDescription() {
        createNewChallengePage.enterChallengeDescription(challengeDescription);
    }

    @And("I enter Challenge Start Date")
    public void iEnterChallengeStartDate() {
        createNewChallengePage.enterChallengeStartDate(challengeStartDate);
    }

    @And("I enter Challenge End Date")
    public void iEnterChallengeEndDate() {
        createNewChallengePage.enterChallengeEndDate(challengeEndDate);
    }

    @And("I enter Challenge Start Time")
    public void iEnterChallengeStartTime() {
        createNewChallengePage.enterChallengeStartTime(challengeStartTime);
    }

    @And("I enter Challenge End Time")
    public void iEnterChallengeEndTime() {
        createNewChallengePage.enterChallengeEndTime();
    }

    @And("I click on Save Draft button")
    public void iClickOnSaveDraftButton() {
        createNewChallengePage.clickSaveDraftButton();
    }

    @Then("I should see Challenge Details screen")
    public void iShouldSeeChallengeDetailsScreen() {
        Assert.assertTrue(createNewChallengePage.isChallengeTitleDisplayed(challengeTitle), "challenge title not found");
    }

    @And("I upload Challenge Image {string}")
    public void iUploadChallengeImage(String image) {
        createNewChallengePage.uploadChallengeImage(image);
    }
}

