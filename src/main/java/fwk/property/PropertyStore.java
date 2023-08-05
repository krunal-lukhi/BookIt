package fwk.property;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public interface PropertyStore {

    String fetchProperty(String key);

    String fetchProperty(String key, String defaultValue);
}
