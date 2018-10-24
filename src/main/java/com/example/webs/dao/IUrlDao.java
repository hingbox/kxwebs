package com.example.webs.dao;

import com.example.webs.entity.UrlModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.dao
 * @ClassName: UrlDao
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 16:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 16:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Mapper
@Repository
public interface IUrlDao {
    //查询所有
    public List<UrlModel> findAll() throws Exception;
    //添加
    public int addUrl(UrlModel model) throws Exception;
    //修改
    public int updateUrl(UrlModel model) throws Exception;
    //按条件查询
    public List<UrlModel> findUrlByCondition(Map<String,Object> map) throws Exception;
    //根据编号查询对象的方法
    public UrlModel selectOneById(Integer id) throws Exception;
}