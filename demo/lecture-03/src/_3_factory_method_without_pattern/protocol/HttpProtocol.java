package _3_factory_method_without_pattern.protocol;


import _3_factory_method_without_pattern.message.HttpMessageSender;

public class HttpProtocol {

    public HttpMessageSender createHttpMessageSender(){
        return new HttpMessageSender();
    }

}
