package com.example.webs.service.impl;

import com.example.webs.dao.IPictureDao;
import com.example.webs.entity.PictureModel;
import com.example.webs.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.service.impl
 * @ClassName: PictureServiceImpl
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 23:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 23:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private IPictureDao dao;
    @Override
    public int addPicture(PictureModel model) throws Exception {
        return dao.addPicture(model);
    }
}