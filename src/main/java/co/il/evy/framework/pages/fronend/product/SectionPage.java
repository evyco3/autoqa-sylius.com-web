package co.il.evy.framework.pages.fronend.product;

import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SectionPage extends BasePage {

    public SectionPage(){
        super();
    }

    public <T> PageObjectFactory<T> clickProduct(String value, Class<T> nextPageClass) {
        String val = String.format("#products>div:nth-of-type("+value+")>a", value);
        WebElement element= DriverThreadLocal.get().findElement(By.cssSelector(val));
        click(element,DriverThreadLocal.get().findElement(By.cssSelector(val+" +.content a")).getText());
        return PageObjectFactory.createPage(nextPageClass);
    }


}
