package com.nice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置bean
 */
// configuration 相当于 springBoot 的 applicationContext.xml
    // 如果 Controller 使用 RestController 那么就不用手动注入restTemplate
@Configuration
public class ConfigBean {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
