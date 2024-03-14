package co.il.evy.framework.pages;

import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.utils.ExecutionUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverThreadLocal.get(), this);
    }

    @Step("Displayed status")
    protected boolean isDisplayed(WebElement element, String elementName) {
        highlightElement(element, elementName);

        return ExecutionUtils.executeWithHandling(
                element::isDisplayed,
                "Is " + elementName + " displayed?"
        );
    }

    @Step("Type '{2}' into the element '{1}'")
    protected void sendKeys(WebElement element, String value, String elementName) {
        highlightElement(element, elementName);
        ExecutionUtils.executeWithHandling(
                () -> {
                    element.clear();
                    element.sendKeys(value);
                    return null;
                },
                "Type text into " + elementName + ":" + value
        );
    }



    @Step("Send keys using JavaScriptExecutor: {2} - {1}")
    protected void sendKeysUsingJavascript(WebElement element, String value, String elementName) {
        highlightElement(element, elementName);

        ExecutionUtils.executeWithHandling(
                () -> {
                    JavascriptExecutor executor = (JavascriptExecutor) DriverThreadLocal.get();
                    executor.executeScript("arguments[0].value=arguments[1];", element, value);
                    return null;
                },
                "Send keys to " + elementName + ":" + value
        );
    }

    @Step("Click with JavaScriptExecutor on {elementName}")
    protected void click(WebElement element, String elementName) {
        highlightElement(element, elementName);
        ExecutionUtils.executeWithHandling(
                () -> {
                    JavascriptExecutor executor = (JavascriptExecutor) DriverThreadLocal.get();
                    executor.executeScript("arguments[0].click();", element);
                    return null;
                },
                "Click with JavaScriptExecutor on " + elementName
        );
    }

    @Step("Get text from the element '{0}'")
    protected String getText(WebElement element, String elementName) {
        highlightElement(element, elementName);
        return ExecutionUtils.executeWithHandling(
                element::getText,
                "Get text from " + elementName+":"+element.getText()
        );
    }

    @Step("Select by visible text: {1}")
    protected void selectByVisibleText(WebElement element, String visibleText, String elementName) {
        highlightElement(element, elementName);
        ExecutionUtils.executeWithHandling(
                () -> {
                    Select select = new Select(element);
                    select.selectByVisibleText(visibleText);
                    return null;
                },
                "Select " + visibleText + " from " + elementName
        );
    }

    @Step("Navigate to URL: {0}")
    public <T> PageObjectFactory<T> openURL(String url, Class<T> nextClassPage) {
        return ExecutionUtils.executeWithHandling(
                () -> {
                    DriverThreadLocal.get().get(url);
                    return PageObjectFactory.createPage(nextClassPage);
                },
                "Open URL: " + url
        );
    }

    @Step("Move to page: {0}")
    public <T> PageObjectFactory<T> moveToPage(Class<T> nextClassPage) {
        return ExecutionUtils.executeWithHandling(
                () -> PageObjectFactory.createPage(nextClassPage),
                "Move to " + nextClassPage.getSimpleName()
        );
    }

    @Step("Wait for the page title to contain: {1}")
    protected void waitForTitleToContain(String partialTitle) {
        ExecutionUtils.executeWithHandling(
                () -> {
                    WebDriverWait wait = new WebDriverWait(DriverThreadLocal.get(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.titleContains(partialTitle));
                    return null;
                },
                "Wait for the page title to contain: " + partialTitle
        );
    }

    @Step("Navigate back")
    public <T> PageObjectFactory<T> navigateBack(Class<T> nextClassPage) {
        return ExecutionUtils.executeWithHandling(
                () -> {
                    DriverThreadLocal.get().navigate().back();
                    return PageObjectFactory.createPage(nextClassPage);
                },
                "Navigate back"
        );
    }

    public String getCurrentUrl() {
        return ExecutionUtils.executeWithHandling(
                () -> DriverThreadLocal.get().getCurrentUrl(),
                "Get current URL: "+DriverThreadLocal.get().getCurrentUrl()
        );
    }

    @Step("Click on the logo")
    public HomePage clickLogo() {
        return ExecutionUtils.executeWithHandling(
                () -> {
                    WebElement logoElement = DriverThreadLocal.get().findElement(By.cssSelector(".ui.small.image"));
                    highlightElement(logoElement, "logo");
                    logoElement.click();
                    return new HomePage();
                },
                "Click on the logo"
        );
    }

    @Step("Highlight element {elementName}")
    protected void highlightElement(WebElement element, String elementName) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverThreadLocal.get();
            jsExecutor.executeScript("arguments[0].style.border='1px solid blue'", element);
        } catch (Exception e) {

        }
    }
}