package com.example.webs.controller;

import com.example.webs.entity.KeywordModel;
import com.example.webs.service.IKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.controller
 * @ClassName: KeywordController
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 23:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 23:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class KeywordController {
    @Autowired
    private IKeywordService keywordService;
    @RequestMapping("/goAddKeywordPage")
    public String goAddPage(){
        return "addKeyword";
    }

    //添加数据
    @RequestMapping(value="/addKeyword",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String addKeyword(KeywordModel model, Model modelData) throws Exception {
        int count = keywordService.addKeyword(model);
        if (count>0){
            return "redirect:home";
        }else{
            modelData.addAttribute("erroMsg","添加失败");
            return "redirect:home";
        }
    }
}