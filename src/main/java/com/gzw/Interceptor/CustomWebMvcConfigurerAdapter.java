package com.gzw.Interceptor;

import com.gzw.Interceptor.GlobalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by shuai on 17/1/16.
 */
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");  //对来自/** 这个链接来的请求进行拦截
        //registry.addInterceptor(new CustomTypeInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/admin/**");
    }
}
