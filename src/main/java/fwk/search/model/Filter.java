package fwk.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 08/08/23
 */
public class Filter implements Serializable, Cloneable {

    private String field;
    private FilterType filterType;
    private List<Object> values;
    private List<Filter> filters;


    public String getField() {
        return field;
    }

    public Filter setField(String field) {
        Filter filter1 = new Filter();
        Filter filter2 = new Filter();
        this.field = field;
        return this;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public Filter setFilterType(FilterType filterType) {
        this.filterType = filterType;
        return this;
    }

    public List<Object> getValues() {
        return values;
    }

    public Filter setValues(List<Object> values) {
        this.values = values;
        return this;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void addValue(Object value) {
        if (this.values == null) {
            values = new ArrayList<>();
        }
        values.add(value);
    }

    public void addFilter(Filter filter) {
        if (this.filters == null) {
            filters = new ArrayList<>();
        }
        filters.add(filter);
    }

}
