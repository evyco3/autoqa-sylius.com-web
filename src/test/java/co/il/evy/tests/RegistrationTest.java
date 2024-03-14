package co.il.evy.tests;

import co.il.evy.framework.data.ExcelDataProvider;
import co.il.evy.framework.enums.TopMenuType;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.account.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class RegistrationTest extends BaseTest {


    @Test(dataProvider = "registrationData", dataProviderClass = ExcelDataProvider.class)
    @Parameters({"firstName", "lastName", "email", "phone", "password", "confirmPassword", "expectedResult"})
    public void registration_with_different_data(String firstName, String lastName, String email,
                                                 String phone, String password, String confirmPassword, String expectedMessage) {

        email = email.equalsIgnoreCase("myMail@gmail.com") ? new Faker().internet().emailAddress() : email;
        assertThat(registerToSite(firstName, lastName, email, phone,
                password, confirmPassword, expectedMessage)).isSubstringContained("Registration Message", expectedMessage);

    }


    private String registerToSite(String firstName, String lastName, String email, String phone,
                                  String password, String confirmPassword, String expectedMessage) {
        return new HomePage()
                .getTopMenu()
                .set(TopMenuType.REGISTER.getPageName(), RegisterPage.class).getPageObject()
                .performRegistration(firstName, lastName, email, phone, password, confirmPassword, RegisterPage.class).getPageObject()
                .getResponseMessage(expectedMessage);

    }
}
