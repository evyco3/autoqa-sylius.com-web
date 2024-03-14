package co.il.evy.framework.config;


import co.il.evy.framework.converters.StringToBrowserTypeConverter;
import co.il.evy.framework.converters.StringToModeTypeConverter;
import co.il.evy.framework.enums.BrowserType;
import co.il.evy.framework.enums.ModeType;
import org.aeonbits.owner.Config;


@Config.Sources("file:${user.dir}/src/main/resources/config/config.properties")
public interface ApplicationConfig extends Config {

    @Config.Key("implicitTime")
    int ImplicitTime();

    @Config.Key("pageLoadTime")
    int pageLoadTime();

    @Config.Key("url")
    String url();

    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @DefaultValue("DESKTOP")
    @ConverterClass(StringToModeTypeConverter.class)
    ModeType modeType();

    @Config.Key("email")
    String email();
    @Config.Key("password")
    String password();



}
