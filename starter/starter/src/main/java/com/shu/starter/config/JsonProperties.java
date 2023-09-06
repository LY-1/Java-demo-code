package com.shu.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "json.name")
public class JsonProperties {
    public static final String DEFAULT_PREFIX_NAME = "@";

    public static final String DEFAULT_SUFFIX_NAME = "@";

    private String prefixName = DEFAULT_PREFIX_NAME;

    private String suffixName = DEFAULT_SUFFIX_NAME;

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
}
