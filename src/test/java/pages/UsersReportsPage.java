package pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Hooks;
import util.PageTools;
import util.helpers.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class UsersReportsPage extends PageTools {
    @FindBy(xpath ="//div[contains(@id,'reported-users')]//tr[@data-row-key]")
    private List<WebElement> userReportsRows;

    public String selectRandomUserReport() {
        SeleniumHelper.delay(5);
        return userReportsRows.get(RandomUtils.nextInt(0, userReportsRows.size())).getAttribute("data-row-key");
    }

    public void clickOnConfirmUserReport(String randomUserReportId, String reportResolution) {
        click(waitIsElementClickable(waitIsElementVisible(Hooks.getDriver().findElement(By.xpath(String.format("//div[contains(@id,'reported-users')]//tr[@data-row-key='%s']//span[@data-qa-id='%s']", randomUserReportId,reportResolution ))))));
    }

    public List<String> getUserReportsList() {
        SeleniumHelper.delay(2);
        return waitIsElementsVisible(userReportsRows).stream().map(row -> row.getAttribute("data-row-key")).collect(Collectors.toList());
    }
}
