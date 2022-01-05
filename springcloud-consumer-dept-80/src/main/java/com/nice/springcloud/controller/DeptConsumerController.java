package com.nice.springcloud.controller;

import com.nice.config.ConfigBean;
import com.nice.springcloud.pojo.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者服务
 */
@RestController
public class DeptConsumerController {
    // 消费者没有service层， 通过url访问其他服务
    // RestTemplate ... 供调用，需要进行注册
    // (url, entity: Map, Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;
    // 提供http访问服务的方法，简单的模板

    // 获取微服务的信息
    @Autowired
    private DiscoveryClient client;

    private static final Logger logger = LoggerFactory.getLogger(DeptConsumerController.class);

    private static final String REST_URL_PREFIX = "http://localhost:8001/";

    @RequestMapping("/consumer/dept/add")
    public Boolean save(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "dept/save", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        // 需要调用服务
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/list", List.class);
    }

    // 注册进来的微服务
    @GetMapping("/service/discovery")
    public Object discovery(){
        // 获取微服务的清单
        List<String> service = client.getServices();
        logger.info("微服务 : {}",service);
        // 得到一个具体的微服务信息 applicationName
        List<ServiceInstance> serviceInstances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance s: serviceInstances) {
            logger.info("==============serviceInstances=========");
            logger.info("host:{}",s.getHost());
            logger.info("port:{}",s.getPort());
            logger.info("serviceId:{}",s.getServiceId());
            logger.info("uri:{}",s.getUri());
            logger.info("==============serviceInstances=========");
        }
        return this.client;
    }
}
