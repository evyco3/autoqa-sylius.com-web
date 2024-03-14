package co.il.evy.tests;


import co.il.evy.framework.data.ExcelDataProvider;
import co.il.evy.framework.pages.fronend.HomePage;
import co.il.evy.framework.pages.fronend.product.SectionPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static co.il.evy.framework.utils.CustomAssertionsUtils.assertThat;

public class CategoriesNavigationTest extends BaseTest {

    @Test(dataProvider = "dropdownData" ,dataProviderClass = ExcelDataProvider.class )
    @Parameters({"main_category","sub_category","expectedResult"})
    public void cart_categories_navigation(String val1, String val2, String expectedResult){
        assertThat(navigate_sector_categories_and_get_url(val1,val2)).isSubstringContained("Url Result:",expectedResult);
    }

    public String navigate_sector_categories_and_get_url(String val1, String val2){
        return  new HomePage()
                .getCategoriesMenu()
                .set(val1,val2, SectionPage.class).getPageObject()
                .getCurrentUrl();
    }
}

