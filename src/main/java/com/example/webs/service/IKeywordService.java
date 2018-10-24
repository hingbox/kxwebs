package com.example.webs.service;

import com.example.webs.entity.KeywordModel;

import java.util.List;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service
 * @ClassName: IKeywordService
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 17:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 17:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IKeywordService {
    //查询所有
    public List<KeywordModel> findAll() throws Exception;
    //添加
    public int addKeyword(KeywordModel model) throws Exception;
    //修改
    public int updateKeyword(KeywordModel model) throws Exception;
    //按条件查询
    public List<KeywordModel> findKeywordByCondition(String district) throws Exception;
    //根据编号查询对象的方法
    public KeywordModel selectOneById(Integer id) throws Exception;
}