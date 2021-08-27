package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PromotedChallengesPage;

public class PromotedChallengesSteps {
    private final PromotedChallengesPage promotedChallengesPage;
    private String randomPromotedChallenge;

    public PromotedChallengesSteps() { promotedChallengesPage = new PromotedChallengesPage();}

    @And("I select random promoted challenge")
    public void iSelectRandomPromotedChallenges() {
        randomPromotedChallenge = promotedChallengesPage.selectRandomPromotedChallenges();
    }

    @And("I end Promotion for random challenge")
    public void iEndPromotionForRandomChallenge() {
        promotedChallengesPage.clickEndPromotionForRandomChallenge(randomPromotedChallenge);
    }

    @Then("I verify promoted challenges list does not contain my random challenge")
    public void iVerifyPromotedChallengesListDoesNotContainMyRandomChallenge() {
        Assert.assertFalse(promotedChallengesPage.verifyPromotedChallengeListDoesNotContainMyRandomChallenge(randomPromotedChallenge));
    }
}
