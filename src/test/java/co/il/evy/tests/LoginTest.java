package co.il.evy.tests;

import co.il.evy.framework.data.ExcelDataProvider;
import co.il.evy.framework.enums.TopMenuType;

import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.account.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class LoginTest extends BaseTest {

    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "loginData")
    @Parameters({"email", "password", "expectedResult"})
    public void login_with_different_data(String email, String password, String expectedMessage) {
        assertThat(loginToSite(email, password,expectedMessage)).isSubstringContained("Login Message", expectedMessage);
    }

    private String loginToSite(String email, String password,String expectedResult) {
        return new HomePage()
                .getTopMenu()
                .set(TopMenuType.LOGIN.getPageName(), LoginPage.class).getPageObject()
                .performLogin(email, password, LoginPage.class).getPageObject().getMessage(expectedResult);
    }
}
