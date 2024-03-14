package co.il.evy.framework.factory;

import co.il.evy.framework.drivers.manager.ChromeDriverManager;
import co.il.evy.framework.drivers.manager.EdgeDriverManager;
import co.il.evy.framework.drivers.manager.FirefoxDriverManager;
import co.il.evy.framework.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.function.Supplier;

public final class DriverFactory {
    private final static EnumMap<BrowserType, Supplier<WebDriver>> BROWSER_MAP = new EnumMap<>(BrowserType.class);

    private DriverFactory() {
    }

    static {
        BROWSER_MAP.put(BrowserType.CHROME, new ChromeDriverManager()::getDriver);
        BROWSER_MAP.put(BrowserType.FIREFOX, new FirefoxDriverManager()::getDriver);
        BROWSER_MAP.put(BrowserType.EDGE, new EdgeDriverManager()::getDriver);
    }

    public static WebDriver createDriver(BrowserType browserType) {
        Supplier<WebDriver> supplier = BROWSER_MAP.get(browserType);
        if (supplier != null) {
            return supplier.get();
        } else {
            throw new IllegalArgumentException(browserType.name() + " is not set properly");
        }
    }


}