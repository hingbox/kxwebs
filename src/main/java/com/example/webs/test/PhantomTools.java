package com.example.webs.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.test
 * @ClassName: PhantomTools
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 21:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 21:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PhantomTools {
    private static String tempPath = "D:/tooles";// 图片保存目录
    private static String BLANK = " ";
    // 下面内容可以在配置文件中配置
    private static String binPath = "D:/tooles/phantomjs-2.1.1-windows/bin/phantomjs.exe";// 插件引入地址
    private static String jsPath = "D:/tooles/phantomjs-2.1.1-windows/examples/rasterize.js";// js引入地址

    // 执行cmd命令
    public static String cmd(String imgagePath, String url) {
        return binPath + BLANK + jsPath + BLANK + url + BLANK + imgagePath;
    }
    //关闭命令
    public static void close(Process process, BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (process != null) {
            process.destroy();
            process = null;
        }
    }
    /**
     * @param
     * @param url
     * @throws IOException
     */
    //System.currentTimeMillis()
    public static void printUrlScreen2jpg(String url,String keyword) throws IOException{
        String imgagePath = tempPath+"/"+keyword+".png";//图片路径
        //Java中使用Runtime和Process类运行外部程序
        Process process = Runtime.getRuntime().exec(cmd(imgagePath,url));
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = "";
        while ((tmp = reader.readLine()) != null) {
            close(process,reader);
        }
        System.out.println("success");
    }

    public static void main(String[] args) throws IOException {
        String url = "https://blog.csdn.net/kinginblue/article/details/52706155";//以百度网站首页为例
        PhantomTools.printUrlScreen2jpg(url,"博客");
    }
}