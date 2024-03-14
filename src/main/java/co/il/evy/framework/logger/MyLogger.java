package co.il.evy.framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public class MyLogger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    private MyLogger() {
    }

    public static void logInfoWithThreadName(String message) {
        logInfoWithThreadName(null, message);
    }

    public static void logInfoWithThreadName(String threadName, String message) {
        MDC.put("threadName", threadName != null ? threadName : Thread.currentThread().getName());
        Logger logger = LoggerFactory.getLogger(MyLogger.class);
        logger.info(ANSI_GREEN + message + ANSI_RESET);
        MDC.remove("threadName");
    }

    public static void logErrorWithThreadName(String message, Throwable throwable) {
        logErrorWithThreadName(null, message, throwable);
    }

    public static void logErrorWithThreadName(String threadName, String message, Throwable throwable) {
        MDC.put("threadName", threadName != null ? threadName : Thread.currentThread().getName());
        Logger logger = LoggerFactory.getLogger(MyLogger.class);
        logger.error(ANSI_RED + message + ANSI_RESET, throwable);
        MDC.remove("threadName");
    }
}
