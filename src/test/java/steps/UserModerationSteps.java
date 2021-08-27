package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContentModerationPage;
import pages.UsersReportsPage;
import util.PageTools;

public class UserModerationSteps extends PageTools {
    private final ContentModerationPage contentModerationPage;
    private final UsersReportsPage usersReportsPage;
    private String randomUserReportId;

    public UserModerationSteps(){
        contentModerationPage = new ContentModerationPage();
        usersReportsPage = new UsersReportsPage();
    }

    @When("I click on {string} tab")
    public void iClickOnTab(String reportSubject) {
        contentModerationPage.clickReportSubjectTab(reportSubject);
    }

    @And("I select random user report")
    public void iSelectRandomUserReport() {
        randomUserReportId = usersReportsPage.selectRandomUserReport();
        System.out.print("selected random user report is: " + randomUserReportId);
    }

    @And("I {string} random user report")
    public void iConfirmRandomUser (String reportResolution) {
        usersReportsPage.clickOnConfirmUserReport(randomUserReportId, reportResolution);
    }

    @Then("I should No longer see my random user report in the list")
    public void iShouldNotSeeMyRandomUserReport() {
        Assert.assertFalse((usersReportsPage.getUserReportsList()).contains(randomUserReportId), randomUserReportId +"is present in the list");
    }
}
