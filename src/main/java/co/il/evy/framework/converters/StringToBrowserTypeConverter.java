package co.il.evy.framework.converters;



import co.il.evy.framework.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        Map<String, BrowserType> stringBrowserTypeMap = Map.
                of("CHROME", BrowserType.CHROME,
                        "FIREFOX", BrowserType.FIREFOX,
                        "EDGE", BrowserType.EDGE);
        return stringBrowserTypeMap
                .getOrDefault(browserName.toUpperCase(), BrowserType.CHROME);
    }
}