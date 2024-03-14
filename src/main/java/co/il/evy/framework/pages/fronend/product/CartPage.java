package co.il.evy.framework.pages.fronend.product;


import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    @FindBy(css = "#sylius-cart-clear")
    private WebElement clearCartBtn;
    @FindBy(css = ".info.message p")
    private WebElement infoMessage;
    @FindBy(css = "#sylius-go-to-cart")
    private WebElement cartWithItem;
    @FindBy(css = ".check.icon")
    private WebElement checkoutBtn;
    @FindBy(css = "table div.item")
    private WebElement productSize;

    public CartPage(){
      super();
    }
    public String clearCartBtnAndGetResponseMessage(){
        click(this.clearCartBtn,"clear cart button");
        return getText(infoMessage,"info message");
    }
    public boolean cartImgDisplay(){
        new WebDriverWait(DriverThreadLocal.get(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(DriverThreadLocal.get().findElement(By.cssSelector("#sylius-cart-button"))));
        click(DriverThreadLocal.get().findElement(By.cssSelector("#sylius-cart-button")),"Cart logo");
        return isDisplayed(cartWithItem,"Cart with Values");
    }
    public <T> PageObjectFactory<T> clickCheckout(Class<T>nextPageClass){
        click(this.checkoutBtn,"checkout button");
        return PageObjectFactory.createPage(nextPageClass);
    }
    public String getProductSize(){
        return getText(this.productSize,"product size");
    }





}
