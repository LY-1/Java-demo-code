package com.shu.starter.config;

import com.shu.starter.json.Converter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 标识此类是配置类
@ConditionalOnClass(Converter.class) // 表示只有指定的class在classpath上时才能被注册
@EnableConfigurationProperties(JsonProperties.class) // 激活@ConfigurationProperties
public class JsonConfiguration {
    private JsonProperties jsonProperties;

    public JsonConfiguration(JsonProperties jsonProperties) {
        this.jsonProperties = jsonProperties;
    }

    @Bean
    @ConditionalOnMissingBean(Converter.class)
    public Converter converter() {
        Converter converter = new Converter();
        converter.setPrefixName(jsonProperties.getPrefixName());
        converter.setSuffixName(jsonProperties.getSuffixName());
        return converter;
    }
}
