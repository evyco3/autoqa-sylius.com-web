package co.il.evy.framework.config;


import org.aeonbits.owner.ConfigFactory;

public final class ConfigReader {

    private ConfigReader(){}

    public static ApplicationConfig get(){
        return ConfigFactory.create(ApplicationConfig.class);
    }
}
