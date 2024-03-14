package co.il.evy.framework.drivers.manager;

import co.il.evy.framework.drivers.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public final class FirefoxDriverManager implements IDriver {
    public FirefoxDriverManager() {}

    @Override
    public WebDriver getDriver() {
        return WebDriverManager.firefoxdriver().create();
    }
}
