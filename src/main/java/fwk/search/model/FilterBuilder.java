package fwk.search.model;

import fwk.common.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class FilterBuilder implements Serializable {
    private final Filter filter;

    FilterBuilder() {
        this.filter = new Filter();
    }

    public static FilterBuilder newBuilder() {
        return new FilterBuilder();

    }

    public static FilterBuilder and() {
        return FilterBuilder.newBuilder().filterType(FilterType.AND);
    }

    public static FilterBuilder or() {
        return FilterBuilder.newBuilder().filterType(FilterType.OR);
    }

    public FilterBuilder field(String field) {
        this.filter.setField(field);
        return this;
    }

    public FilterBuilder filterType(FilterType filterType) {
        this.filter.setFilterType(filterType);
        return this;
    }

    public FilterBuilder addValue(Object value) {
        this.filter.addValue(value);
        return this;
    }

    public FilterBuilder addValues(Object... value) {
        List<Object> values = this.filter.getValues();
        if (CollectionUtils.isEmpty(values)) {
            values = new ArrayList<>();
            this.filter.setValues(values);
        }
        values.addAll(CollectionUtils.toList(value));
        return this;
    }

    public FilterBuilder addFilter(Filter filter) {
        this.filter.addFilter(filter);
        return this;
    }

    public FilterBuilder addFilters(Filter... filter) {
        List<Filter> filters = this.filter.getFilters();
        if (CollectionUtils.isEmpty(filters)) {
            filters = new ArrayList<>();
            this.filter.setFilters(filters);
        }
        filters.addAll(CollectionUtils.toList(filter));
        return this;
    }

    public Filter filter() {
        return this.filter;
    }
}
