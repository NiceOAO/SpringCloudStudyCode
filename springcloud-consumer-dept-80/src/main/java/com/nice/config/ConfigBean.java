package com.nice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置bean
 * configuration 相当于 springBoot 的 applicationContext.xml
 * 如果 Controller 使用 RestController 那么就不用手动注入restTemplate
 * @author nice
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    /**
     * 负载均衡 LoadBalanced注解 可将restful进行负载均衡
     */
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
