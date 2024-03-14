package co.il.evy.framework.utils;

import co.il.evy.framework.drivers.DriverThreadLocal;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureAttachmentUtils {
    private AllureAttachmentUtils(){}

    @Step("Attach screenshot(0)")
    public static void attachScreenshot(String attachmentName) {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverThreadLocal.get()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(screenshot), "png");
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to capture and attach screenshot: " + e.getMessage(), e);
        }
    }

    @Step("Log Attachment Error: {0}")
    public static void logAttachmentErrorStep(Exception e) {
        Allure.step("Attachment Error: " + e.getMessage());
    }
}
