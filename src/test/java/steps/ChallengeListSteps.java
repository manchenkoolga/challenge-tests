package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ChallengeDetailsPage;
import pages.ChallengeListPage;
import util.helpers.SeleniumHelper;

import java.util.stream.IntStream;

public class ChallengeListSteps {
  private final ChallengeListPage challengeListPage;
  private final ChallengeDetailsPage challengeDetailsPage;
  private String randomChallengeId;

    public ChallengeListSteps() {
      challengeListPage = new ChallengeListPage();
      challengeDetailsPage = new ChallengeDetailsPage();
    }

    @Then("I should see Create Challenge Section")
    public void iShouldSeeCreateChallengeSection() {
        Assert.assertTrue(challengeListPage.isCreateNewChallengeButtonDisplayed());
    }

    @When("I click on Create New Challenge button")
    public void iClickOnCreateNewChallengeButton() {
        challengeListPage.clickOnCreateNewChallengeButton();
    }

    @And("I select a random challenge")
    public void iSelectARandomChallenge() {
        randomChallengeId = challengeListPage.getRandomChallenge();
    }

    @And("I click on Edit challenge button")
    public void iClickOnEditChallengeButton() {
        challengeListPage.clickOnEditChallengeButton(randomChallengeId);
    }

    @And("I click on tab {string}")
    public void iClickOnTab(String tabTitle) {
        challengeListPage.clickOnChallengeTab(tabTitle);
    }

    @Then("I verify that challenges on this tab have  {string} status")
    public void iVerifyThatChallengesOnThisTabHaveStatus(String challengeStatus) {
        SeleniumHelper.delay(2);
        IntStream.range(0, challengeListPage.getNumberOfChallenges().size()).forEach(rowIndex-> {
            challengeListPage.clickOnChallengeRow(rowIndex);
            Assert.assertEquals(challengeStatus,challengeDetailsPage.getChallengeStatus().toLowerCase());
            SeleniumHelper.navigateBack();
            SeleniumHelper.delay(2);
        });
    }
}

