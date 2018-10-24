package com.example.webs.http;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.test
 * @ClassName: TestDemo
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 18:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 18:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public WxMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);  //加入text/html类型的支持
        setSupportedMediaTypes(mediaTypes);// tag6
    }
}