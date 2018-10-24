package com.example.webs.test;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName: webs
 * @Package: com.example.webs.test
 * @ClassName: TestDemo
 * @Description: java类作用描述
 * @Author: hingbox@163.com
 * @CreateDate: 2018/10/24 18:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/24 18:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestDemo {
    public static String SendGET(String url,String param){
        String result="";//访问返回结果
        BufferedReader read=null;//读取访问结果

        try {
            //创建url
            URL realurl=new URL(url+"?"+param);
            //打开连接
            URLConnection connection=realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段，获取到cookies等
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;//循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
            System.out.println("result"+result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(read!=null){//关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }



    public static void html2image(){
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr = "<table width='654' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF'><tr><td><img       src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr></table>";
        imageGenerator.loadHtml(htmlstr);
        imageGenerator.getBufferedImage();
        imageGenerator.saveAsImage("d:/hello-world.png");
        imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
    }

    public static void html2ImageTest(){
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr = "<table width='654' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF'><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr></table>";
        imageGenerator.loadHtml(htmlstr);
        imageGenerator.getBufferedImage();
        imageGenerator.saveAsImage("d:/hello-world.png");
        imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
    }
    //判断是否有特殊字符
    public static void specialChar(String  str) {
        //String str="判断的字符串";
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(str);
        System.out.println(m.find());
    }
    //判断是否有特殊字符
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }



    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[]a){
//        SendGET("http://www.baidu.com",null);
//        //html2ImageTest();
//        boolean c =isSpecialChar("你好");
//        System.out.println(c);
        System.out.println(isContainChinese("你好发电风扇是否是234234234"));
    }
}