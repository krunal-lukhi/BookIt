package fwk.common;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class StringUtils {

    public static boolean isBlank(String s) {
        return org.springframework.util.StringUtils.hasLength(s);
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }
}
