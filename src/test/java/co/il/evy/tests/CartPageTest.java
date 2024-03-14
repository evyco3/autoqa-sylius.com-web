package co.il.evy.tests;


import co.il.evy.framework.enums.SectionType;
import co.il.evy.framework.enums.TopMenuType;
import co.il.evy.framework.pages.BasePage;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.account.LoginPage;
import co.il.evy.framework.pages.fronend.product.CartPage;
import co.il.evy.framework.pages.fronend.product.ProductPage;
import co.il.evy.framework.pages.fronend.product.SectionPage;
import org.testng.annotations.Test;

import java.util.Random;

import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class CartPageTest extends BaseTest {

    @Test
    public void clearCartTest() {
        assertThat(getCartPage().clearCartBtnAndGetResponseMessage()).isConditionMet("Cart Message", "Your cart is empty");
    }

    @Test
    public void cart_persist_after_navigation_to_external_site()  {
        boolean isPersist = getCartPage().openURL("https://www.google.co.il/?hl=iw", BasePage.class)
                .getPageObject().navigateBack(CartPage.class).getPageObject().cartImgDisplay();
        assertThat(isPersist).isConditionMet("Excepted Result", Boolean.TRUE);


    }


    @Test
    public void cart_persist_after_login() {
        boolean isPersist = getCartPage().clickLogo()
                .getTopMenu()
                .set(TopMenuType.LOGIN.getPageName(), LoginPage.class).getPageObject()
                .performLogin("shop@example.com", "sylius", CartPage.class).getPageObject().cartImgDisplay();
        assertThat(isPersist).isConditionMet("Excepted Result", Boolean.TRUE);

    }

    private CartPage getCartPage() {
        return new HomePage()
                .getCategoriesMenu()
                .set(SectionType.TSHIRT.getPageName(), SectionType.MEN.getPageName(), SectionPage.class).getPageObject()
                .clickProduct(String.valueOf(new Random().nextInt(3) + 1), ProductPage.class).getPageObject()
                .fillProductInfo("M", "1", CartPage.class).getPageObject();
    }
}
