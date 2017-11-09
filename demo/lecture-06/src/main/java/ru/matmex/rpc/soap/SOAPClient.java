package ru.matmex.rpc.soap;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SOAPClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://soap.rpc.matmex.ru/", "SOAPImplService");
        Service service = Service.create(url, qname);
        SOAPInterface hello = service.getPort(SOAPInterface.class);
        System.out.println(hello.sayHello("Magaz"));
    }
}
