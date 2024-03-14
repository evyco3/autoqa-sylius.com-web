package co.il.evy.framework.pages.fronend.product;


import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewToProductPage extends BasePage {
    @FindBy(css = "div[data-rating]")
    private WebElement rating;
    @FindBy(css = "#sylius_product_review_title")
    private WebElement title;
    @FindBy(css = "#sylius_product_review_comment")
    private WebElement reviewTextarea;
    @FindBy(css = "#sylius_product_review_author_email")
    private WebElement email;
    @FindBy(css = ".submit.button")
    private WebElement submit;
    @FindBy(css = ".sylius-validation-error")
    private WebElement failedResponseMessage;
    @FindBy(css = ".positive.message")
    private WebElement positiveResponseMessage;

    public AddReviewToProductPage() {
        super();
    }



    public <T> PageObjectFactory<T> fillReview(String rating, String title, String ownReview, String email, Class <T> nextPageClass) {
        double ratingValue = Double.parseDouble(rating);
        int ratingAsInt = (int) ratingValue;
        WebElement iconToClick = this.rating.findElements(By.cssSelector("i.icon")).get(ratingAsInt - 1);
        click(iconToClick, "rating");
        sendKeys(this.title, title, "title");
        sendKeys(this.reviewTextarea, ownReview, "review textarea");
        sendKeys(this.email,email,"email");
        click(this.submit, "add review button");
        return PageObjectFactory.createPage(nextPageClass);
    }
    public String getMessage(String expectedMessage) {
        if (expectedMessage.toLowerCase().contains("success")) {
            return getSuccessMessage();
        } else {
            return getErrorMessage();
        }
    }



    public String getSuccessMessage() {
        return getText(this.positiveResponseMessage,"success");
    }
    public String getErrorMessage(){
        return getText(this.failedResponseMessage,"failed");
    }


}
