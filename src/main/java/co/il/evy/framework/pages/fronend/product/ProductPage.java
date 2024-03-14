package co.il.evy.framework.pages.fronend.product;

import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = "form[method] select")
    private WebElement size;
    @FindBy(css = "#sylius_add_to_cart_cartItem_quantity")
    private WebElement quantity;
    @FindBy(css = ".ui.huge.button")
    private WebElement submit;
    @FindBy(css = "a[data-tab='reviews']")
    private WebElement reviewsTab;
    @FindBy(css = "i.icon.plus")
    private WebElement addReviewBtn;
    @FindBy(css = ".positive.message p")
    private WebElement successMessage;


    public ProductPage(){
       super();
    }

    public <T> PageObjectFactory<T> fillProductInfo(String size, String quantity, Class<T>nextPageClass){
        selectByVisibleText(this.size,size,"size");
        sendKeys(this.quantity,quantity,"quantity");
        click(this.submit,"Add to cart button");
        waitForTitleToContain("cart");
        return PageObjectFactory.createPage(nextPageClass);
    }
    public <T> PageObjectFactory <T> AddReview(Class <T> nextPageClass){
        click(this.reviewsTab,"reviewsTab");
        click(this.addReviewBtn,"add review button");
        return PageObjectFactory.createPage(nextPageClass);
    }
    public boolean IsSuccessMessageDisplayed(){
        return isDisplayed(this.successMessage,"Add to cart success message");
    }



}
