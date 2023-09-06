package com.shu.starter.json;

import com.alibaba.fastjson2.JSON;

public class Converter {
    private String prefixName;
    private String suffixName;

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public String convert(Object o) {
        return prefixName + JSON.toJSONString(o) + suffixName;
    }
}
