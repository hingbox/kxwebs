package com.example.webs.entity;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.entity
 * @ClassName: UrlModel
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 16:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 16:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UrlModel {
    private String id;
    private String url;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}