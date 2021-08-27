package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.allure.AllureLogger;
import util.helpers.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class PageTools extends AllureLogger {
    private static final int TIMEOUT = 30;
    private final WebDriverWait wait;

    public PageTools() {
        wait = new WebDriverWait(Hooks.getDriver(), TIMEOUT);
        PageFactory.initElements(Hooks.getDriver(), this);
    }

    protected Select getSelect(WebElement element) {
        return new Select(waitIsElementVisible(element));
    }

    protected Actions getAction() {
        return new Actions(Hooks.getDriver());
    }

    /*For logging*/
    private static String getPreviousMethodNameAsText() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String replacedMethodName = methodName.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
        return replacedMethodName.substring(0, 1).toUpperCase() + replacedMethodName.substring(1).toLowerCase();
    }

    /*Parsing WebElements to string*/
    private String getStringFromElement(WebElement element) {
        String s = element.toString();
        if (s.contains("->")) {
            return s.substring(s.indexOf("->"), s.length() - 1);
        } else {
            return s.substring(s.indexOf("By"), s.length() - 1).replace("By.", "-> ");
        }
    }

    /*Parsing By elements to string*/
    private String getStringFromElement(By by) {
        String s = by.toString();
        if (s.contains("By.")) {
            return s.substring(s.indexOf("By")).replace("By.", "-> ");
        }
        return s;
    }

    private List<WebElement> waitIsElementsVisible(By by) {
        //wait.until((d) -> d.findElement(by).isDisplayed()); as an example with lambda
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected List<WebElement> waitIsElementsVisible(List<WebElement> element) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    private WebElement waitIsElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitIsElementVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitIsElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitIsElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected List<WebElement> getElementsList(List<WebElement> elements) {
        return waitIsElementsVisible(elements);
    }

    protected List<WebElement> getElementsList(By by) {
        return waitIsElementsVisible(by);
    }

    protected void click(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        waitIsElementClickable(element).click();
    }

    protected void click(By by) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(by));
        waitIsElementClickable(by).click();
    }

    protected void jsClick(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        ((JavascriptExecutor) Hooks.getDriver()).executeScript("arguments[0].click();", element);
    }

    protected void sendKeys(WebElement element, String value) {
        logInfo(getPreviousMethodNameAsText() + ", '" + value + "', element: " + getStringFromElement(element));
        waitIsElementVisible(element).clear();
        waitIsElementVisible(element).sendKeys(value);
    }

    protected void clearField(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        waitIsElementVisible(element).clear();
    }

    protected void selectOptionByText(WebElement element, String option) {
        logInfo(getPreviousMethodNameAsText() + ", '" + option + "', element: " + getStringFromElement(element));
        getSelect(element).selectByVisibleText(option);
    }

    protected String getElementText(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        String text = waitIsElementVisible(element).getText();
        logInfo("Text: " + text + ", element: " + getStringFromElement(element));
        return text;
    }

    protected String getElementText(By by) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(by));
        String text = waitIsElementVisible(by).getText();
        logInfo("Text: " + text + ", element: " + getStringFromElement(by));
        return text;
    }

    protected List<String> getElementsText(List<WebElement> elements) {
        logInfo(getPreviousMethodNameAsText());
        return getElementsList(elements).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    protected List<String> getElementsAttribute(List<WebElement> elements, String attribute) {
        logInfo(getPreviousMethodNameAsText());
        return getElementsList(elements).stream().map(el -> el.getAttribute(attribute)).collect(Collectors.toList());
    }

    protected String getElementAttribute(WebElement element, String attribute) {
        logInfo(getPreviousMethodNameAsText() + ", '" + attribute + "', element: " + getStringFromElement(element));
        return waitIsElementVisible(element).getAttribute(attribute);
    }

    protected String getElementAttribute(By by, String attribute) {
        logInfo(getPreviousMethodNameAsText() + ", '" + attribute + "', element: " + getStringFromElement(by));
        String attr = waitIsElementVisible(by).getAttribute(attribute);
        logInfo("Attribute value: " + attr + ", element: " + getStringFromElement(by));
        return attr;
    }

    protected String getElementCssValue(By by, String value) {
        logInfo(getPreviousMethodNameAsText() + ", '" + value + "', element: " + getStringFromElement(by));
        String attr = waitIsElementVisible(by).getCssValue(value);
        logInfo("Css value: " + attr + ", element: " + getStringFromElement(by));
        return attr;
    }

    protected String getElementCssValue(WebElement el, String value) {
        logInfo(getPreviousMethodNameAsText() + ", '" + value + "', element: " + getStringFromElement(el));
        String attr = waitIsElementVisible(el).getCssValue(value);
        logInfo("Css value: " + attr + ", element: " + getStringFromElement(el));
        return attr;
    }

    /*Working with wait for element*/
    protected boolean isElementVisible(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        SeleniumHelper.delay(2);
        try {
            return waitIsElementVisible(element).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*Working without wait for element*/
    protected boolean isElementDisplayed(WebElement element) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(element));
        SeleniumHelper.delay(2);
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*Working with wait for element By*/
    protected boolean isElementVisible(By by) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(by));
        SeleniumHelper.delay(2);
        try {
            return waitIsElementVisible(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*Working without wait for element*/
    protected boolean isElementDisplayed(By by) {
        logInfo(getPreviousMethodNameAsText() + ", element: " + getStringFromElement(by));
        SeleniumHelper.delay(2);
        try {
            return Hooks.getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void scrollPageToTheBottom() {
        ((JavascriptExecutor) Hooks.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
