package com.example.webs.dao;

import com.example.webs.entity.PictureModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.dao
 * @ClassName: IPictureDao
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 23:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 23:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Mapper
@Repository
public interface IPictureDao {
    //添加
    public int addPicture(PictureModel model) throws Exception;
}
