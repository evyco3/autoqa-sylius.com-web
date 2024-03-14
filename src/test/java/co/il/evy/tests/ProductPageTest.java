package co.il.evy.tests;

import co.il.evy.framework.data.ExcelDataProvider;
import co.il.evy.framework.enums.SectionType;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.product.CartPage;
import co.il.evy.framework.pages.fronend.product.ProductPage;
import co.il.evy.framework.pages.fronend.product.SectionPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class ProductPageTest extends BaseTest {

    @Test(dataProvider = "productSizeData", dataProviderClass = ExcelDataProvider.class)
    @Parameters({"size", "quantity", "expectedResult"})
    public void verify_order_product_size(String size, String quantity, String expectedResult) {
        String stringValue = String.valueOf((int) Double.parseDouble(quantity));
        String msg = verifyProductOrder(size, stringValue).moveToPage(CartPage.class).getPageObject()
                .getProductSize();
        assertThat(msg).isConditionMet("Size ",expectedResult);

    }


    @Test(dataProvider = "productQuantity", dataProviderClass = ExcelDataProvider.class)
    @Parameters({"size", "quantity", "expectedResult"})
    public void verify_product_order_quantity(String size, String quantity, String expectedResult) {
        int intValue = (int) Double.parseDouble(quantity);
        String stringValue = String.valueOf(intValue);
        boolean isSuccessMessageDisplayed = verifyProductOrder(size, stringValue).IsSuccessMessageDisplayed();
        boolean expectedSuccessResult = Boolean.parseBoolean(expectedResult);
        assertThat(isSuccessMessageDisplayed)
                .isEqualToCondition(expectedSuccessResult, "success message to be displayed", intValue <= 0);

    }

    public ProductPage verifyProductOrder(String size, String quantity) {
        return new HomePage()
                .getCategoriesMenu()
                .set(SectionType.TSHIRT.getPageName(), SectionType.MEN.getPageName(), SectionPage.class).getPageObject()
                .clickProduct(String.valueOf(new Random().nextInt(3) + 1), ProductPage.class).getPageObject()
                .fillProductInfo(size, quantity, ProductPage.class).getPageObject();

    }
}





