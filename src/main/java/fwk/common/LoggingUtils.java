package fwk.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public final class LoggingUtils {
    private static final Logger LOGGER = getLogger("CommonLogger");

    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    private static Logger getLogger(String logUtility) {
        return LoggerFactory.getLogger(logUtility);
    }

    public static Logger getCommnaLogger() {
        return LOGGER;
    }
}
