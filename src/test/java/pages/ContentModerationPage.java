package pages;

import org.openqa.selenium.By;
import util.Hooks;
import util.PageTools;
import util.helpers.SeleniumHelper;

public class ContentModerationPage extends PageTools {

    public void clickReportSubjectTab(String reportSubject) {
        SeleniumHelper.delay(3);
        click( waitIsElementVisible(Hooks.getDriver().findElement(By.xpath(String.format("//*[@data-qa-id='%s-tab']",reportSubject )))));
    }
}
