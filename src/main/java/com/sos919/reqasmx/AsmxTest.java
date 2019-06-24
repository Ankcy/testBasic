package com.sos919.reqasmx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsmxTest {

    public static void main(String[] args) throws IOException {
        // 1：创建服务地址
        URL url = new URL("http://wbgt.wxmktx.cn:8890/WebService1.asmx");
        // 2：打开到服务地址的一个连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 3：设置连接参数
        // 3.1设置发送方式：POST必须大写
        connection.setRequestMethod("POST");
        // 3.2设置数据格式：Content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        // 3.3设置输入输出，新创建的connection默认是没有读写权限的，
        connection.setDoInput(true);
        connection.setDoOutput(true);
        // 4：组织SOAP协议数据，发送给服务端
        String soapXML = getXML("dyfy", "123456");
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        // 5：接收服务端的响应
        int responseCode = connection.getResponseCode();
        if (200 == responseCode) {// 表示服务端响应成功
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String temp = null;
            while (null != (temp = br.readLine())) {
                sb.append(temp);
            }
            System.out.println(sb.toString());
            is.close();
            isr.close();
            br.close();
        }
        os.close();
    }
    
    public static String getXML(String loginName, String password){  
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"  
        +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"  
            +"<soap:Body>"  
            +"<GetData xmlns=\"http://tempuri.org/\">"  
                +"<LoginName>"+loginName+"</LoginName>"
                +"<Password>"+password+"</Password>"
            +"</GetData>"  
         +" </soap:Body>"  
        +"</soap:Envelope>";  
        return soapXML;  
    }
    
}