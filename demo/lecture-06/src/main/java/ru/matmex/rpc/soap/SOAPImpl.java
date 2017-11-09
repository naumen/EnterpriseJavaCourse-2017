package ru.matmex.rpc.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.matmex.rpc.soap.SOAPInterface")
public class SOAPImpl implements SOAPInterface {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
