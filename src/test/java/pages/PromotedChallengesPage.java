package pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageTools;
import util.helpers.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class PromotedChallengesPage extends PageTools {
    @FindBy(xpath = "//tr[@data-row-key]")
    private List<WebElement> promotedChallengesRows;

    public String selectRandomPromotedChallenges() {
        List<String> promotedChallengesList = waitIsElementsVisible(promotedChallengesRows).stream().map(row -> row.getAttribute("data-row-key")).collect(Collectors.toList());
        return (promotedChallengesList.get(RandomUtils.nextInt(0,promotedChallengesList.size())));
    }

    public void clickEndPromotionForRandomChallenge(String randomPromotedChallenge) {
        By endChallengePromotionButton = By.xpath(String.format("//tr[@data-row-key='%s']//button[@data-qa-id='end-promotion']",randomPromotedChallenge));
        click(endChallengePromotionButton);
    }

    public boolean verifyPromotedChallengeListDoesNotContainMyRandomChallenge(String randomPromotedChallenge) {
        List<String> promptedChallengesList = promotedChallengesRows.stream().map(row->row.getAttribute("data-row-key")).collect(Collectors.toList());
        return (promptedChallengesList.contains(randomPromotedChallenge));

    }
}
