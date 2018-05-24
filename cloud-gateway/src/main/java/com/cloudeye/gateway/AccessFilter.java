package com.cloudeye.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lafangyuan on 2018/4/28.
 */

@Slf4j
public class AccessFilter extends ZuulFilter {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String result = restTemplate.postForObject("http://CLOUD-SYS/user/login",null,
                String.class);
        log.info("send {} request to {}--data {}",request.getMethod(),request.getRequestURL().toString(),result);
        return null;
    }

}
