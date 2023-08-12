package fwk.search.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 11/08/23
 */
public class Response<T> implements Serializable {
    private String key;

    private List<T> result;

    private T resultObject;

    private Long count;

    private PageInfo pageInfo;

    private PageInfo nextPageInfo;

    public Response(String key, List<T> result, Long count, PageInfo pageInfo) {
        this.key = key;
        this.result = result;
        this.count = count;
        this.pageInfo = pageInfo;
    }

    public Response(String key, T resultObject, Long count, PageInfo pageInfo) {
        this.key = key;
        this.resultObject = resultObject;
        this.count = count;
        this.pageInfo = pageInfo;
    }

    public Response(String key, List<T> result) {
        this.key = key;
        this.result = result;
        if (result != null) {
            this.count = (long) result.size();
        } else {
            this.count = 0L;
        }
    }

    public Response(String key, T resultObject) {
        this.key = key;
        this.resultObject = resultObject;
    }

    public Response() {
        this.count = 0L;
    }

    public static <T> Response<T> empty(String key, PageInfo pageInfo) {
        Response<T> response = new Response<>();
        response.setResult(Collections.emptyList());
        response.setCount(0L);
        response.setKey(key);
        response.setPageInfo(pageInfo);
        return response;
    }

    public static <T> Response<T> empty() {
        Response<T> response = new Response<>();
        response.setResult(Collections.emptyList());
        response.setCount(0L);
        return response;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public T getResultObject() {
        return resultObject;
    }

    public void setResultObject(T resultObject) {
        this.resultObject = resultObject;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public PageInfo getNextPageInfo() {
        return nextPageInfo;
    }

    public void setNextPageInfo(PageInfo nextPageInfo) {
        this.nextPageInfo = nextPageInfo;
    }
}
