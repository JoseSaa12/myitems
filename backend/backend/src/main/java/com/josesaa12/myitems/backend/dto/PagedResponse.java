package com.josesaa12.myitems.backend.dto;

import java.util.List;
import java.util.Map;

public class PagedResponse<T> {
    private List<T> data;
    private Map<String, Object> meta;

    public PagedResponse(List<T> data, int page, int pageSize, long total) {
        this.data = data;
        this.meta = Map.of("page", page, "pageSize", pageSize, "total", total);
    }

    public List<T> getData() { return data; }
    public Map<String, Object> getMeta() { return meta; }
}
