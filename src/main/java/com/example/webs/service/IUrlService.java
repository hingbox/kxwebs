package com.example.webs.service;

import com.example.webs.entity.UrlModel;

import java.util.List;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service
 * @ClassName: IUrlService
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 16:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 16:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IUrlService {
    //查询所有
    public List<UrlModel> findAll() throws Exception;
    //添加
    public int addUrl(UrlModel model) throws Exception;
    //修改
    public int updateUrl(UrlModel model) throws Exception;
    //按条件查询
    public List<UrlModel> findUrlByCondition(String district) throws Exception;
    //根据编号查询对象的方法
    public UrlModel selectOneById(Integer id) throws Exception;
}