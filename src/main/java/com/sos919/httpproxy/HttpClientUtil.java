package com.sos919.httpproxy;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class HttpClientUtil {
    // 依次是代理地址，代理端口号，用户密码
    private static String proxyHost = "192.168.1.140";
    private static int proxyPort = 1080;
    private static String proxyName = "";
    private static String proxyPwd = "xxx";


    public static String getWithProxy(String url, Map<String, String> headers, String charset) {
        String result = null;

        HttpHost proxy = new HttpHost(proxyHost, proxyPort, "http"); //添加代理，IP为本地IP 8888就是fillder的端口
        HttpClient httpClient = new DefaultHttpClient();  ;//添加代理
        httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY,proxy);
        try {
            // 创建httpGet
            HttpGet httpGet = new HttpGet(url);
            System.out.println("获取的url为:"+url);
            httpGet.setHeader("Connection", "keep-alive");
            //            httpGet.addHeader(new BasicHeader("Cookie", cookies));

            //代理
            //            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            //            httpGet.setConfig(config);

            System.out.println("executing request:" + httpGet.getURI());
            // 执行get请求
            HttpResponse response = httpClient.execute(httpGet);
                int code = response.getStatusLine().getStatusCode();
                System.out.println("返回的状态码:" + code);
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length" + entity.getContentLength());
                    // 打印响应内容
                    result = EntityUtils.toString(entity);
                    // 打印响应头
                    System.out.println("Response content" + entity.getContent());
                    System.out.println("Response Contentype" + entity.getContentType());
                    System.out.println("Response ContenEncoding" + entity.getContentEncoding());
                }
                System.out.println("--------------");
                Header[] hr = response.getAllHeaders();
                for (int i = 0; i < hr.length; i++) {
                    Header header1 = hr[i];
                    System.out.println("头部内容：" + header1);
                }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }


    public static void main(String []args){

        try
        {
            System.out.println("start = ");
            String data = HttpClientUtil.getWithProxy("https://www.google.com",null,"UTF-8");
            System.out.println("data = "+data);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}