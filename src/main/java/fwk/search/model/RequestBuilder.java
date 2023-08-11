package fwk.search.model;

import fwk.common.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 11/08/23
 */
public class RequestBuilder implements Serializable {
    private final Request request;

    public RequestBuilder() {
        this.request = new Request();
    }

    public RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public RequestBuilder addFilter(Filter filter) {
        this.request.addFilter(filter);
        return this;
    }

    public RequestBuilder addFilters(Filter... filter) {
        List<Filter> filters = this.request.getFilters();
        if (CollectionUtils.isEmpty(filters)) {
            filters = new ArrayList<>();
            this.request.setFilters(filters);
        }
        filters.addAll(CollectionUtils.toList(filter));
        return this;
    }

    public RequestBuilder pageInfo(PageInfo pageInfo) {
        this.request.setPageInfo(pageInfo);
        return this;
    }

    public RequestBuilder sortInfo(SortInfo sortInfo) {
        this.request.setSortInfo(sortInfo);
        return this;
    }

    public RequestBuilder keyword(String keyword) {
        this.request.setKeyword(keyword);
        return this;
    }

    public RequestBuilder key(String key) {
        this.request.setKey(key);
        return this;
    }

    public RequestBuilder includeFields(List<String> includeFields) {
        this.request.setIncludeFields(includeFields);
        return this;
    }

    public RequestBuilder includeFields(String... includeField) {
        List<String> includeFields = this.request.getIncludeFields();
        if (CollectionUtils.isEmpty(includeFields)) {
            includeFields = new ArrayList<>();
            this.request.setIncludeFields(includeFields);
        }
        includeFields.addAll(CollectionUtils.toList(includeField));
        return this;
    }

    public RequestBuilder excludeFields(List<String> excludeFields) {
        this.request.setIncludeFields(excludeFields);
        return this;
    }

    public RequestBuilder excludeFields(String... excludeField) {
        List<String> excludeFields = this.request.getExcludeFields();
        if (CollectionUtils.isEmpty(excludeFields)) {
            excludeFields = new ArrayList<>();
            this.request.setExcludeFields(excludeFields);
        }
        excludeFields.addAll(CollectionUtils.toList(excludeField));
        return this;
    }

    public Request request() {
        return this.request;
    }

}
