package steps;

import entities.AdminUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import util.helpers.Helper;
import util.helpers.SeleniumHelper;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }


    @When("I enter {string} valid credentials")
    public void iEnterUserEmail(String user){
        AdminUser adminUser = Helper.getUserCredentials(user);
        loginPage.enterUserCredentials(adminUser.getEmail(), adminUser.getPassword());
    }

    @And("I click on SignIn button")
    public void iClickOnSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("I should see Idea Submission Banner Section")
    public void iShouldLandOnPage() {
        SeleniumHelper.delay(2);
        Assert.assertTrue(loginPage.isIdeaSubmissionBannerOpened());
    }
}
