package com.example.webs.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.configuration
 * @ClassName: MyWebMvcConfigurerAdapter
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 23:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 23:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //指向外部目录
        registry.addResourceHandler("img//**").addResourceLocations("file:D:/tooles/");
        super.addResourceHandlers(registry);
    }

}