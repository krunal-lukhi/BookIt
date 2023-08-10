package fwk.search.model;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class SortInfo {
    private String field;

    private Order order;

    public SortInfo(String field, Order order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public enum Order{
        ASC, DESC
    }
}
