package co.il.evy.framework.drivers;

import co.il.evy.framework.config.ConfigReader;
import co.il.evy.framework.enums.ModeType;
import co.il.evy.framework.factory.DriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Optional;


public final class Driver {
    private Driver(){}

    public static void init() {
        Optional.ofNullable(DriverThreadLocal.get())
                .orElseGet(() -> {
                    WebDriver driver= DriverFactory.createDriver(ConfigReader.get().browser());
                    DriverThreadLocal.set(driver);
                    configureDriver(DriverThreadLocal.get());
                    return DriverThreadLocal.get();
                });
    }
    public static void quit() {
        Optional.ofNullable(DriverThreadLocal.get())
                .ifPresent(driver -> {
                    driver.quit();
                    DriverThreadLocal.remove();
                });
    }
    private static void configureDriver(WebDriver driver) {
        ModeType modeType=ConfigReader.get().modeType();
        System.out.println(modeType);
        if (modeType != ModeType.MOBILE) {
            driver.manage().window().maximize();
        } else {
            setMobileWindowSize(driver);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.get().ImplicitTime()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.get().pageLoadTime()));
        driver.get(ConfigReader.get().url());
    }
    private static void setMobileWindowSize(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(320, 658));
    }

    public static void main(String[] args) {
        System.out.println(ConfigReader.get().modeType());
    }
}

