package fwk.search.model;

import java.io.Serializable;

/**
 * @author Krunal Lukhi
 * @since 10/08/23
 */
public class PageInfo implements Serializable {
    private int page = 0;

    private int size = 20;

    private Range<String> range;

    public PageInfo() {
    }

    public PageInfo(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Range<String> getRange() {
        return range;
    }

    public void setRange(Range<String> range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", size=" + size +
                ", range=" + range +
                '}';
    }
}
