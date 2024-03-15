package co.il.evy.tests;


import co.il.evy.framework.enums.SectionType;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.checkout.CheckoutPage;
import co.il.evy.framework.pages.fronend.product.CartPage;
import co.il.evy.framework.pages.fronend.product.ProductPage;
import co.il.evy.framework.pages.fronend.product.SectionPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class EndToEndTest extends BaseTest {

    @Test
    public void E2E() {
        assertThat(performEndToEnd()).isSubstringContained("Complete Order message", "You have successfully placed an order.");
    }

    private String performEndToEnd() {
        Faker faker = new Faker();
        return new HomePage()
                .getCategoriesMenu()
                .set(SectionType.TSHIRT.getPageName(), SectionType.MEN.getPageName(), SectionPage.class).getPageObject()
                .clickProduct("1", ProductPage.class).getPageObject()
                .fillProductInfo("M", "2", CartPage.class).getPageObject()
                .clickCheckout(CheckoutPage.class).getPageObject()
                .setEmail(faker.internet().emailAddress())
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setCompany(faker.company().name())
                .setStreetAddress(faker.address().streetAddress())
                .setCountry("Canada")
                .setCity(faker.address().city())
                .setPostCode(faker.address().zipCode())
                .setPhone(faker.phoneNumber().cellPhone())
                .setShipment("ups")
                .setExtraNote(faker.lorem().sentence())
                .clickPlaceOrderButton()
                .clickPlaceOrderButton()
                .getServerResponseMessage();

    }
}
