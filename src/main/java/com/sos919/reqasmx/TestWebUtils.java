package com.sos919.reqasmx;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestWebUtils {
    public static final String url = "http://wbgt.wxmktx.cn:8890/WebService1.asmx";

    public static void main(String[] args) {
        Object[] params = new Object[] { "dyfy", "123456" };
        String result = sendWebservice(params, url);
        System.out.println(result);
    }

    public static String sendWebservice(Object[] params, String url) {
        String soapaction = "http://tempuri.org/"; // 域名，这是在server定义的
        String operationName = "GetData";// 调用方法名
        Service service = new Service();
        String ret = "";
        try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setOperationName(new QName(soapaction, operationName)); // 设置要调用哪个方法
            call.addParameter(new QName(soapaction, "LoginName"), // 设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(soapaction, "Password"), // 设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            //call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapaction + operationName);
            // call.setReturnClass(String[].class);
            call.setReturnClass(org.w3c.dom.Element.class);
            ret = call.invoke(params).toString();// 调用方法并传递参数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}