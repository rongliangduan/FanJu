package com.yuncheng.china.Fanju.common.config;

public enum ImgQuality {
    HIGH(""),
    MIDDLE("160"),
    LOW("80");

    private final String size;

    ImgQuality(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
