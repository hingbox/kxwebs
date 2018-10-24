package com.example.webs.controller;

import com.example.webs.entity.UrlModel;
import com.example.webs.service.IUrlService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.controller
 * @ClassName: UrlController
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 16:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 16:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
//@RestController
public class UrlController{
    //植入Service
    //@Resource(name = "urlService")
    @Autowired
    private IUrlService urlService;

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/home")
    public String getHome(){
        return "main";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll() throws Exception {
        List<UrlModel> list = urlService.findAll();
        return list;
    }

    @RequestMapping("/goAddPage")
    public String goAddPage(){
        return "addUrl";
    }

    //添加数据
    @RequestMapping(value="/addUrl",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String addUrl(UrlModel model, Model modelData) throws Exception {
        int count = urlService.addUrl(model);
        if (count>0){
            return "redirect:home";
        }else{
            modelData.addAttribute("erroMsg","添加失败");
            return "redirect:home";
        }
    }

    @RequestMapping("/goUpdatePage")
    @ResponseBody
    public Object goUpdatePage(int id) throws Exception {
        UrlModel air = urlService.selectOneById(id);
        return air;
    }

    @RequestMapping("/updateUrl")
    public String updateAir(UrlModel model) throws Exception {
        int count = urlService.updateUrl(model);
        return "redirect:home";
    }

    //按条件查询
    @RequestMapping("selectByCondition")
    @ResponseBody
    public Object selectByCondition(String url) throws Exception {
        List<UrlModel> list = urlService.findUrlByCondition(url);
        return list;
    }

    //分析
    @RequestMapping(value="/fenxi",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String fenxi(@RequestBody UrlModel model, Model modelData) throws Exception {
        String url = model.getUrl();
        //得到url地址  请求
        String reqJsonStr = "{\"url\":"+url+"}";
        HttpHeaders headers = new HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(reqJsonStr,headers);
        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        JSONObject responseBody  = new JSONObject(resp.getBody());
        modelData.addAttribute("erroMsg","添加失败");
        return responseBody.toString();

        //public List<UrlModel> getAll2() {
        //restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
//        //HttpHeaders headers = responseEntity.getHeaders();
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int code = statusCode.value();


//        //RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
//        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, null, Map.class);
//       // c = restTemplate.getForObject(url, UrlModel.class);
//        JSONObject responseBody  = new JSONObject(resp.getBody());
//        return responseBody.toString();

        }
        //

//        }

}