package steps;


import io.cucumber.java.en.When;
import pages.NavigationMenuPage;


public class NavigationMenuSteps {
    private final NavigationMenuPage navigationMenuPage;

    public NavigationMenuSteps() {
        navigationMenuPage = new NavigationMenuPage();
    }

    @When("I navigate to {string} section")
    public void iNavigateToSection(String challengeSection) {
        navigationMenuPage.openChallengeSectionByName(challengeSection);
    }
}
