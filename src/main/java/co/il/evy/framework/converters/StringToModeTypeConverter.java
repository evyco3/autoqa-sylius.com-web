package co.il.evy.framework.converters;

import co.il.evy.framework.enums.ModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToModeTypeConverter implements Converter<ModeType> {
    @Override
    public ModeType convert(Method method, String modeType) {
        Map<String, ModeType> stringModeTypeMap = Map.of(
                "DESKTOP", ModeType.DESKTOP,
                "MOBILE", ModeType.MOBILE
        );
        return stringModeTypeMap
                .getOrDefault(modeType.toUpperCase(), ModeType.DESKTOP);
    }


}