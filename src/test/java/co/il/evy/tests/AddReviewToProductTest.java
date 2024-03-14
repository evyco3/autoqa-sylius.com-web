package co.il.evy.tests;

import co.il.evy.framework.data.ExcelDataProvider;
import co.il.evy.framework.enums.SectionType;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.product.AddReviewToProductPage;
import co.il.evy.framework.pages.fronend.product.ProductPage;
import co.il.evy.framework.pages.fronend.product.SectionPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class AddReviewToProductTest extends BaseTest {

    @Test(dataProvider = "addReviewToProductData",dataProviderClass = ExcelDataProvider.class)
    @Parameters({"rating", "title","ownReview","email","expectedResult"})
    public void textAddReviewToProductWithDifferentData(String stars,String title,String ownReview,String email,String expectedResult) {
        String message=add_review_to_product_and_getMessage(stars,title,ownReview,email,expectedResult);
        assertThat(message).isSubstringContained("Expected Result",expectedResult);
    }

    private String add_review_to_product_and_getMessage( String stars,String title,String ownReview,String email,String expectedResult){
      return   new HomePage()
                .getCategoriesMenu()
                .set(SectionType.TSHIRT.getPageName(), SectionType.MEN.getPageName(), SectionPage.class).getPageObject()
                .clickProduct("1", ProductPage.class).getPageObject()
                .AddReview(AddReviewToProductPage.class).getPageObject()
                .fillReview(stars,title,ownReview,email,AddReviewToProductPage.class).getPageObject()
                .getMessage(expectedResult);
    }

}



