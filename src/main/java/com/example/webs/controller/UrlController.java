package com.example.webs.controller;

import com.example.webs.entity.PictureModel;
import com.example.webs.entity.UrlModel;
import com.example.webs.service.IPictureService;
import com.example.webs.service.IUrlService;
import com.example.webs.test.PhantomTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @Autowired
    private IPictureService pictureService;

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
    //produces = "application/json;charset=UTF-8"
    @RequestMapping(value="/fenxi",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String fenxi(@RequestBody UrlModel model, Model modelData) throws Exception {
        String url = model.getUrl();
        String keywrod = model.getKeyword();
        //得到url地址  请求
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody().toString();
        int result = body.indexOf(keywrod);
        if (result>0){
            //生成url
            PhantomTools.printUrlScreen2jpg(url,keywrod);
            //同时存一份mysql中
            PictureModel pictureModel = new PictureModel();
            pictureModel.setPicture(keywrod+".png");
            pictureService.addPicture(pictureModel);
        }
        System.out.println("返回的结果"+result);
        //JSONObject responseBody  = new JSONObject(resp.getBody());
        //modelData.addAttribute("erroMsg","添加失败");

        return "redirect:home";
        }


}