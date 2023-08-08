package fwk.search.model;

/**
 * @author Krunal Lukhi
 * @since 08/08/23
 */
public enum FilterType {
    IN("equals to any"),
    OR("Or condition"),
    NIN("not equals to any"),
    LT("less than"),
    GT("greater than"),
    LTE("less than or equal to"),
    ;
    FilterType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
