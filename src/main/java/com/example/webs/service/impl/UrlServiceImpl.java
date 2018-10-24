package com.example.webs.service.impl;

import com.example.webs.dao.IUrlDao;
import com.example.webs.entity.UrlModel;
import com.example.webs.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service.impl
 * @ClassName: UrlServiceImpl
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 16:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 16:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
//@Service("urlService")
@Service
public class UrlServiceImpl implements IUrlService {
    //@Resource(name = "IUrlDao")
    @Autowired
    private IUrlDao dao;

    @Override
    public List<UrlModel> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int addUrl(UrlModel model) throws Exception {
        try {
            return dao.addUrl(model);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUrl(UrlModel model) throws Exception {
        return dao.updateUrl(model);
    }

    @Override
    public List<UrlModel> findUrlByCondition(String url) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("url",url);
        return dao.findUrlByCondition(map);
    }

    @Override
    public UrlModel selectOneById(Integer id) throws Exception {
        return dao.selectOneById(id);
    }
}