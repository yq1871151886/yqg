package com.fh.utils;

import com.alibaba.fastjson.JSON;
import com.fh.enumbean.LoginCode;
import com.fh.enumbean.LoginEnum;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.ResponseServer;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpclientUtils {

    //不变的是声明http的客户端
    private static CloseableHttpClient httpClient;

    static {
        //创建httpclient，代码只执行一次。减少客户端创建的频率，节省服务器资源。
        //你是连接另一个服务器，连接超时设置。目的是不回因为接口调不通造成大量的线程挂起，最总造成堵塞，tomcat
        //直接崩溃。
        //setConnectionRequestTimeout:设置与服务器连接的超时时间
        //setSocketTimeout:设置访问接口的超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(15000).build();
        //创建Http请求的客户端
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
    }

    /**
     * 封装的post请求方法
     *
     * @param url
     * @param parameterMap
     * @return
     */
    public static String doPost(String url, Map<String, String> parameterMap) {
        //声明http请求的方式
        HttpPost httpPost = new HttpPost(url);
        //处理参数
        if (parameterMap != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            parameterMap.entrySet().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();
                list.add(new BasicNameValuePair(key, value));
            });
            try {
                //处理参数
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
                //将参数加入到http请求中
                httpPost.setEntity(urlEncodedFormEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //执行请求
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity,"UTF-8");
        } catch (HttpHostConnectException e) {
            e.printStackTrace();
            //服务器连接超时异常
            return JSON.toJSONString(LoginCode.error(LoginEnum.USER_ISNULL));
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return JSON.toJSONString(LoginCode.error(LoginEnum.LOGIN_SERVER_BUSYNESS));
        } catch (IOException e) {
            e.printStackTrace();
            return JSON.toJSONString(LoginCode.error(LoginEnum.ERROR));
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    public static String doGet(String url){
        HttpGet httpGet=new HttpGet(url);
        //执行请求
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity,"UTF-8");
        } catch (HttpHostConnectException e) {
            e.printStackTrace();
            //服务器连接超时异常
            return JSON.toJSONString(LoginCode.error(LoginEnum.LOGIN_CONTENT_LONG));
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return JSON.toJSONString(LoginCode.error(LoginEnum.LOGIN_SERVER_BUSYNESS));
        } catch (IOException e) {
            e.printStackTrace();
            return JSON.toJSONString(LoginCode.error(LoginEnum.ERROR));
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
