package fwk.search;

import fwk.search.model.Request;
import fwk.search.model.Response;

/**
 * @author Krunal Lukhi
 * @since 05/08/23
 */
public interface SearchService<T> {
    Response<T> search(Request request);

    Long searchCount(Request request);
}
