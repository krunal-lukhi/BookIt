package fwk.search.model;

import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 08/08/23
 */
public enum FilterType {
    IN("equals to any") {
        @Override
        boolean isValidFilter(List<Object> values) {
            return true;
        }
    },
    OR("Or condition"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return values.size() <= 1;
        }

    },
    NIN("not equals to any"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return true;
        }
    },
    LT("less than"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return values.size()<=1;
        }
    },
    GT("greater than"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return values.size()<=1;
        }
    },
    LTE("less than or equal to"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return values.size()<=1;
        }
    },
    EQ("equal to"){
        @Override
        boolean isValidFilter(List<Object> values) {
            return values.size()==1;
        }
    }
    ;
    abstract boolean isValidFilter(List<Object> values);
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
