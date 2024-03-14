package co.il.evy.framework.pages.fronend.account;

import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#_username")
    private WebElement email;
    @FindBy(css = "#_password")
    private WebElement password;
    @FindBy(css = "button[type*='subm']")
    private WebElement submit;

    @FindBy(css = ".ui.right>div")
    private WebElement successLoginMessage;
    @FindBy(css = ".negative.message p")
    private WebElement failedLoginMessage;

    public LoginPage(){
        super();
    }
    public <T> PageObjectFactory<T> performLogin(String email, String password, Class<T> nextPageClass) {
        sendKeys(this.email, email, "email");
        sendKeys(this.password, password, "password");
        click(this.submit, "login button");
        return PageObjectFactory.createPage(nextPageClass);
    }

    public String getMessage(String expectedMessage) {
        if (expectedMessage.toLowerCase().contains("hello")) {
            return getSuccessMessage();
        } else {
            return getFailedMessage();
        }
    }
    private String getSuccessMessage() {
        return getText(this.successLoginMessage, "profile image appears");
    }
    private String getFailedMessage(){
        return  getText(this.failedLoginMessage,"failed login message");
    }



}
