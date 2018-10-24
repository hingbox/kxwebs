package com.example.webs.dao;

import com.example.webs.entity.KeywordModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.dao
 * @ClassName: IKeywordDao
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 17:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 17:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Mapper
@Repository
public interface IKeywordDao {
    //查询所有
    public List<KeywordModel> findAll() throws Exception;
    //添加
    public int addKeyword(KeywordModel model) throws Exception;
    //修改
    public int updateKeyword(KeywordModel model) throws Exception;
    //按条件查询
    public List<KeywordModel> findKeywordByCondition(Map<String,Object> map) throws Exception;
    //根据编号查询对象的方法
    public KeywordModel selectOneById(Integer id) throws Exception;
}