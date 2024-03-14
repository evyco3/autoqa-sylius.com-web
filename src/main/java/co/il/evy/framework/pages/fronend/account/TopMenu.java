package co.il.evy.framework.pages.fronend.account;


import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;

public class TopMenu extends BasePage {

    public TopMenu(){}

    public <T> PageObjectFactory<T> set(String value, Class<T> nextPageClass) {
        String val = String.format("//div[@class='top-bar']//a[text()='%s']", value);
        click(DriverThreadLocal.get().findElement(By.xpath(val)), value);
        return PageObjectFactory.createPage(nextPageClass);
    }
}
