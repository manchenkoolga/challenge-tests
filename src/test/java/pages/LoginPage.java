package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageTools;



public class LoginPage extends PageTools {

    @FindBy(xpath= "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath= "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath= "//*[@data-qa-id=\"login-button\"]")
    private WebElement signInButton;

    @FindBy(xpath="//h1[text()=\"Idea Submission banner\"]")
    private WebElement ideaSubmissionBannerHeader;

    public void enterUserCredentials(String email, String password) {
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isIdeaSubmissionBannerOpened() {
        return isElementVisible(ideaSubmissionBannerHeader);
    }
}
