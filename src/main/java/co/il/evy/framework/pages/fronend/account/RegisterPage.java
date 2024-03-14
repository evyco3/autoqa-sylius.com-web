package co.il.evy.framework.pages.fronend.account;



import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage {

    @FindBy(css = "#sylius_customer_registration_firstName")
    private WebElement firstName;
    @FindBy(css = "#sylius_customer_registration_lastName")
    private WebElement lastName;
    @FindBy(css = "#sylius_customer_registration_email")
    private WebElement email;
    @FindBy(css = "#sylius_customer_registration_phoneNumber")
    private WebElement phone;
    @FindBy(css = "#sylius_customer_registration_user_plainPassword_first")
    private WebElement password;
    @FindBy(css = "#sylius_customer_registration_user_plainPassword_second")
    private WebElement verification;
    @FindBy(css = "button[type*='sub']")
    private WebElement submit;
    @FindBy(css = ".sylius-validation-error")
    private WebElement errorMessage;
    @FindBy(css = ".ui.container>.ui.icon:first-of-type")
    private WebElement successRegisterMessage;


    public RegisterPage() {
        super();
    }


    public <T> PageObjectFactory<T> performRegistration(String firstName, String lastName, String email, String phone, String password, String verification, Class<T> nextPageClass) {
        sendKeys(this.firstName, firstName, "firstName");
        sendKeys(this.lastName, lastName, "lastName");
        sendKeys(this.email, email, "email");
        sendKeys(this.phone, phone, "phone");
        sendKeys(this.password, password, "password");
        sendKeys(this.verification, verification, "verification");
        click(this.submit, "create an account button");
        return PageObjectFactory.createPage(nextPageClass);

    }

    public String getResponseMessage(String expectedMessage) {
        if (expectedMessage.toLowerCase().contains("success")) {
            return getSuccessMessage();
        } else {
            return getErrorMessage();
        }
    }

    private String getSuccessMessage() {
        return getText(this.successRegisterMessage, "success register message");
    }

    private String getErrorMessage() {
        return getText(this.errorMessage, "error message");
    }


}