package com.example.webs.service.impl;

import com.example.webs.dao.IKeywordDao;
import com.example.webs.entity.KeywordModel;
import com.example.webs.service.IKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service.impl
 * @ClassName: KeywordServiceImpl
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 17:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 17:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class KeywordServiceImpl implements IKeywordService {
    @Autowired
    private IKeywordDao dao;

    @Override
    public List<KeywordModel> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public int addKeyword(KeywordModel model) throws Exception {
        return dao.addKeyword(model);
    }

    @Override
    public int updateKeyword(KeywordModel model) throws Exception {
        return dao.updateKeyword(model);
    }

    @Override
    public List<KeywordModel> findKeywordByCondition(String keyword) throws Exception {
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("keyword",keyword);
        return dao.findKeywordByCondition(map);
    }

    @Override
    public KeywordModel selectOneById(Integer id) throws Exception {
        return dao.selectOneById(id);
    }
}