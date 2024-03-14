package co.il.evy.framework.utils;


import io.qameta.allure.Allure;
import org.assertj.core.api.AbstractAssert;

public class CustomAssertionsUtils<T> extends AbstractAssert<CustomAssertionsUtils<T>, T> {

    protected CustomAssertionsUtils(T actual, Class<?> selfType) {
        super(actual, selfType);
    }



    public static <T> CustomAssertionsUtils<T> assertThat(T actual) {
        return new CustomAssertionsUtils<>(actual, CustomAssertionsUtils.class);
    }

    public void isConditionMet(String conditionDescription, T expectedCondition) {
        try {
            if (!actual.equals(expectedCondition)) {
                failWithMessage("Expected %s to be %s, but it was %s.", conditionDescription, expectedCondition, actual);
            } else {
                Allure.step(String.format("Condition met: %s is %s", conditionDescription, expectedCondition));
            }
        } catch (AssertionError e) {
            AllureAttachmentUtils.attachScreenshot("Failed");

        }
    }
    public CustomAssertionsUtils<T> isSubstringContained(String conditionDescription, String expectedSubstring) {
        try {
            String actualString = ((String) actual).toLowerCase();  // Convert to lowercase
            String expectedSubstr = expectedSubstring.toLowerCase(); // Convert to lowercase

            if (!actualString.contains(expectedSubstr)) {
                failWithMessage("Expected %s to contain %s, but it did not.", conditionDescription, expectedSubstring);
            } else {
                Allure.step(String.format("Condition met: %s contains %s", conditionDescription, expectedSubstring.toLowerCase()));
            }
        } catch (AssertionError e) {
            AllureAttachmentUtils.attachScreenshot("Failed");
            throw e;
        }
        return this;
    }
    public CustomAssertionsUtils<T> isEqualToCondition(T expectedValue, String conditionDescription, boolean additionalCondition) {
        try {
            if (!actual.equals(expectedValue) || additionalCondition) {
                failWithMessage("Expected %s to be %s, but it was %s.", conditionDescription, expectedValue, actual);
                AllureAttachmentUtils.attachScreenshot("Failed");
            } else {
                Allure.step(String.format("Condition met: %s is %s", conditionDescription, expectedValue));
            }
        } catch (AssertionError e) {
            AllureAttachmentUtils.attachScreenshot("Failed");
            throw e;
        }
        return this; // Return the instance to allow further chaining
    }

}