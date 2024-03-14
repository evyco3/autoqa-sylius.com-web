package co.il.evy.framework.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverThreadLocal {
    private final static ThreadLocal<WebDriver>DRIVER_THREAD_LOCAL=new ThreadLocal<>();
    private DriverThreadLocal(){}

    public static void set(WebDriver driver){
        DRIVER_THREAD_LOCAL.set(driver);
    }
    public static WebDriver get(){
        return DRIVER_THREAD_LOCAL.get();
    }
    public static void remove(){
        DRIVER_THREAD_LOCAL.remove();
    }
}
