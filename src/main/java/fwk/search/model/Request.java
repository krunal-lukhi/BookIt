package fwk.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 05/08/23
 */
public class Request implements Serializable, Cloneable {
    private String key;
    private String keyword;
    private List<Filter> filters;

    private PageInfo pageInfo;

    private SortInfo sortInfo;

    private List<String> includeFields;

    private List<String> excludeFields;

    public String getKey() {
        return key;
    }

    public Request setKey(String key) {
        this.key = key;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public Request setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public Request setFilters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public Request setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public SortInfo getSortInfo() {
        return sortInfo;
    }

    public Request setSortInfo(SortInfo sortInfo) {
        this.sortInfo = sortInfo;
        return this;
    }

    public List<String> getIncludeFields() {
        return includeFields;
    }

    public Request setIncludeFields(List<String> includeFields) {
        this.includeFields = includeFields;
        return this;
    }

    public List<String> getExcludeFields() {
        return excludeFields;
    }

    public Request setExcludeFields(List<String> excludeFields) {
        this.excludeFields = excludeFields;
        return this;
    }

    public Request addFilter(Filter filter) {
        if (this.filters == null) {
            filters = new ArrayList<>();
        }
        this.filters.add(filter);
        return this;
    }
}
