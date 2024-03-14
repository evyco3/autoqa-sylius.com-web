package co.il.evy.framework.utils;

import co.il.evy.framework.logger.MyLogger;
import io.qameta.allure.Allure;


public class ExecutionUtils {

    public static <T> T executeWithHandling(ExecutableCode<T> code, String elementName) {
        try {
            T result = code.execute();
            logSuccess(elementName);
            return result;
        } catch (Exception e) {
            handleException(e, elementName);
            return null;
        }
    }

    private static void handleException(Exception e, String elementName) {
        AllureAttachmentUtils.attachScreenshot(elementName);
        MyLogger.logErrorWithThreadName("Operation failed for " + elementName, e);
        AllureAttachmentUtils.logAttachmentErrorStep(e);
    }

    private static void logSuccess(String elementName) {
        MyLogger.logInfoWithThreadName("Operation succeeded for " + elementName);
        Allure.step("Operation succeeded for " + elementName);
    }




    @FunctionalInterface
    public interface ExecutableCode<T> {
        T execute() throws Exception;
    }
}
