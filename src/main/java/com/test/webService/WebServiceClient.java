package com.test.webService;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WebServiceClient {
    public static void main(String[] args) {
        try {
            String endpoint = "http://localhost:8080/services/MyService?wsdl";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setEncodingStyle("UTF-8");
            call.setTargetEndpointAddress(endpoint);
            call.setOperationName(new javax.xml.namespace.QName("http://myService", "test"));
            call.addParameter("from", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);//接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
            String from = "孙志涛";
            String result = (String) call.invoke(new Object[]{from});//给方法传递参数，并且调用方法
            System.out.println("result is " + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
