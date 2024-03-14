package co.il.evy.framework.drivers.manager;

import co.il.evy.framework.drivers.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public final class EdgeDriverManager implements IDriver {

    public EdgeDriverManager() {}

    @Override
    public WebDriver getDriver() {
        return WebDriverManager.edgedriver().create();
    }
}
