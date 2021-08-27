package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChallengeDetailsPage;
import pages.CreateNewChallengePage;
import pages.EditChallengePage;
import util.helpers.Helper;

import static org.assertj.core.api.Assertions.assertThat;

public class EditChallengeSteps {
    private final EditChallengePage editChallengePage;
    private final CreateNewChallengePage createNewChallengePage;
    private final ChallengeDetailsPage challengeDetailsPage;
    private final String challengeTitleUpdated = Helper.generateRandomChallengeTitle(5);

    public EditChallengeSteps() {
        editChallengePage = new EditChallengePage();
        createNewChallengePage = new CreateNewChallengePage();
        challengeDetailsPage = new ChallengeDetailsPage();
    }

    @Then("I should see Edit Challenge screen")
    public void iShouldSeeEditChallengeScreen() {
        editChallengePage.isHeaderDisplayed();

    }

//    @And("I store Challenge Title")
//    public void iStoreChallengeTitle() {
//        challengeTitle = createNewChallengePage.storeChallengeTitle();
//    }

    @When("I clear Challenge Title input field")
    public void iClearChallengeTitleInputField() {
        editChallengePage.clearChallengeTitleInputField();
    }

    @When("I enter Updated Challenge Title")
    public void iEnterUpdatedChallengeTitle() {
        editChallengePage.enterUpdatedChallengeTitle(challengeTitleUpdated);
    }

    @And("I verify Challenge Title {string}")
    public void iVerifyChallengeTitle(String updateStatus) {
        switch (updateStatus) {
            case "was updated":
                assertThat(challengeDetailsPage.getChallengeTitle().contains(challengeTitleUpdated));
                break;
            case "was NOT updated":
                assertThat(challengeDetailsPage.getChallengeTitle().contains(createNewChallengePage.storeChallengeTitle()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + updateStatus);
        }
    }

}
