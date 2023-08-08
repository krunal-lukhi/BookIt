package fwk.search.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Krunal Lukhi
 * @since 05/08/23
 */
public class Request implements Serializable {
    private String key;
    private String keyword;
    private List<Filter> filters;



}
