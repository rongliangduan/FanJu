package com.yuncheng.china.Fanju.common.config;


public enum FileType{
    JPEG("jpeg"),
    PNG("png");
    public String suffix;

    FileType(String suffix)
    {
        this.suffix = "." + suffix;
    }

    public String getSuffix()
    {
        return suffix;
    }
}
