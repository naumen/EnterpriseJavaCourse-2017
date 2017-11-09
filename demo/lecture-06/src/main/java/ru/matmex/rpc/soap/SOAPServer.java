package ru.matmex.rpc.soap;

import javax.xml.ws.Endpoint;

public class SOAPServer {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new SOAPImpl());
    }

}