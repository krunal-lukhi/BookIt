package fwk.search.model;

import fwk.common.CollectionUtils;
import fwk.common.StringUtils;

/**
 * @author Krunal Lukhi
 * @since 08/08/23
 */
public enum FilterType {
    IN("equals to any") {
        @Override
        boolean isValidFilter(Filter filter) {
            return true;
        }
    },
    BETWEEN("between values") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getValues()) && filter.getFilters().size() == 2;
        }
    },

    OR("Or condition") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getValues());
        }

    },

    AND("and condition") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getValues());
        }
    },

    NIN("not equals to any") {
        @Override
        boolean isValidFilter(Filter filter) {
            return true;
        }
    },

    LT("less than") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getFilters()) || filter.getFilters().size() == 1;
        }
    },

    GT("greater than") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getFilters()) || filter.getFilters().size() == 1;
        }
    },

    LTE("less than or equal to") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getFilters()) && filter.getFilters().size() == 1;
        }
    },

    GTE("greater than or equal to") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getFilters()) && filter.getFilters().size() == 1;
        }
    },

    IS("equal to") {
        @Override
        boolean isValidFilter(Filter filter) {
            return CollectionUtils.isNotEmpty(filter.getFilters()) && filter.getFilters().size() == 1;
        }
    },

    NOT("not equal to") {
        @Override
        boolean isValidFilter(Filter filter) {
            return StringUtils.isBlank(filter.getField()) && CollectionUtils.isNotEmpty(filter.getValues());
        }
    },

    EXISTS("exits") {
        @Override
        boolean isValidFilter(Filter filter) {
            return StringUtils.isNotBlank(filter.getField());
        }
    },

    DOES_NOT_EXITS("does not exists") {
        @Override
        boolean isValidFilter(Filter filter) {
            return StringUtils.isNotBlank(filter.getField());
        }
    },
    ;
    private String description;

    FilterType(String description) {
        this.description = description;
    }

    abstract boolean isValidFilter(Filter filter);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
