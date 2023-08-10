package fwk.search.model;

import java.io.Serializable;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class Range<T extends Comparable<T>> implements Serializable {
    private T from;
    private T to;

    public Range() {

    }

    public Range(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public T getTo() {
        return to;
    }

    public void setTo(T to) {
        this.to = to;
    }

    public T getFrom() {
        return from;
    }

    public void setFrom(T from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
