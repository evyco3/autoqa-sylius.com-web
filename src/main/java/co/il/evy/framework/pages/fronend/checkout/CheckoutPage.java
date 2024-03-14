package co.il.evy.framework.pages.fronend.checkout;

import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(css = "#checkout_customer_email")
    private WebElement email;
    @FindBy(css="#checkout_billingAddress_firstName")
    private WebElement firstName;
    @FindBy(css = "#checkout_billingAddress_lastName")
    private WebElement lastName;
    @FindBy(css = "#checkout_billingAddress_company")
    private WebElement companyName;
    @FindBy(css = "#checkout_billingAddress_street")
    private WebElement streetAddress;
    @FindBy(css = "#checkout_billingAddress_countryCode")
    private WebElement country;
    @FindBy(css = "#checkout_billingAddress_city")
    private WebElement city;
    @FindBy(css = "#checkout_billingAddress_postcode")
    private WebElement postCode;
    @FindBy(css = "#checkout_billingAddress_phoneNumber")
    private WebElement phone;
    @FindBy(css = "#checkout_notes")
    private WebElement extraNote;
    @FindBy(css = "button[type*='subm']")
    private WebElement placeOrderBtn;
    @FindBy(css = "#sylius-thank-you>div")
    private WebElement serverResponseMessage;
    public CheckoutPage(){
        super();
    }
    public CheckoutPage setEmail(String email){
        sendKeysUsingJavascript(this.email,email,"email");
        return this;
    }
    public CheckoutPage setFirstName(String firstName){
        sendKeysUsingJavascript(this.firstName,firstName,"firstName");
        return this;
    }
    public CheckoutPage setLastName(String lastName){
        sendKeysUsingJavascript(this.lastName,lastName,"lastName");
        return this;
    }
    public CheckoutPage setCompany(String companyName){
        sendKeysUsingJavascript(this.companyName,companyName,"companyName");
        return this;
    }
    public CheckoutPage setStreetAddress(String streetAddress){
        sendKeysUsingJavascript(this.streetAddress,streetAddress,"streetAddress");
        return this;
    }
    public CheckoutPage setCountry(String country){
        selectByVisibleText(this.country,country,"country");
        return this;
    }
    public CheckoutPage setCity(String city){
        sendKeysUsingJavascript(this.city,city,"city");
        return this;
    }
    public CheckoutPage setPostCode(String postCode){
        sendKeysUsingJavascript(this.postCode,postCode,"post code");
        return this;
    }
    public CheckoutPage setPhone(String phone){
        sendKeysUsingJavascript(this.phone,phone,"phone");
        return this;
    }
    public CheckoutPage setShipment(String shipment){
        String val=String.format("//input[@type='radio'][@value='%s']",shipment);
        click(DriverThreadLocal.get().findElement(By.xpath(val)),shipment );
        return this;
    }
    public CheckoutPage setExtraNote(String extraNote){
        sendKeysUsingJavascript(this.extraNote,extraNote,"extraNote");
        return this;
    }
    public CheckoutPage clickPlaceOrderButton(){
        click(this.placeOrderBtn,"place order button");
        return this;
    }
    public String getServerResponseMessage(){
        return getText(this.serverResponseMessage,"response message");
    }




}
