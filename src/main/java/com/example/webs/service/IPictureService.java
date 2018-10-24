package com.example.webs.service;

import com.example.webs.entity.PictureModel;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service
 * @ClassName: IPictureService
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 23:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 23:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IPictureService {
    //添加
    public int addPicture(PictureModel model) throws Exception;
}
