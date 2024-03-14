package co.il.evy.framework.pages.fronend.product;


import co.il.evy.framework.drivers.DriverThreadLocal;
import co.il.evy.framework.factory.PageObjectFactory;
import co.il.evy.framework.pages.BasePage;
import org.openqa.selenium.By;

public class CategoriesMenu extends BasePage {

    public CategoriesMenu(){
        super();
    }

    public <T> PageObjectFactory<T> set(String item1, String item2, Class<T> nextPageClass) {
        if (item1.equalsIgnoreCase("dresses")) {
            click(DriverThreadLocal.get().findElement(By.xpath("//a[text()='Dresses']")), "Dresses");
        } else {
            String val1 = String.format("//div[@class='ui dropdown item']//span[text()='%s']", item1);
            click(DriverThreadLocal.get().findElement(By.xpath(val1)), item1);
            String val2 = String.format("//div[@class='ui dropdown item active visible']//*[text()='%s']", item2);
            click(DriverThreadLocal.get().findElement(By.xpath(val2)), item2);
        }
        return PageObjectFactory.createPage(nextPageClass);
    }
}
