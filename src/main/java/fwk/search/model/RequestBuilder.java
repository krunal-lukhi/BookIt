package fwk.search.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TedaMeda
 * @since 8/11/2023
 */
public class RequestBuilder {
    private final Request request;
    RequestBuilder(){
        this.request=new Request();
    }
    public static RequestBuilder newRequestBuilder(){
        return new RequestBuilder();
    }

    public RequestBuilder setIncludeFields(List<String> fields){
        this.request.setIncludeFields(fields);
        return this;
    }

    public RequestBuilder setExcludeFields(List<String> fields){
        this.request.setExcludeFields(fields);
        return this;
    }

    public Request request(){
        return request;
    }
}
