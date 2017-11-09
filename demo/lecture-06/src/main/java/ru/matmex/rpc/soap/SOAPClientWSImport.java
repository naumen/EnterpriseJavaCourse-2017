package ru.matmex.rpc.soap;

public class SOAPClientWSImport {
    public static void main(String[] args) {
        SOAPImplService helloService = new SOAPImplService();
        SOAPInterface hello = helloService.getSOAPImplPort();
        System.out.println(hello.sayHello("Magaz"));
    }
}
